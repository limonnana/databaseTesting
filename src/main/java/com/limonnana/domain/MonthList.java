package com.limonnana.domain;

import javax.persistence.*;
import java.util.Map;
import java.util.TreeMap;
import java.time.Month;


public class MonthList {


    private Long id;

    private Month name;
    private int year;
    private int from;
    private int untill;

    private Map<Integer, ListWrapper> m = new TreeMap<>();

    public MonthList(){}

    public MonthList(int year, Month name, int from, int untill){

        this.year = year;
        this.name = name;
        this.from = from;
        this.untill = untill;
    }

    public Month getName() {
        return name;
    }

    public void setName(Month name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Map<Integer, ListWrapper> getM() {
        return m;
    }

    public void setM(Map<Integer, ListWrapper> m) {
        this.m = m;
    }
}
