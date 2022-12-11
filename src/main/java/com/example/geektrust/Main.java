package com.example.geektrust;

import com.example.admin.LoadMetroApplication;
import com.example.discount.DiscountHelper;
import com.example.discount.ReturnJourneyDiscount;
import com.example.masterCard.MasterCard;
import com.example.station.Station;
import com.example.types.Type;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<String , MasterCard> metroCards = new HashMap<>();
    static Map<String, Station> stationsMap;
    static Map<String, Type> userTypeMap;
    public static void main(String[] args) {
        try {
            File myObj = new File("input1.txt");
            Scanner myReader = new Scanner(myObj);
            stationsMap = LoadMetroApplication.loadStations();
            userTypeMap = LoadMetroApplication.loadUserTypes();

            while (myReader.hasNextLine()) {
                String command = myReader.nextLine();
                System.out.println(command);

                if(command.startsWith("BALANCE"))
                {
                    String[] details = command.split(" ");
                    String nameOfCard=details[1];
                    float balanceInCard = Float.valueOf(details[2]);
                    MasterCard masterCard = new MasterCard(nameOfCard,balanceInCard);
                    metroCards.put(nameOfCard,masterCard);
                }else if(command.startsWith("CHECK_IN"))
                {
                    String[] details = command.split(" ");
                    String nameOfCard=details[1];

                    MasterCard masterCardUse = metroCards.get(nameOfCard);
                    String userType = details[2];
                    Type type = userTypeMap.get(userType);

                    String stationName = details[3];
                    Station station = stationsMap.get(stationName);

                    if(checkSufficientBalanceToMakeJourney(masterCardUse , type)) {
                        float fairAmount = calculateFare(masterCardUse,type);
                        station.setTotalAmountCollected(station.getTotalAmountCollected()+fairAmount);
                        masterCardUse.setLastStation(stationName);
                        //update type count with station
                        Map<Type,Integer> mapType = station.getCountOfTypes();
                        mapType.put(type,mapType.getOrDefault(type,0)+1);
                        station.setCountOfTypes(mapType);
                    }else{
                        System.out.println("Not Sufficient Balance please recharge !!");
                        rechargeTheCard(station,type,masterCardUse);
                    }


                }else if(command.startsWith("PRINT_SUMMARY"))
                {
                    printAmountCollectedAndDiscountGivenPerStation();
                }


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void printAmountCollectedAndDiscountGivenPerStation() {
        for (Map.Entry<String, Station> entry : stationsMap.entrySet()) {
            String stationName = entry.getKey();
            Station station = entry.getValue();

            System.out.println("TOTAL_COLLECTION");
            System.out.print("Station Name    |   ");
            System.out.print("Amount Collected    |   ");
            System.out.print("Total Discount Given    ");
            System.out.println();
            System.out.print(stationName+"    |       ");
            System.out.print(station.getTotalAmountCollected()+"    |       ");
            System.out.print(station.getTotalDiscountGiven()+"         ");

            System.out.println("PASSENGER_TYPE_SUMMARY");
            System.out.print("Type        |        ");
            System.out.print("COUNT        |       ");

            for (Map.Entry<Type, Integer> countTypes : station.getCountOfTypes().entrySet())
            System.out.print(countTypes.getKey() + "       :       " + countTypes.getValue());

        }
    }

    private static void rechargeTheCard(Station station, Type type, MasterCard masterCardUse) {
        masterCardUse.setBalanceInCard(type.valueOfType() + masterCardUse.getBalanceInCard());
        station.setTotalAmountCollected(station.getTotalAmountCollected()+type.valueOfType());
        station.setTotalDiscountGiven(station.getTotalDiscountGiven() + type.valueOfType()*2/100);
    }

    private static boolean checkSufficientBalanceToMakeJourney(MasterCard masterCardUse, Type type) {
        if(masterCardUse.getBalanceInCard() >= type.valueOfType())
            return true;
        else
            return false;
    }

    private static float calculateFare(MasterCard masterCardUse, Type type) {

       if(masterCardUse.getLastStation()!=null && !masterCardUse.getLastStation().isEmpty())
       {
           DiscountHelper discountHelper = new DiscountHelper();
           return discountHelper.applyDiscounts(type.valueOfType());
       }else{
           return type.valueOfType();
       }
    }
}
