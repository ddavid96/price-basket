package com.example.priceBasket.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Discount {
    private String name;
    private BigDecimal discount;
    private Product product;
    private Map<Product, Integer> requiredProducts;

    public Discount(String name, BigDecimal discount, Product product, Map<Product, Integer> requiredProducts) {
        this.name = name;
        this.discount = discount;
        this.product = product;
        this.requiredProducts = requiredProducts;
    }

    public Discount(
            String name,
            BigDecimal discount,
            Product product) {
        this.name = name;
        this.discount = discount;
        this.product = product;
        this.requiredProducts = new HashMap<Product, Integer>();
    }

    public String getName() {
        return name;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public Product getProduct() {
        return product;
    }

    public Map<Product, Integer> getRequiredProducts() {
        return requiredProducts;
    }

    public boolean isApplicable(Map<Product, Integer> products) {
        for (Product requiredProduct : requiredProducts.keySet()) {
            if (products.get(requiredProduct) == null) {
                return false;
            }
            if (products.get(requiredProduct) < requiredProducts.get(requiredProduct)) {
                return false;
            }
        }
        for (Product requiredProduct : requiredProducts.keySet()) {
            Integer originalValue = products.get(requiredProduct);
            products.put(requiredProduct, originalValue - requiredProducts.get(requiredProduct));
        }
        return true;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "name='" + name + '\'' +
                ", discount=" + discount +
                ", product=" + product +
                ", requiredProducts=" + requiredProducts +
                '}';
    }

}
