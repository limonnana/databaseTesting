package com.limonnana.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

/*
This class is intended to use in a ordered fashion units, thus some spaces will be empty but still occupied space.
The opposite will be the case for the linkedlist, that will occupied only those spaces thar are being used.

 */
public class MonthArrayOrder {

    private  java.time.Month name;
    private  int year;
    private  int from;
    private  int untill;
    private  int amountMaximunUnitsPerDay;
    private  Map<Integer, UnitOfCalendar[]> m  = new TreeMap<>();

    public MonthArrayOrder(){}

    public MonthArrayOrder getMonth(java.time.Month name, int year, int amountMaximunUnitsPerDay){

        MonthArrayOrder monthArrayOrder = new MonthArrayOrder();
        LocalDate ld = LocalDate.of(year, name, 1);
        monthArrayOrder.setFrom(1);
        monthArrayOrder.setName(name);
        monthArrayOrder.setUntill(ld.lengthOfMonth());
        monthArrayOrder.setYear(year);
        for(int i = 1; i<= monthArrayOrder.getUntill(); i++){
            UnitOfCalendar[] units = new UnitOfCalendar[amountMaximunUnitsPerDay];
            monthArrayOrder.getM().put(i, units);
        }

        return monthArrayOrder;
    }


    public MonthArrayOrder getCurrentMonth(int amountMaximunUnitsPerDay){
        MonthArrayOrder monthArrayOrder = new MonthArrayOrder();
        LocalDateTime now = LocalDateTime.now();
        int yearCurrent = now.getYear();
        int day = now.getDayOfMonth();
        monthArrayOrder.setName(now.getMonth());
        monthArrayOrder.setFrom(day);
        monthArrayOrder.setUntill(LocalDate.now().lengthOfMonth());
        monthArrayOrder.setYear(yearCurrent);

        for(int i = day; i<= monthArrayOrder.getUntill(); i++){
            UnitOfCalendar[] units = new UnitOfCalendar[amountMaximunUnitsPerDay];
            monthArrayOrder.getM().put(i, units);
        }

        return monthArrayOrder;
    }


    public java.time.Month getName() {
        return name;
    }

    public void setName(java.time.Month name) {
        this.name = name;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getUntill() {
        return untill;
    }

    public void setUntill(int untill) {
        this.untill = untill;
    }



    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public int getAmountMaximunUnitsPerDay() {
        return amountMaximunUnitsPerDay;
    }

    public void setAmountMaximunUnitsPerDay(int amountMaximunUnitsPerDay) {
        this.amountMaximunUnitsPerDay = amountMaximunUnitsPerDay;
    }

    public Map<Integer, UnitOfCalendar[]> getM() {
        return m;
    }

    public void setM(Map<Integer, UnitOfCalendar[]> m) {
        this.m = m;
    }

    @Override
    public String toString() {
        String result = "";
        result = "month: " + name + " ," +
            " year: " + year + " , " +
            " from: " + from + " untill: " + untill + " mapSize: " + getM().size();
        return result;
    }
}
