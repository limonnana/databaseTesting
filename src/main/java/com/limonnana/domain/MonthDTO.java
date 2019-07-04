package com.limonnana.domain;

import java.time.Month;

public class MonthDTO {

    /*
     public id?: number,
        public name?: string,
        public year?: number,
        public day?: number,
        public userLogin?: string,
        public from?: number,
        public untill?: number
     */

    private Long id;
    private String name;
    private int year;
    private int day;
    private String userLogin;
    private int from;
    private int untill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
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
}
