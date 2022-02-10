package com.example.supplychain.vo;

import java.util.List;

public class SalesTrendVO {

    /**
     * 类型
     */
    String type;

    /**
     * 单位
     */
    List<String> time;

    /**
     * 销售额趋势
     */
    List<Double> trend;

    public SalesTrendVO(String type, List<String> time, List<Double> trend) {
        this.type = type;
        this.time = time;
        this.trend = trend;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<Double> getTrend() {
        return trend;
    }

    public void setTrend(List<Double> trend) {
        this.trend = trend;
    }
}
