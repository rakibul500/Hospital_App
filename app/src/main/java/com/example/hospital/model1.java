package com.example.hospital;

public class model1 {
    String h_name,h_location,pic_url;
    int h_phone,h_ambulance;
    double longi,lati;

    public model1(double longi, double lati) {
        this.longi = longi;
        this.lati = lati;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    public double getLati() {
        return lati;
    }

    public void setLati(double lati) {
        this.lati = lati;
    }

    model1(){

    }

    public model1(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public model1(String h_name, String h_location, int h_phone, int h_ambulance) {
        this.h_name = h_name;
        this.h_location = h_location;
        this.h_phone = h_phone;
        this.h_ambulance = h_ambulance;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getH_location() {
        return h_location;
    }

    public void setH_location(String h_location) {
        this.h_location = h_location;
    }

    public int getH_phone() {
        return h_phone;
    }

    public void setH_phone(int h_phone) {
        this.h_phone = h_phone;
    }

    public int getH_ambulance() {
        return h_ambulance;
    }

    public void setH_ambulance(int h_ambulance) {
        this.h_ambulance = h_ambulance;
    }
}
