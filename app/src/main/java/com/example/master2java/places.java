package com.example.master2java;

public class places {

    int placeID ;
    String name ;

    public places (int id , String n ) {
        this.placeID = id ;
        this.name = n ;
    }

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
