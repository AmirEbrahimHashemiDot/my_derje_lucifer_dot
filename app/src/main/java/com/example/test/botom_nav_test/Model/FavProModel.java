package com.example.test.botom_nav_test.Model;

import androidx.annotation.Nullable;

public class FavProModel {

    //public int img_pro_fav;
    public String txt_pro_name_fav;
    public String txt_pro_id_fav;
    public int favproID;
    public String proImage;
    public int proPrice;

    public FavProModel(String txt_pro_name_fav_, String txt_pro_id_fav_, int fav_proID, String proimage, int proPrice) {
        this.txt_pro_name_fav = txt_pro_name_fav_;
        this.txt_pro_id_fav = txt_pro_id_fav_;
        this.favproID = fav_proID;
        this.proImage = proimage;
        this.proPrice = proPrice;
    }

    public int getProPrice() {
        return proPrice;
    }

    public void setProPrice(int proPrice) {
        this.proPrice = proPrice;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public int getFavproID() {
        return favproID;
    }

    public void setFavproID(int favproID) {
        this.favproID = favproID;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        obj = this.favproID;
        return super.equals(obj);
    }
}