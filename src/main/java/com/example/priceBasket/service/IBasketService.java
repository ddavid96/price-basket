package com.example.priceBasket.service;

import com.example.priceBasket.model.Basket;
import com.example.priceBasket.model.Bill;

public interface IBasketService {
    public Bill getBill(Basket basket);
}
