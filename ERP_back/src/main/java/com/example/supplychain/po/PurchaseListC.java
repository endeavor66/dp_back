package com.example.supplychain.po;

import java.util.Date;

/**
 * 对应数据库中purchase_list_c表
 */
public class PurchaseListC {
    String id;
    String materialId;
    double num;
    double price;
    String supplierId;
    String purchaseListState;//货物检验结果：0未检验，1通过，-1不通过
    Date inDate;//到货日期

    /**
     * 到货日期在purchaseListState变为1时写入当时的时间，Constructor创建类时purchaseListState=0
     * 故Constructor初始化时写入的inDate到货日期为无效数据，只是为了能成功写入数据库
     */

    public PurchaseListC(String id, String materialId, double num, double price, String supplierId, String purchaseListState,Date inDate) {
        this.id = id;
        this.materialId = materialId;
        this.num = num;
        this.price = price;
        this.supplierId = supplierId;
        this.purchaseListState = purchaseListState;
        this.inDate = inDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getPurchaseListState() {
        return purchaseListState;
    }

    public void setPurchaseListState(String purchaseListState) {
        this.purchaseListState = purchaseListState;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }
}
