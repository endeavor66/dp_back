package com.example.middlespringboot.vo;

import lombok.Builder;

import java.util.List;

@Builder
public class AllShopInfoListVO {
    List<AllShopInfoVO> allShopInfoVOS;

    public AllShopInfoListVO() {
    }

    public AllShopInfoListVO(List<AllShopInfoVO> allShopInfoVOS) {
        this.allShopInfoVOS = allShopInfoVOS;
    }

    public List<AllShopInfoVO> getAllShopInfoVOS() {
        return allShopInfoVOS;
    }

    public void setAllShopInfoVOS(List<AllShopInfoVO> allShopInfoVOS) {
        this.allShopInfoVOS = allShopInfoVOS;
    }
}
