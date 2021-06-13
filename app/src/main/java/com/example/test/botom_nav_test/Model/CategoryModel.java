package com.example.test.botom_nav_test.Model;

import android.util.Log;

public class CategoryModel {

    private int $id;
    private String Name;
    private int ID;

    /*public CategoryModel(int $id, String name, int ID) {
        this.$id = $id;
        Name = name;
        this.ID = ID;
    }*/

    public int getId() {
        return $id;
    }

    public void setId(int $id) {
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
}
