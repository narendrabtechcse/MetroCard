package com.example.discount;

import java.util.ArrayList;
import java.util.List;

public class DiscountHelper {
    List<Discount> discountList = new ArrayList<>();
    public DiscountHelper()
    {
        discountList.add(new ReturnJourneyDiscount());
    }

    public float applyDiscounts(float valueOfFare)
    {
        //iterate list and call each discount
        float discountValue=0;
        for(Discount discount:discountList) {
            discountValue = discount.discountApply(valueOfFare);
            valueOfFare = valueOfFare - discountValue;
        }

        return discountValue;
    }
}
