package com.example.supplychain.vo;

import java.util.List;

public class SalesTrendRecentYearsVO {

    /**
     * 年份
     */
    List<String> year;

    /**
     * 销售额趋势
     */
    List<Double> trend;

    public SalesTrendRecentYearsVO(List<String> year, List<Double> trend) {
        this.year = year;
        this.trend = trend;
    }

    public List<String> getYear() {
        return year;
    }

    public void setYear(List<String> year) {
        this.year = year;
    }

    public List<Double> getTrend() {
        return trend;
    }

    public void setTrend(List<Double> trend) {
        this.trend = trend;
    }
}
