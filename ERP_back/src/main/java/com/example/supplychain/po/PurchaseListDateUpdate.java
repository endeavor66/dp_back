package com.example.supplychain.po;

import java.util.Date;

public class PurchaseListDateUpdate {
    String purchaseApplicationId;
    String materialId;
    Date date;

    public PurchaseListDateUpdate(String purchaseApplicationId, String materialId, Date date) {
        this.purchaseApplicationId = purchaseApplicationId;
        this.materialId = materialId;
        this.date = date;
    }

    public String getPurchaseApplicationId() {
        return purchaseApplicationId;
    }

    public void setPurchaseApplicationId(String purchaseApplicationId) {
        this.purchaseApplicationId = purchaseApplicationId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
