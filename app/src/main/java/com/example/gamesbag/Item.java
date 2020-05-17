package com.example.gamesbag;

import android.graphics.drawable.Drawable;

public class Item {
    private String name;
    private Drawable imgid;

    public Item(){

    }
    public Item(String n, Drawable img) {
        name = n;
        imgid = img;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Drawable getImg() {
        return imgid;
    }

    public void setImg(Drawable img) {
        this.imgid = img;
    }

}
