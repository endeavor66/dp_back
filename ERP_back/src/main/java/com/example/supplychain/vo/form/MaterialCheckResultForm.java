package com.example.supplychain.vo.form;

public class MaterialCheckResultForm {

    /**
     * 原料id
     */
    String id;
    /**
     * 检验结果
     */
    Boolean result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
