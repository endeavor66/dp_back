package com.example.supplychain.service;

import com.example.supplychain.vo.ResponseVO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


public interface ReturnService {

    //获取所有退货信息
    ResponseVO getReturnInfo();

    //增加退货信息
    ResponseVO postReturnInfo(String salesId , String reason);

}
