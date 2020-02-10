package com.example.video_cuoikhoa.Data;

import java.io.Serializable;

public class Video implements Serializable {
    public Video(String link) {
        Link = link;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    String Link;

}
