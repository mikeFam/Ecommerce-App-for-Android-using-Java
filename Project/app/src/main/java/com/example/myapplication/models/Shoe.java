package com.example.myapplication.models;

import java.io.Serializable;

public class Shoe implements Serializable {
    private int id;
    private String name;
    private String brand;
    private double price;
    private int image;
    private int[] photos;
    private  String description;

    public Shoe(int id, String name, String brand, double price, int image, int[] photos, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.image = image;
        this.photos = photos;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int[] getPhotos() {return  photos;}

    public double getPrice() {return price;}

    public int getImage() {return image;}

    public  String getDescription() {return description;}
}

