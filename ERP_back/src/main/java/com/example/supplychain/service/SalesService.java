package com.example.supplychain.service;

import com.example.supplychain.vo.ResponseVO;

public interface SalesService {
    // 获取所有销量信息
    ResponseVO getSalesInfo();

    //增加销量
    ResponseVO postSalesInfo(String productId, int num);
}
