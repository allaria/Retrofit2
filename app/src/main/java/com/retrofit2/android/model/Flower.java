package com.retrofit2.android.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by alaria on 20/04/2016.
 */
public class Flower implements Serializable {

    @Expose
    private String category;

    @Expose
    private double price;

    @Expose
    private String instructions;

    @Expose
    private String photo;

    @Expose
    private String name;

    @Expose
    private int productId;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public Flower() {
    }

    public Flower(String category, double price, String instructions, String photo, String name, int productId) {
        this.category = category;
        this.price = price;
        this.instructions = instructions;
        this.photo = photo;
        this.name = name;
        this.productId = productId;
    }
}
