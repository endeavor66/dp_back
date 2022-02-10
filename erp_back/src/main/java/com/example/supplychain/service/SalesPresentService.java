package com.example.supplychain.service;

import com.example.supplychain.vo.ResponseVO;
import com.example.supplychain.vo.form.MaterialCheckResultForm;
import com.example.supplychain.vo.form.MaterialOrderForm;

import java.util.List;

public interface SalesPresentService {

    //获取门店总销量基本信息
    ResponseVO getBasicSalesInfo();

    //获取销售金额走势
    ResponseVO getSalesTrend(String type);

    // 根据指定年份获取Top10商品的销售金额占比
    ResponseVO getYearSalesRate(String year);

    //根据指定月份获取Top5商品的销售占比
    ResponseVO getMonthSalesRate(String year , String mouth);

    //获取指定商品近年的销售额走势
    ResponseVO getCommoditySalesTrend(String product_id);

    //获取销售订单
    ResponseVO getOrderList(String year , String mouth);

    //获取近日销量基本信息
    ResponseVO getRecentSalesInfo(String type);

}
