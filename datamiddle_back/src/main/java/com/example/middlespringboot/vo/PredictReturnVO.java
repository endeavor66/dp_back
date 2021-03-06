package com.example.middlespringboot.vo;

import lombok.Builder;

import java.util.List;

@Builder
public class PredictReturnVO {
    String id;
    String name;
    List<String> times;
    List<Double> result;

    public PredictReturnVO() {
    }

    public PredictReturnVO(String id, String name, List<String> times, List<Double> result) {
        this.id = id;
        this.name = name;
        this.times = times;
        this.result = result;
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

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public List<Double> getResult() {
        return result;
    }

    public void setResult(List<Double> result) {
        this.result = result;
    }
}
