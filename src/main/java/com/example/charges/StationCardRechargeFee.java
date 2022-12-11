package com.example.charges;

public class StationCardRechargeFee implements FeeCharged{
    @Override
    public float feeCharged(float totalAmount) {
        return totalAmount*2/100;
    }
}
