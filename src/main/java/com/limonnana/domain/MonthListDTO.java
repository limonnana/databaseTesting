package com.limonnana.domain;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MonthListDTO {

    private Long id;
    private Month name;
    private int year;
    private int from;
    private int untill;
    private Map<MonthListDTOMapKey, List<UnitOfCalendar>> m = new TreeMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public Map<MonthListDTOMapKey, List<UnitOfCalendar>> getM() {
        return m;
    }

    public void setM(Map<MonthListDTOMapKey, List<UnitOfCalendar>> m) {
        this.m = m;
    }
}
