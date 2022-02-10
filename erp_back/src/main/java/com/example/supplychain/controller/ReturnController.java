package com.example.supplychain.controller;

import com.example.supplychain.service.ReturnService;
import com.example.supplychain.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "退货管理模块测试", tags = "退货管理模块测试")
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ReturnController {
    @Autowired
    private ReturnService returnService;

    @ApiOperation(value = "获取门店退货信息", notes = "getReturnInfo")
    @GetMapping("/showReturnInfo")
    public ResponseVO getReturnInfo(){
        return returnService.getReturnInfo();
    }

    @ApiOperation(value = "提交退货基本信息", notes = "postReturnInfo")
    @GetMapping("/addReturn")
    public ResponseVO postReturnInfo(@RequestParam String salesId , @RequestParam String reason){
        return returnService.postReturnInfo(salesId,reason);
    }
}
