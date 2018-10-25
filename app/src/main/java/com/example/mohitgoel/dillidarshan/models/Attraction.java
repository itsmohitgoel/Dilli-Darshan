package com.example.mohitgoel.dillidarshan.models;

/**
 * Created by Mohit Goel on 14-Oct-18.
 */

public class Attraction {
    private String mTitle;
    private String mDescription;
    private int mImageResId;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getImageResId() {
        return mImageResId;
    }

    public void setImageResId(int imageResId) {
        mImageResId = imageResId;
    }
}
