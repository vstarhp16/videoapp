package com.example.video_cuoikhoa.Data;

public class ItemHotVideo {
    public String image;
    public String title;
    public String video;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public ItemHotVideo(String image, String title, String video) {
        this.image = image;
        this.title = title;
        this.video = video;
    }
}
