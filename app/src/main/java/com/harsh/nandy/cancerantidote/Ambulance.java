package com.harsh.nandy.cancerantidote;

import java.io.Serializable;

/**
 * Created by popla on 26-03-2017.
 */

public class Ambulance implements Serializable {
    private int id;
    private String hospital;
    private String state;
    private int available;
    public int getId(){return this.id;}
        public void setHospital(String hospital)
    {
        this.hospital=hospital;
    }
    public void setState(String state)
    {
        this.state=state;
    }
    public void setAvailable(int available)
    {
        this.available=available;
    }
    public String getHospital()
    {
        return  this.hospital;
    }
    public String getState()
    {
        return  this.state;
    }
    public int getAvailable()
    {
        return this.available;
    }
}
