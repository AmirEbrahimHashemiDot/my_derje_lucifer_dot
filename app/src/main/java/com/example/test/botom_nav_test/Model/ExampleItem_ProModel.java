package com.example.test.botom_nav_test.Model;

import android.provider.ContactsContract;

public class ExampleItem_ProModel {

    private int ProID;
    private int $Id;
    private String Supplier;
    private String ProductName;
    private  String ProDesc;
    private int Price;
    private String Image;

    public ExampleItem_ProModel(int $id, String supplier, String productName, String proDesc, int proid, int price, String image) {
        $Id = $id;
        Supplier = supplier;
        ProductName = productName;
        ProDesc = proDesc;
        ProID = proid;
        Price = price;
        Image = image;
    }

    public ExampleItem_ProModel() {

    }

    public String getProDesc() {
        return ProDesc;
    }

    public void setProDesc(String proDesc) {
        ProDesc = proDesc;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int get$id() {
        return $Id;
    }

    public void set$id(int $id) {
        $Id = $id;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getProID() {
        return ProID;
    }

    public void setProID(int proID) {
        ProID = proID;
    }

    /*public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }*/
}