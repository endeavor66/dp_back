package com.example.supplychain;

import com.example.supplychain.mapper.RawMaterialWareHouseMapper;
import com.example.supplychain.mapper.WareHouseMapper;
import com.example.supplychain.po.ProductRawMaterial;
import com.example.supplychain.service.ProductWareHouseService;
import com.example.supplychain.vo.ResponseVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SupplyChainApplicationTests {
    @Autowired
    RawMaterialWareHouseMapper rawMaterialWareHouseMapper;

}
