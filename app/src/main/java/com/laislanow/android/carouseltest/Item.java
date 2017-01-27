package com.laislanow.android.carouseltest;

/**
 * Created by dmorales on 1/23/2017.
 */

public class Item {

    int resId;

    String imageUri;

    String title;

    String description;

    public Item(String imageUri, String title, int res, String description){

        setImageUri(imageUri);

        setTitle(title);

        setResId(res);

        setDescription(description);
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription(){
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }
}