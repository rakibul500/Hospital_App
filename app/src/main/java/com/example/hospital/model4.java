package com.example.hospital;

public class model4 {

    String bloodGroup,district,name,upozila,phone;

    public model4(){

    }

    public model4(String bloodGroup, String district, String name, String upozila,String phone) {
        this.bloodGroup = bloodGroup;
        this.district = district;
        this.name = name;
        this.upozila = upozila;
        this.phone = phone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpozila() {
        return upozila;
    }

    public void setUpozila(String upozila) {
        this.upozila = upozila;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
