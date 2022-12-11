package com.example.admin;

import com.example.station.Station;
import com.example.types.ADULT;
import com.example.types.KIDS;
import com.example.types.SeniorCitizen;
import com.example.types.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LoadMetroApplication {
    static Map<String, Station> stationsMap = new HashMap<String , Station>();
    static Map<String , Type> typeMap = new TreeMap<>();
    public static Map loadStations()
    {
        Station CENTRAL = new Station("CENTRAL");
        Station AIRPORT = new Station("AIRPORT");
        Station MARATHALLI = new Station("MARATHALLI");

        stationsMap.put("CENTRAL",CENTRAL);
        stationsMap.put("AIRPORT",AIRPORT);
        stationsMap.put("MARATHALLI",MARATHALLI);

        return stationsMap;
    }

    public static Map<String, Type> loadUserTypes() {
        typeMap.put("ADULT",new ADULT());
        typeMap.put("KID",new KIDS());
        typeMap.put("SENIOR_CITIZEN",new SeniorCitizen());

        return typeMap;
    }
}
