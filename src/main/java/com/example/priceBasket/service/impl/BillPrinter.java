package com.example.priceBasket.service.impl;

import java.math.BigDecimal;

import com.example.priceBasket.model.Bill;
import com.example.priceBasket.model.Discount;
import com.example.priceBasket.service.IBillPrinter;

import org.springframework.stereotype.Service;

@Service
public class BillPrinter implements IBillPrinter {

    @Override
    public void printBill(Bill bill) {
        System.out.println("Subtotal: " + bill.getTotalPrice());
        if (bill.getAppliedDiscounts().isEmpty()) {
            System.out.println("No discounts applied");
        }
        for (Discount discount : bill.getAppliedDiscounts()) {
            System.out.println(formatDiscount(discount));
        }
        System.out.println("Total: " + bill.getFinalSum());
    }

    private String formatDiscount(Discount discount) {
        String productName = discount.getProduct().getName();
        String percentageOff = discount.getDiscount().movePointRight(2).toString();
        BigDecimal discountValue = discount.getDiscount();
        return productName + " " + percentageOff + "% off -" + discountValue;
    }

}
