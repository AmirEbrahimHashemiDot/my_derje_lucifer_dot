package com.example.test.botom_nav_test.Model.MainHomeModel;

public class MainHomeModel {

    private int item_image;
    private String item_title;

    public MainHomeModel () {

    }

    public MainHomeModel(String item_title, int item_image) {
        this.item_image = item_image;
        this.item_title = item_title;
    }

    public int getItem_image() {
        return item_image;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }

    public String getItem_title() {
        return item_title;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }
}
