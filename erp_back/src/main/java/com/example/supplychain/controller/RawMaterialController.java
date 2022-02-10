package com.example.supplychain.controller;


import com.example.supplychain.service.rawMaterialWareHouseService;
import com.example.supplychain.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "库存模块测试", tags = "库存模块测试")
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    public class RawMaterialController {
    @Autowired
    private rawMaterialWareHouseService rawMaterialWareHouseService;

    /**
     * 获取所有原料库存类别(get)
     * @return
     */
    @ApiOperation(value = "获取所有原料库存类别", notes = "getRawMaterialWareHouseType")
    @GetMapping("/materialType/show")
    public ResponseVO getRawMaterialWareHouseType(){
        return rawMaterialWareHouseService.getRawMaterialWareHouseType();
    }

    /**
     * 添加原料库存类别
     */
    @ApiOperation(value = "添加原料库存类别", notes = "addRawMaterialWareHouseType")
    @GetMapping("/materialType/add")
    public ResponseVO addRawMaterialWareHouseType(@RequestParam String name){
        return rawMaterialWareHouseService.addRawMaterialWareHouseType(name);
    }

    /**
     * 减少原料库存类别
     */
    @ApiOperation(value = "减少原料库存类别", notes = "deleteRawMaterialWareHouseType")
    @GetMapping("/materialType/delete")
    public ResponseVO deleteRawMaterialWareHouseType(@RequestParam String productId){
        return rawMaterialWareHouseService.deleteRawMaterialWareHouseType(productId);
    }

    /**
     * 更新原料库存类别
     */
    @ApiOperation(value = "更新原料库存类别", notes = "updateProductWareHouseType")
    @GetMapping("/materialType/update")
    public ResponseVO updateRawMaterialWareHouseType(@RequestParam String id,@RequestParam String name){
        return rawMaterialWareHouseService.updateRawMaterialWareHouseType(id,name);
    }

    /**
     * 原料仓库查看(get)
     * @return
     */
    @ApiOperation(value = "查看所有原料仓库", notes = "getRawMaterialWareHouse")
    @GetMapping("/materialRepository/show")
    public ResponseVO getRawMaterialWareHouse(){
        return rawMaterialWareHouseService.getRawMaterialWareHouse();
    }

    /**
     * 添加原料库存
     */
    @ApiOperation(value = "添加原料库存", notes = "addRawMaterialWareHouse")
    @GetMapping("/materialRepository/add")
    public ResponseVO addRawMaterialWareHouse(@RequestParam String rawMaterialId,@RequestParam String rawMaterialName,@RequestParam String quantity){
        return rawMaterialWareHouseService.addRawMaterialWareHouse(rawMaterialId,rawMaterialName,quantity);
    }

    /**
     * 减少原料库存
     */
    @ApiOperation(value = "减少原料库存", notes = "deleteRawMaterialWareHouse")
    @GetMapping("/materialRepository/delete")
    public ResponseVO deleteRawMaterialWareHouse(@RequestParam String rawMaterialId){
        return rawMaterialWareHouseService.deleteRawMaterialWareHouse(rawMaterialId);
    }

    /**
     * 更新原料库存
     */
    @ApiOperation(value = "更新原料库存", notes = "updateProductWareHouse")
    @GetMapping("/materialRepository/update")
    public ResponseVO updateRawMaterialWareHouse(@RequestParam String id,@RequestParam String quantity){
        return rawMaterialWareHouseService.updateRawMaterialWareHouse(id,quantity);
    }
}
