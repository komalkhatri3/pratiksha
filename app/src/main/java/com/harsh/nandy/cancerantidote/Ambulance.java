package com.harsh.nandy.cancerantidote;

import java.io.Serializable;

/*
 * Created by popla on 26-03-2017.
 */

public class Ambulance implements Serializable {
    private int id = 0;
    private String state;
    private String hospital;
    private boolean available;

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public void setState(String state){
        this.state=state;
    }

    public void setHospital(String hospital) {
        this.hospital=hospital;
    }

    public void setAvailability(String available) {
        switch (available){
            case "0":
                this.available = false;
                break;
            case "1":
                this.available = true;
                break;
            default:
                break;
        }
    }

    public int getId(){
        return this.id;
    }

    public String getState() {
        return  this.state;
    }

    public String getHospital() {
        return  this.hospital;
    }

    public boolean getAvailability() {
        return this.available;
    }
}
