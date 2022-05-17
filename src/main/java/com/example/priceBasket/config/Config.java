package com.example.priceBasket.config;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.example.priceBasket.model.Discount;
import com.example.priceBasket.model.Product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Map<String, Product> products() {
        Product apple = new Product("apple", new BigDecimal("0.60"));
        Product milk = new Product("milk", new BigDecimal("1.30"));
        Product soup = new Product("soup", new BigDecimal("1.00"));
        Product bread = new Product("bread", new BigDecimal("0.80"));

        Map<String, Product> products = new HashMap<>();
        products.put("apple", apple);
        products.put("milk", milk);
        products.put("soup", soup);
        products.put("bread", bread);

        return products;
    }

    @Bean
    public List<Discount> discounts() {
        Product apple = products().get("apple");
        Product bread = products().get("bread");
        Product soup = products().get("soup");

        Discount appleDiscount = new Discount("appleDiscount", new BigDecimal("0.10"), apple);
        Discount breadDiscount = new Discount("breadDiscount", new BigDecimal("0.5"), bread,
                new HashMap<Product, Integer>() {
                    {
                        put(soup, 2);
                    }
                });

        return new LinkedList<Discount>(Arrays.asList(appleDiscount, breadDiscount));
    }
}
