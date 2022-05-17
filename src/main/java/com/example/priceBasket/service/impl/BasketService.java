package com.example.priceBasket.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.priceBasket.model.Basket;
import com.example.priceBasket.model.Bill;
import com.example.priceBasket.model.Discount;
import com.example.priceBasket.model.Product;
import com.example.priceBasket.service.IBasketService;
import com.example.priceBasket.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService implements IBasketService {

    @Autowired
    private ProductService productService;

    @Override
    public Bill getBill(Basket basket) {
        BigDecimal totalPrice = calculateTotalPrice(basket);
        List<Discount> appliedDiscounts = getApplicableDiscounts(basket);
        BigDecimal finalPrice = getFinalPrice(totalPrice, appliedDiscounts);

        return new Bill(totalPrice, appliedDiscounts, finalPrice);
    }

    private BigDecimal calculateTotalPrice(Basket basket) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Product product : basket.getProducts()) {
            totalPrice = totalPrice.add(product.getPrice());
        }
        return totalPrice;
    }

    private List<Discount> getApplicableDiscounts(Basket basket) {
        List<Discount> applicableDiscounts = new LinkedList<Discount>();
        Map<Product, Integer> productCountMap = getProductCountMap(basket);

        for (Product product : basket.getProducts()) {
            List<Discount> discounts = Utils.collectionToStream(productService.getDiscounts(product))
                    .filter(discount -> discount.isApplicable(productCountMap))
                    .collect(Collectors.toList());
            applicableDiscounts.addAll(discounts);
        }

        return applicableDiscounts;
    }

    private BigDecimal getFinalPrice(BigDecimal totalPrice, List<Discount> appliedDiscounts) {
        BigDecimal finalPrice = totalPrice;
        for (Discount discount : appliedDiscounts) {
            finalPrice = finalPrice.subtract(discount.getDiscount());
        }
        return finalPrice;
    }

    private Map<Product, Integer> getProductCountMap(Basket basket) {
        Map<Product, Integer> productCountMap = new HashMap<>();
        for (Product product : basket.getProducts()) {
            if (productCountMap.containsKey(product)) {
                productCountMap.put(product, productCountMap.get(product) + 1);
            } else {
                productCountMap.put(product, 1);
            }
        }
        return productCountMap;
    }
}
