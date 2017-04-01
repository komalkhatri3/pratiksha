package com.harsh.nandy.cancerantidote;

import java.io.Serializable;

/**
 * Created by De on 4/1/2017.
 */

public class Hospital implements Serializable {
    private int id;
    private String name;
    private String address;
    private String ambulance_count;
    private String userRating;

    public void setId(String id){

        this.id=Integer.parseInt(id);
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setUserRating(String userRating){
        this.userRating=userRating;
    }
    public void setAmbulance_count(String ambulance_count){this.ambulance_count=ambulance_count;}
    public void setUserrating(String userRating){this.userRating=userRating;}

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getAmbulance_count(){return  this.ambulance_count;}
    public String getUserRating(){
        return this.userRating;
    }



}
