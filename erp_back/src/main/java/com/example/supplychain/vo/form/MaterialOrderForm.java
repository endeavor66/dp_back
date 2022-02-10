package com.example.supplychain.vo.form;

public class MaterialOrderForm {

    /**
     * 原料id
     */
    String id;
    /**
     * 数量
     */
    int nums;
    /**
     * 供应商id
     */
    String supplierId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
}
