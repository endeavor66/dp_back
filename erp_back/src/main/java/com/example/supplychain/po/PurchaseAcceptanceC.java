package com.example.supplychain.po;

import java.util.Date;

/**
 * 对应数据库中purchase_acceptance_c表
 */
public class PurchaseAcceptanceC {
    String id;
    String pId;
    String auditClass;
    String result;
    String managerName;
    Date date;
    String note;

    public PurchaseAcceptanceC(String id, String pId, String auditClass, String result, String managerName, Date date, String note) {
        this.id = id;
        this.pId = pId;
        this.auditClass = auditClass;
        this.result = result;
        this.managerName = managerName;
        this.date = date;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getAuditClass() {
        return auditClass;
    }

    public void setAuditClass(String auditClass) {
        this.auditClass = auditClass;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
