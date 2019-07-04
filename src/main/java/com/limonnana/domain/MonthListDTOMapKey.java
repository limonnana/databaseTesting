package com.limonnana.domain;


import com.google.gson.Gson;

import java.time.DayOfWeek;

public class MonthListDTOMapKey implements  Comparable{

    private Integer dayNumber;
    private String dayName;

    public Integer getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    @Override
    public int compareTo(Object monthListDTOMapKey) {
        int result = 0;

        if(monthListDTOMapKey instanceof MonthListDTOMapKey){
            MonthListDTOMapKey key = (MonthListDTOMapKey)monthListDTOMapKey;
            if(key.getDayNumber()> dayNumber.intValue()){
                result = -1;
            }else if(key.getDayNumber()< dayNumber.intValue()){
                result = 1;
            }
        }

        return result;
    }


    @Override
    public String toString() {

        MonthListDTOMapKey monthListDTOMapKey = new MonthListDTOMapKey();
        monthListDTOMapKey.setDayNumber(getDayNumber());
        monthListDTOMapKey.setDayName(getDayName());

        Gson gson = new Gson();
        String json = gson.toJson(monthListDTOMapKey);
       // String clean = json.replace("\"", "");
        return gson.toJson(monthListDTOMapKey).toString();
    }
}
