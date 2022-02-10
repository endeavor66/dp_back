package com.example.supplychain.po;

import java.util.Date;

public class PurchaseApplicationUpdate {
    String id;
    Date subDate;
    String managerName;

    public PurchaseApplicationUpdate(String id, Date subDate, String managerName) {
        this.id = id;
        this.subDate = subDate;
        this.managerName = managerName;
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
}
