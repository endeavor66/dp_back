package com.example.supplychain.controller;

import com.example.supplychain.service.ShopInfService;
import com.example.supplychain.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "店铺信息模块测试", tags = "店铺信息模块测试")
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ShopInfController {
    @Autowired
    private ShopInfService shopInfService;

    /**
     * 获取所有对应的门店(get)
     * @return
     */

    @ApiOperation(value = "获取所有对应的门店信息", notes = "getShop")
    @GetMapping("/homepage/Info")
    public ResponseVO getShop(){
        System.out.println("获取门店基本信息");
        return shopInfService.getShop();}
}
