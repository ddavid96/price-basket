package com.example.priceBasket.service;

import java.util.List;

import com.example.priceBasket.model.Discount;
import com.example.priceBasket.model.Product;

public interface IProductService {
    Product getProduct(String productName);

    List<Discount> getDiscounts(Product product);
}
