package com.example.supplychain.vo.form;

import java.util.List;

public class MaterialOverOrderForm {
    /**
     * 管理员名字
     */
    String managerName;

    /**
     * MaterialOrderForm对象列表
     */
    List<MaterialOrderForm> materialOrderForms;

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public List<MaterialOrderForm> getMaterialOrderForms() {
        return materialOrderForms;
    }

    public void setMaterialOrderForms(List<MaterialOrderForm> materialOrderForms) {
        this.materialOrderForms = materialOrderForms;
    }
}
