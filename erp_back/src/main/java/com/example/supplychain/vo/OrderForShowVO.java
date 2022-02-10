package com.example.supplychain.vo;

import java.util.Date;
import java.util.List;

public class OrderForShowVO {
    /**
     * 采购的id
     */
    String id;
    /**
     * 日期
     */
    Date inDate;
    String operator;
    String status;
    /**
     * 审核状态
     */
    List<PurchaseCheckInfoVO> checkInfo;
    /**
     * 原料对象数组
     */
    List<MaterialForShowVO> materials;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public List<MaterialForShowVO> getMaterials() {
        return materials;
    }

    public void setMaterials(List<MaterialForShowVO> materials) {
        this.materials = materials;
    }

    public List<PurchaseCheckInfoVO> getCheckInfo() {
        return checkInfo;
    }

    public void setCheckInfo(List<PurchaseCheckInfoVO> checkInfo) {
        this.checkInfo = checkInfo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
