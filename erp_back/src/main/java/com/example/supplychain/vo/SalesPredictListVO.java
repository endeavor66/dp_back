package com.example.supplychain.vo;

import lombok.Builder;

import java.util.List;

@Builder
public class SalesPredictListVO {
    List<SalesPredictVO> salesPredictVOS;

    public SalesPredictListVO() {
    }

    public SalesPredictListVO(List<SalesPredictVO> salesPredictVOS) {
        this.salesPredictVOS = salesPredictVOS;
    }

    public List<SalesPredictVO> getSalesPredictVOS() {
        return salesPredictVOS;
    }

    public void setSalesPredictVOS(List<SalesPredictVO> salesPredictVOS) {
        this.salesPredictVOS = salesPredictVOS;
    }
}
