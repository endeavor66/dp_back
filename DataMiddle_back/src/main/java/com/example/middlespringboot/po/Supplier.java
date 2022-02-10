package com.example.middlespringboot.po;

import lombok.Builder;

@Builder
public class Supplier {
    String id;
    String name;
    String location;
    String price;
    String star;
    String time_parameter;
    String fare_parameter;

    public Supplier() {
    }

    public Supplier(String id, String name, String location, String price, String star, String time_parameter, String fare_parameter) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.star = star;
        this.time_parameter = time_parameter;
        this.fare_parameter = fare_parameter;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getTime_parameter() {
        return time_parameter;
    }

    public void setTime_parameter(String time_parameter) {
        this.time_parameter = time_parameter;
    }

    public String getFare_parameter() {
        return fare_parameter;
    }

    public void setFare_parameter(String fare_parameter) {
        this.fare_parameter = fare_parameter;
    }
}
