package com.example.discount;

public class ReturnJourneyDiscount implements Discount {

    @Override
    public float discountApply(float discountValue) {
        return discountValue*50/100;
    }
}
