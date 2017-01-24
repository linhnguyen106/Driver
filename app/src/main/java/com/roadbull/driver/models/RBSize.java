package com.roadbull.driver.models;

/**
 * Created by linhnguyenv1 on 1/24/2017.
 */

public class RBSize {
    private int Id;
    private String SizeName;
    private String Description;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSizeName() {
        return SizeName;
    }

    public void setSizeName(String sizeName) {
        SizeName = sizeName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
