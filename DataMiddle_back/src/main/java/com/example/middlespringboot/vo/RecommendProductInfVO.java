package com.example.middlespringboot.vo;

import com.example.middlespringboot.po.Material;
import lombok.Builder;

import java.util.List;

@Builder
public class RecommendProductInfVO {
    String id;
    String name;
    String reason;
    List<Material> materials;

    public RecommendProductInfVO() {
    }

    public RecommendProductInfVO(String id, String name, String reason, List<Material> materials) {
        this.id = id;
        this.name = name;
        this.reason = reason;
        this.materials = materials;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}
