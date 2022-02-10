package com.example.supplychain.controller;

import com.example.supplychain.service.ManagerLoginService;
import com.example.supplychain.service.SalesPresentService;
import com.example.supplychain.vo.ResponseVO;
import com.example.supplychain.vo.form.MaterialCheckResultForm;
import com.example.supplychain.vo.form.MaterialOrderForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "销售情况展示模块测试", tags = "销售情况展示模块测试")
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class SalesPresentController {

    @Autowired
    private SalesPresentService salesPresentService;


    @ApiOperation(value = "获取门店总销量基本信息", notes = "getBasicSalesInfo")
    @GetMapping("/sales/all")
    public ResponseVO getBasicSalesInfo(){
        return salesPresentService.getBasicSalesInfo();
    }

    @ApiOperation(value = "获取销售金额走势", notes = "getSalesTrend")
    @GetMapping("/sales/all/getSalesTrend")
    public ResponseVO getSalesTrend(@RequestParam String type){
        return salesPresentService.getSalesTrend(type);
    }

    @ApiOperation(value = "根据指定年份获取Top10商品的销售金额占比", notes = "getYearSalesRate")
    @GetMapping("sales/all/getYearSalesRate")
    public ResponseVO getYearSalesRate(@RequestParam String year){
        return salesPresentService.getYearSalesRate(year);
    }

    @ApiOperation(value = "根据指定月份获取Top5商品的销售占比", notes = "getMonthSalesRate")
    @GetMapping("/sales/all/getMonthSalesRate")
    public ResponseVO getMonthSalesRate(@RequestParam String year ,@RequestParam String month){
        return salesPresentService.getMonthSalesRate(year,month);
    }

    @ApiOperation(value = "获取指定商品近年的销售额走势", notes = "getCommoditySalesTrend")
    @GetMapping("/sales/all/getCommoditySalesTrend")
    public ResponseVO getCommoditySalesTrend(@RequestParam String product_id){
        return salesPresentService.getCommoditySalesTrend(product_id);
    }

    @ApiOperation(value = "获取销售订单", notes = "getOrderList")
    @GetMapping("/sales/all/getOrderList")
    public ResponseVO getOrderList(@RequestParam String year ,@RequestParam String month){
        return salesPresentService.getOrderList(year,month);
    }

    @ApiOperation(value = "获取近日销量基本信息", notes = "getRecentSalesInfo")
    @GetMapping("/sales/recent")
    public ResponseVO getRecentSalesInfo(@RequestParam String type){
        return salesPresentService.getRecentSalesInfo(type);
    }


}
