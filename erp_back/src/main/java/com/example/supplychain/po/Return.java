package com.example.supplychain.po;

public class Return {

    /**
     * 退货申请id
     */
    String id;

    /**
     * 销售订单id
     */
    String salesId;

    /**
     * 退货日期
     */
    String date;


    /**
     * 退货原因
     */
    String  reason;

    public Return(String id, String salesId, String date, String reason) {
        this.id = id;
        this.salesId = salesId;
        this.date = date;
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
