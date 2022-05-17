package com.example.priceBasket.model;

import java.util.LinkedList;
import java.util.List;

public class Basket {

    private List<Product> products = new LinkedList<Product>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "products=" + products +
                '}';
    }
}
