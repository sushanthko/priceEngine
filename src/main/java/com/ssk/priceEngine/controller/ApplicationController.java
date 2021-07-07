package com.ssk.priceEngine.controller;

import com.ssk.priceEngine.repository.ProductRepository;
import com.ssk.priceEngine.service.PriceCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ApplicationController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @PostMapping
    @ResponseBody
    public double calculateTotalPrice(@RequestBody Map<String, Number> input) {
        return PriceCalculatorService.calculatePrice(
                input.get("units").longValue(),
                input.get("unitsPerCarton").longValue(),
                input.get("cartonPrice").doubleValue()
        );
    }

}
