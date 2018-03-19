package com.davtyan.waterresources.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class WaterModel implements Serializable {
    private String name;
    private List<String> images = new ArrayList<>();
    private String description;

    public String getName() {
        return name;
    }

    public List<String> getImageList() {
        return images;
    }

    public String getDescription() {
        return description;
    }
}
