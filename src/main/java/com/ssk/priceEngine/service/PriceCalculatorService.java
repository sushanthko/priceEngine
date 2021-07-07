package com.ssk.priceEngine.service;

public class PriceCalculatorService {

    /**
     * @param units          number of units purchased
     * @param unitsPerCarton number of units per carton of the product
     * @param cartonPrice    price of a carton of the product
     * @return total purchase price
     */
    public static double calculatePrice(long units, long unitsPerCarton, double cartonPrice) {
        double newCartonPrice = cartonPrice;
        long cartons = units / unitsPerCarton;

        if (cartons >= 3)
            newCartonPrice *= 0.9;

        return newCartonPrice * (cartons + units % unitsPerCarton * 1.3 / unitsPerCarton);
    }

}
