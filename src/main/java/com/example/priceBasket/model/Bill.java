package com.example.priceBasket.model;

import java.math.BigDecimal;
import java.util.List;

public class Bill {
    private BigDecimal totalPrice;
    private List<Discount> appliedDiscounts;
    private BigDecimal finalSum;

    public Bill(BigDecimal totalPrice, List<Discount> appliedDiscounts, BigDecimal finalSum) {
        this.totalPrice = totalPrice;
        this.appliedDiscounts = appliedDiscounts;
        this.finalSum = finalSum;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Discount> getAppliedDiscounts() {
        return appliedDiscounts;
    }

    public void setAppliedDiscounts(List<Discount> appliedDiscounts) {
        this.appliedDiscounts = appliedDiscounts;
    }

    public BigDecimal getFinalSum() {
        return finalSum;
    }

    public void setFinalSum(BigDecimal finalSum) {
        this.finalSum = finalSum;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "totalPrice=" + totalPrice +
                ", appliedDiscounts=" + appliedDiscounts +
                ", finalSum=" + finalSum +
                '}';
    }
}
