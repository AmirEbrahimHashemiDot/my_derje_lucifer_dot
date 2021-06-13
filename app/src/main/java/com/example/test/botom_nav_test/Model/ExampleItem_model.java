package com.example.test.botom_nav_test.Model;

public class ExampleItem_model {

    private int $id;
    private String Name;
    private int ID;
    //private String Image;

    public ExampleItem_model(int $id, String name, int ID) {
        this.$id = $id;
        this.Name = name;
        this.ID = ID;
        //this.Image = image;
    }

    public ExampleItem_model() {

    }

    public int get$id() {
        return $id;
    }

    public void set$id(int $id) {
        this.$id = $id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    /*public String getImage() {
        return Image;
    }*/

    /*public void setImage(String image) {
        Image = image;
    }*/

}
