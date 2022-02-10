package com.example.supplychain.po;

import java.util.Date;

/**
 * 对应数据库中purchase_application_c表
 */
public class PurchaseApplicationC {
    String id;
    Date subDate;
    String managerName;
    String state;

    public PurchaseApplicationC(String id, Date subDate, String managerName, String state) {
        this.id = id;
        this.subDate = subDate;
        this.managerName = managerName;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getSubDate() {
        return subDate;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}