package com.example.supplychain.controller;

import com.example.supplychain.service.ProductWareHouseService;
import com.example.supplychain.vo.ProductTypeVO;
import com.example.supplychain.vo.ProductWareHouseTypeVO;
import com.example.supplychain.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "库存模块测试", tags = "库存模块测试")
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class WareHouseController {
    @Autowired
    private ProductWareHouseService productWareHouseService;

    /**
     * 获取所有成品库存(get)//
     * @return
     */
    @ApiOperation(value = "获取所有成员库存", notes = "getWareHouse")
    @GetMapping("/productRepository/show")
    public ResponseVO getWareHouse(){
        return productWareHouseService.getProductWareHouse();
    }

    /**
     * 获取所有成品库存类别(get)
     * @return
     */
    @ApiOperation(value = "获取所有成员库存类别", notes = "getWareHouseType")
    @GetMapping("/productType/show")
    public ResponseVO getProductWareHouseType(){
        return productWareHouseService.getProductWareHouseType();
    }
    /**
     * 添加成品库存类别
     */
    @ApiOperation(value = "添加成员库存类别", notes = "addProductWareHouseType")
    @PostMapping("/productType/add")
    public ResponseVO addProductWareHouseType(@RequestBody ProductWareHouseTypeVO productWareHouseTypeVO){
        return productWareHouseService.addProductWareHouseType(productWareHouseTypeVO.getProductName(),productWareHouseTypeVO.getMaterials(),productWareHouseTypeVO.getPrice());
    }

    /**
     * 减少成品库存类别
     */
    @ApiOperation(value = "减少成员库存类别", notes = "deleteProductWareHouseType")
    @GetMapping("/productType/delete")
    public ResponseVO deleteProductWareHouseType(@RequestParam String productID){
        return productWareHouseService.deleteProductWareHouseType(productID);
    }

    /**
     * 更新成品库存类别
     */
    @ApiOperation(value = "更新成员库存类别", notes = "updateProductWareHouseType")
    @PostMapping("/productType/update")
    public ResponseVO updateProductWareHouseType(@RequestBody ProductWareHouseTypeVO productWareHouseTypeVO){
        return productWareHouseService.updateProductWareHouseType(productWareHouseTypeVO.getId(),productWareHouseTypeVO.getProductName(),productWareHouseTypeVO.getMaterials());
    }

    /**
     * 成品仓库添加
     */
    @ApiOperation(value = "成品仓库添加", notes = "addProductWareHouse")
    @GetMapping("/productRepository/add")
    public ResponseVO  addProductWareHouse(@RequestParam String productId,@RequestParam String name,@RequestParam String quantity){
        return productWareHouseService.addProductWareHouse(productId,name,quantity);
    }

    /**
     * 成品仓库删除
     */
    @ApiOperation(value = "成品仓库删除", notes = "deleteProductWareHouse")
    @GetMapping("/productRepository/delete")
    public ResponseVO  deleteProductWareHouse(@RequestParam String id){

        return productWareHouseService.deleteProductWareHouse(id);
    }

    /**
     * 成品仓库更新数量
     */
    @ApiOperation(value = "成品仓库更新数量", notes = "updateProductWareHouse")
    @GetMapping("/productRepository/update")
    public ResponseVO  updateProductWareHouse(@RequestParam String id,@RequestParam String quantity){
        return productWareHouseService.updateProductWareHouse(id, quantity);
    }
}
