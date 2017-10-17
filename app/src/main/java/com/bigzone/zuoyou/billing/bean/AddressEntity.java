package com.bigzone.zuoyou.billing.bean;

/**
 * Created by haohongwei on 2017/7/19.
 */

public class AddressEntity {
    private String name;
    private String phone;
    private String area;
    private String address;


    public AddressEntity(String name, String phone, String area, String address) {
        this.name = name;
        this.phone = phone;
        this.area = area;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
