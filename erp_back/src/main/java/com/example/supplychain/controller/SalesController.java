package com.example.supplychain.controller;


import com.example.supplychain.service.SalesService;
import com.example.supplychain.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "销售管理模块测试", tags = "销售管理模块测试")
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @ApiOperation(value = "获取门店总销量基本信息", notes = "getSalesInfo")
    @GetMapping("/showSalesInfo")
    public ResponseVO getSalesInfo(){
        return salesService.getSalesInfo();
    }

    @ApiOperation(value = "增加销量", notes = "postSalesInfo")
    @GetMapping("/addSales")
    public ResponseVO postSalesInfo(@RequestParam String productId , @RequestParam int num){
        return salesService.postSalesInfo(productId,num);
    }


}
