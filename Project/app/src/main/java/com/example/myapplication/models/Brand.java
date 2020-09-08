package com.example.myapplication.models;

import java.io.Serializable;

public class Brand implements Serializable {
    private int id;
    private String name;
    private int image;

    public Brand(int id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}

