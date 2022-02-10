package com.example.supplychain.vo;

public class SalesBasicInfoVO {

    /**
     * 销售总金额
     */
    Double totalSale;

    /**
     * 总订单数
     */
    int orderCount;

    /**
     * 该门店的商品总数
     */
    int commodityCount;

    public SalesBasicInfoVO(Double totalSale, int orderCount, int commodityCount) {
        this.totalSale = totalSale;
        this.orderCount = orderCount;
        this.commodityCount = commodityCount;
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

    public int getCommodityCount() {
        return commodityCount;
    }

    public void setCommodityCount(int commodityCount) {
        this.commodityCount = commodityCount;
    }
}
