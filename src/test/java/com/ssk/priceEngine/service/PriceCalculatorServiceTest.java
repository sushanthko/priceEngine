package com.ssk.priceEngine.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PriceCalculatorServiceTest {

    @Test
    void calculatePrice() {
        double calculated = PriceCalculatorService.calculatePrice(25, 20, 175);
        double calculatedWithDiscount = PriceCalculatorService.calculatePrice(100, 5, 825);

        assertThat(calculated).isEqualTo(231.875);
        assertThat(calculatedWithDiscount).isEqualTo(14850);
    }

}