package com.example.hospital;

public class model2 {

    String address1,address2,degree,doctor_name,picture_url,specialist,visiting_time1,visiting_time2;
    int phone1,phone2;

    model2(){

    }

    public model2(String address1, String address2, String degree, String doctor_name, String picture_url, String specialist, String visiting_time1, String visiting_time2, int phone1, int phone2) {
        this.address1 = address1;
        this.address2 = address2;
        this.degree = degree;
        this.doctor_name = doctor_name;
        this.picture_url = picture_url;
        this.specialist = specialist;
        this.visiting_time1 = visiting_time1;
        this.visiting_time2 = visiting_time2;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getVisiting_time1() {
        return visiting_time1;
    }

    public void setVisiting_time1(String visiting_time1) {
        this.visiting_time1 = visiting_time1;
    }

    public String getVisiting_time2() {
        return visiting_time2;
    }

    public void setVisiting_time2(String visiting_time2) {
        this.visiting_time2 = visiting_time2;
    }

    public int getPhone1() {
        return phone1;
    }

    public void setPhone1(int phone1) {
        this.phone1 = phone1;
    }

    public int getPhone2() {
        return phone2;
    }

    public void setPhone2(int phone2) {
        this.phone2 = phone2;
    }
}
