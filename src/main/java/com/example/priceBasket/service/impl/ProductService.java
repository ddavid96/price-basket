package com.example.priceBasket.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.priceBasket.model.Discount;
import com.example.priceBasket.model.Product;
import com.example.priceBasket.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private Map<String, Product> products;

    @Autowired
    private List<Discount> discounts;

    @Override
    public Product getProduct(String productName) {
        return products.get(productName);
    }

    @Override
    public List<Discount> getDiscounts(Product product) {
        return discounts.stream()
                .filter(discount -> discount.getProduct().equals(product))
                .collect(Collectors.toList());
    }

}
