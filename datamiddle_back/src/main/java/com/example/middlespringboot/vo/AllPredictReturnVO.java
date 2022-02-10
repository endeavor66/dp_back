package com.example.middlespringboot.vo;

import lombok.Builder;

import java.util.List;

@Builder
public class AllPredictReturnVO {
    List<String> times;
    List<Double> result;

    public AllPredictReturnVO() {
    }

    public AllPredictReturnVO(List<String> times, List<Double> result) {
        this.times = times;
        this.result = result;
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
