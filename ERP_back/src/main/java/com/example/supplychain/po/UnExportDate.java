package com.example.supplychain.po;

import java.util.Date;
import java.util.List;

public class UnExportDate {
    List<String> salesDates;
    List<String> returnDates;

    public UnExportDate(List<String> salesDates, List<String> returnDates) {
        this.salesDates = salesDates;
        this.returnDates = returnDates;
    }

    public List<String> getSalesDates() {
        return salesDates;
    }

    public void setSalesDates(List<String> salesDates) {
        this.salesDates = salesDates;
    }

    public List<String> getReturnDates() {
        return returnDates;
    }

    public void setReturnDates(List<String> returnDates) {
        this.returnDates = returnDates;
    }
}
