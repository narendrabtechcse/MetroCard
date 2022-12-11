package com.example.station;

import com.example.types.Type;

import java.util.HashMap;
import java.util.Map;

public class Station {
    String stationName;
    float totalDiscountGiven;
    float totalAmountCollected;
    Map<Type,Integer> countOfTypes = new HashMap<>();

    public Station(String stationName)
    {
        this.stationName = stationName;
    }

    public float getTotalAmountCollected() {
        return totalAmountCollected;
    }

    public void setTotalAmountCollected(float totalAmountCollected) {
        this.totalAmountCollected = totalAmountCollected;
    }

    public float getTotalDiscountGiven() {
        return totalDiscountGiven;
    }

    public void setTotalDiscountGiven(float totalDiscountGiven) {
        this.totalDiscountGiven = totalDiscountGiven;
    }

    public Map<Type, Integer> getCountOfTypes() {
        return countOfTypes;
    }

    public void setCountOfTypes(Map<Type, Integer> countOfTypes) {
        this.countOfTypes = countOfTypes;
    }
}
