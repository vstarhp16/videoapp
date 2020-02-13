package com.example.video_cuoikhoa.Data;

public class ItemCategory {
    public  String TitleCategory;
    public  String ImgCategory;

    public String getTitleCategory() {
        return TitleCategory;
    }

    public void setTitleCategory(String titleCategory) {
        TitleCategory = titleCategory;
    }

    public String getImgCategory() {
        return ImgCategory;
    }

    public void setImgCategory(String imgCategory) {
        ImgCategory = imgCategory;
    }

    public ItemCategory(String titleCategory, String imgCategory) {
        TitleCategory = titleCategory;
        ImgCategory = imgCategory;
    }
}
