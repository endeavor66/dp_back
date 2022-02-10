package com.example.supplychain.po;

public class PurchaseListUpdate {
    String pId;
    String mId;
    double num;
    double price;
    String sId;

    public PurchaseListUpdate(String pId, String mId, double num, double price, String sId) {
        this.pId = pId;
        this.mId = mId;
        this.num = num;
        this.price = price;
        this.sId = sId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
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

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }
}
