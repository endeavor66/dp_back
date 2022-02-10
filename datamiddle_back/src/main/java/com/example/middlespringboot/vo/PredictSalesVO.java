package com.example.middlespringboot.vo;

import lombok.Builder;

import java.util.List;

@Builder
public class PredictSalesVO {
    List<String> times;
    List<Integer> actual;
    List<Integer> predict;

    public PredictSalesVO() {
    }

    public PredictSalesVO(List<String> times, List<Integer> actual, List<Integer> predict) {
        this.times = times;
        this.actual = actual;
        this.predict = predict;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public List<Integer> getActual() {
        return actual;
    }

    public void setActual(List<Integer> actual) {
        this.actual = actual;
    }

    public List<Integer> getPredict() {
        return predict;
    }

    public void setPredict(List<Integer> predict) {
        this.predict = predict;
    }
}