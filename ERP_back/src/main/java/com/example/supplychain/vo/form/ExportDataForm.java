package com.example.supplychain.vo.form;

import java.util.List;

public class ExportDataForm {
    List<String> dates;
    String type;

    public ExportDataForm() {
    }

    public ExportDataForm(List<String> dates, String type) {
        this.type = type;
        this.dates = dates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }
}
