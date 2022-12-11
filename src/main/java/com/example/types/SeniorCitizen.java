package com.example.types;

public class SeniorCitizen implements Type{
    @Override
    public float valueOfType() {
        return 100;
    }

    @Override
    public String nameOfType() {
        return "SeniorCitizen";
    }
}
