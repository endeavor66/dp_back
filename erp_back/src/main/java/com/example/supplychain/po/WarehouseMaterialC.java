package com.example.supplychain.po;

import java.util.Date;

public class WarehouseMaterialC {
    String id;
    String materialName;
    int quantity;
    Date inDate;

    public WarehouseMaterialC(String id, String materialName, int quantity, Date inDate) {
        this.id = id;
        this.materialName = materialName;
        this.quantity = quantity;
        this.inDate = inDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }
}
