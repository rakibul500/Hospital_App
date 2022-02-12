package com.example.hospital;

public class model3 {
    String h_name;
    int h_ambulance;

    model3(){

    }

    public model3(String h_name, int h_ambulance) {
        this.h_name = h_name;
        this.h_ambulance = h_ambulance;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public int getH_ambulance() {
        return h_ambulance;
    }

    public void setH_ambulance(int h_ambulance) {
        this.h_ambulance = h_ambulance;
    }
}
