package com.example.supplychain.serviceImpl;

import com.example.supplychain.mapper.ShopInfMapper;
import com.example.supplychain.po.Shop;
import com.example.supplychain.service.ShopInfService;
import com.example.supplychain.vo.ResponseVO;
import com.example.supplychain.vo.ShopVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopInfServiceImpl implements ShopInfService {
    @Autowired
    private ShopInfMapper shopInfMapper;

    @Override
    public ResponseVO getShop() {
        try {
            List<String> ShopIdList = shopInfMapper.selectAllShopId();
            List<ShopVo> result = new ArrayList<>();
            //获取门店对象数组
            List<Shop> shops = new ArrayList<>();
            for (String s : ShopIdList) {
                shops.add(shopInfMapper.selectShopByShopId(s));
            }
            //potovo
            for(Shop shop:shops){
                result.add(new ShopVo(shop));
            }
            return ResponseVO.buildSuccess(result);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }
}

