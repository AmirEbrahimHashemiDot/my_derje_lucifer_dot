package com.example.test.botom_nav_test.Model;

public class BasketProModel {
    public int id;
    public Integer proID;
    public String proName;
    public String supplier;
    public String proImage;
    public int proPrice;

    public BasketProModel(int id, Integer proID, String proName, String supplier, String proImage, int proPrice) {
        this.id = id;
        this.proID = proID;
        this.proName = proName;
        this.supplier = supplier;
        this.proImage = proImage;
        this.proPrice = proPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getProID() {
        return proID;
    }

    public void setProID(Integer proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public int getProPrice() {
        return proPrice;
    }

    public void setProPrice(int proPrice) {
        this.proPrice = proPrice;
    }
}
