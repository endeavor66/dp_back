package com.example.supplychain.vo;

public class MaterialForShowVO {
    /**
     * 原料id
     */
    String materialId;
    /**
     * 数量
     */
    int num;
    /**
     * 原料名称
     */
    String name;
    /**
     * 供应商对象
     */
    RawMaterialSupplierVO supplier;

    /**
     * 检验结果
     */
    Boolean checkedResult;

    public Boolean getCheckedResult() {
        return checkedResult;
    }

    public void setCheckedResult(Boolean checkedResult) {
        this.checkedResult = checkedResult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public RawMaterialSupplierVO getSupplier() {
        return supplier;
    }

    public void setSupplier(RawMaterialSupplierVO supplier) {
        this.supplier = supplier;
    }
}
