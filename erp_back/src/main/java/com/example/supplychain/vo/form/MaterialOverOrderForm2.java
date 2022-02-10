package com.example.supplychain.vo.form;

import java.util.List;

public class MaterialOverOrderForm2 {
    /**
     * 采购表id
     */
    String id;
    /**
     * 管理员名字
     */
    String managerName;

    /**
     * MaterialOrderForm对象列表
     */
    List<MaterialOrderForm> materialOrderForms;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
