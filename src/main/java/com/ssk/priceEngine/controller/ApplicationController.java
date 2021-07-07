package com.ssk.priceEngine.controller;

import com.ssk.priceEngine.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

}
