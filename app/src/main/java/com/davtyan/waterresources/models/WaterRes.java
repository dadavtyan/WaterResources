package com.davtyan.waterresources.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WaterRes implements Serializable {
   private String nameRes;
   private List<WaterModel> waterArray = new ArrayList<>();


    public String getNameRes() {
        return nameRes;
    }

    public List<WaterModel> getWaterArray() {
        return waterArray;
    }

}
