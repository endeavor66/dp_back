package com.example.supplychain.vo;

import java.util.List;

public class SalesTop10InYearVO {

    /**
     * 年份
     */
    String year;

    /**
     * 成品名字
     */
    List<String> commocity;

    /**
     * 比率
     */
    List<Double> rate;

    public SalesTop10InYearVO(String year, List<String> commocity, List<Double> rate) {
        this.year = year;
        this.commocity = commocity;
        this.rate = rate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
