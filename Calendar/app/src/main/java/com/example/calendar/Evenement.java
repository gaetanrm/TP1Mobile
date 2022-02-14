package com.example.calendar;

public class Evenement{

    private int day, month, year, hour;
    private String title, descr;

    public Evenement(int day, int month, int year, int hour, String title, String descr) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.title = title;
        this.descr = descr;
    }
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public int getHour() {
        return hour;
    }
    public String getTitle() {
        return title;
    }
    public String getDescr() {
        return descr;
    }
}
