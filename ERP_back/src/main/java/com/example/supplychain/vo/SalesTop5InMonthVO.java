package com.example.supplychain.vo;

import java.util.List;

public class SalesTop5InMonthVO {

    /**
     * 年份
     */
    String year;

    /**
     * 月份
     */
    String month;

    /**
     * 成品
     */
    List<String> commocity;

    /**
     * 比率
     */
    List<Double> rate;

    public SalesTop5InMonthVO(String year, String month, List<String> commocity, List<Double> rate) {
        this.year = year;
        this.month = month;
        this.commocity = commocity;
        this.rate = rate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<String> getCommocity() {
        return commocity;
    }

    public void setCommocity(List<String> commocity) {
        this.commocity = commocity;
    }

    public List<Double> getRate() {
        return rate;
    }

    public void setRate(List<Double> rate) {
        this.rate = rate;
    }
}
