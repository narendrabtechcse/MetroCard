package com.example.masterCard;

public class MasterCard {
    String nameOfCard;
    float balanceInCard=0;
    String lastStation;

    public MasterCard(String nameOfCard , float balanceInCard)
    {
        this.nameOfCard = nameOfCard;
        this.balanceInCard = balanceInCard;
    }

    public float getBalanceInCard() {
        return balanceInCard;
    }

    public void setBalanceInCard(float balanceInCard) {
        this.balanceInCard = balanceInCard;
    }

    public String getNameOfCard() {
        return nameOfCard;
    }

    public void setNameOfCard(String nameOfCard) {
        this.nameOfCard = nameOfCard;
    }

    public String getLastStation() {
        return lastStation;
    }

    public void setLastStation(String lastStation) {
        this.lastStation = lastStation;
    }
}
