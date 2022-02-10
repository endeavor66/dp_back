package com.example.supplychain.vo;

import com.example.supplychain.po.SalesList;

import java.util.List;

public class SalesRecentVO {

    /**
     * 销售总金额
     */
    Double totalSale;

    /**
     * 总订单数
     */
    int orderCount;

    /**
     * 销量前十的成品
     */
    List<String> commocity;

    /**
     * 销量前十的成品的比率
     */
    List<Double> rate;


    /**
     * 预测与实际的对比
     */
    List<String> times;

    List<Double> actual;

    List<Double> predict;

    /**
     * 销售记录
     */
    List<SalesList> salesLists;

    public SalesRecentVO() {

    }

    public Double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(Double totalSale) {
        this.totalSale = totalSale;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public List<SalesList> getSalesLists() {
        return salesLists;
    }

    public void setSalesLists(List<SalesList> salesLists) {
        this.salesLists = salesLists;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public List<Double> getActual() {
        return actual;
    }

    public void setActual(List<Double> actual) {
        this.actual = actual;
    }

    public List<Double> getPredict() {
        return predict;
    }

    public void setPredict(List<Double> predict) {
        this.predict = predict;
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
