package com.example.supplychain.mapper;

import com.example.supplychain.po.RawMaterial;
import com.example.supplychain.service.ProductWareHouseService;
import com.example.supplychain.vo.ResponseVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMapper {
    @Autowired
    RawMaterialWareHouseMapper rawMaterialWareHouseMapper;

    @Autowired
    ProductWareHouseService productWareHouseService;

    @Test
    public void getProductWareHouseTypeTest(){
        ResponseVO responseVO=productWareHouseService.getProductWareHouseType();
        System.out.println(responseVO.getData());
    }

}
