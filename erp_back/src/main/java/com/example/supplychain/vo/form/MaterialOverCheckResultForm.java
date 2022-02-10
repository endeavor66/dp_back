package com.example.supplychain.vo.form;

import java.util.List;

public class MaterialOverCheckResultForm {
    /**
     * 采购清单id
     */
    String purchaseId;
    /**
     * MaterialCheckResultForm对象列表
     */
    List<MaterialCheckResultForm> materialCheckResultForms;

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public List<MaterialCheckResultForm> getMaterialCheckResultForms() {
        return materialCheckResultForms;
    }

    public void setMaterialCheckResultForms(List<MaterialCheckResultForm> materialCheckResultForms) {
        this.materialCheckResultForms = materialCheckResultForms;
    }
}
