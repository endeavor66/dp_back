package com.example.middlespringboot.controller;


import com.example.middlespringboot.service.MiddleService;
import com.example.middlespringboot.vo.ResponseVO;
import com.example.middlespringboot.vo.form.LoginForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "数据中台测试", tags = "数据中台测试")
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class MiddleController {

    @Autowired
    private MiddleService middleService;

    /**
     * 登录
     * @param loginForm
     * @return
     */
    @ApiOperation(value = "登录", notes = "login")
    @PostMapping("/login")
    public ResponseVO login(@RequestBody LoginForm loginForm){
        return middleService.login(loginForm);
    }

    /**
     * 获取门店信息
     * @param id
     * @return
     */
    @ApiOperation(value = "获取门店信息", notes = "getShopInfo")
    @GetMapping("/getShopInfo")
    public ResponseVO getShopInfo(@RequestParam String id){
        return middleService.getShopInfo(id);
    }

    /**
     * 获取推荐的商品详情清单
     * @param storeId
     * @return
     */
    @ApiOperation(value = "获取推荐的商品详情清单", notes = "getRecommendProduct")
    @GetMapping("/getRecommendProduct")
    public ResponseVO getRecommendProduct(@RequestParam String storeId){
        return middleService.getRecommendProduct(storeId);
    }

    /**
     * 根据商品id获取实际和预测销量信息
     * @param storeId
     * @param commodityId
     * @param type
     * @return
     */
    @ApiOperation(value = "根据商品id获取实际和预测销量信息", notes = "getPredictSales")
    @GetMapping("/getPredictSales")
    public ResponseVO getPredictSales(@RequestParam String storeId,@RequestParam String commodityId,@RequestParam String type){
        return middleService.getPredictSales(storeId,commodityId,type);
    }

    @ApiOperation(value = "获取预测的商品退货率", notes = "getPredictReturn")
    @GetMapping("/getPredictReturn")
    public ResponseVO getPredictReturn(@RequestParam String storeId,@RequestParam String commodityId){
        return middleService.getPredictReturn(storeId,commodityId);
    }

    @ApiOperation(value = "获取门店的预测总销量与实际总销量", notes = "getAllPredictSales")
    @GetMapping("/getAllPredictSales")
    public ResponseVO getAllPredictSales(@RequestParam List<String> storeId,@RequestParam String type){
        return middleService.getAllPredictSales(storeId,type);
    }

    @ApiOperation(value = "获取未来7日总的预测退货率", notes = "getAllPredictReturn")
    @GetMapping("/getAllPredictReturn")
    public ResponseVO getAllPredictReturn(@RequestParam List<String> storeId){
        return middleService.getAllPredictReturn(storeId);
    }

    @ApiOperation(value = "获取所有门店的总览信息", notes = "getAllShopInfo")
    @GetMapping("/getAllShopInfo")
    public ResponseVO getAllShopInfo(@RequestParam List<String> storeId){
        return middleService.getAllShopInfo(storeId);
    }

    /**
     * 3.19新增：店铺id/shopId
     * @param fileContent
     * @param type
     * @return
     */
    @ApiOperation(value ="导入数据", notes = "importData")
    @PostMapping("/importData")
    public ResponseVO importData(@RequestParam String fileContent,@RequestParam String type,@RequestParam String shopId){
        return middleService.importData(fileContent,type,shopId);
    }


}
