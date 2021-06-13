package com.example.test.botom_nav_test.Model.KaridMive.TabestaneModel;

public class TabestaneProItem_model {

    private int $id;
    private int ID;
    private String Supplier;
    private String Name;
    private String Description;
    private int Price;
    private String Image;

    public TabestaneProItem_model(int $id, int ID, String supplier, String name, String description, int price, String image) {
        this.$id = $id;
        this.ID = ID;
        Supplier = supplier;
        Name = name;
        Description = description;
        Price = price;
        Image = image;
    }

    public TabestaneProItem_model() {

    }

    public int get$id() {
        return $id;
    }

    public void set$id(int $id) {
        this.$id = $id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

}
