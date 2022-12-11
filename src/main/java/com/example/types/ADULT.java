package com.example.types;

public class ADULT implements Type{
    @Override
    public float valueOfType() {
        return 200;
    }

    @Override
    public String nameOfType() {
        return "ADULT";
    }
}
