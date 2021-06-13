package com.example.test.botom_nav_test.Model.TanorestanBasketModel;

public class TanorestanBasketModel {

    public String name;
    public String supplier;
    public String price;
    public String count;
    public String image;

    public TanorestanBasketModel(String name, String supplier, String price, String count, String image) {
        this.name = name;
        this.supplier = supplier;
        this.price = price;
        this.count = count;
        this.image = image;
    }

    public TanorestanBasketModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
