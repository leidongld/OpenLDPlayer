package com.example.leidong.openldplayer.bean;

/**
 * Created by Lei Dong on 2019/8/4.
 */
public class NewAlbumBean {
    private String theme;

    private String imageUrl;

    public NewAlbumBean(String theme, String imageUrl) {
        this.theme = theme;
        this.imageUrl = imageUrl;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
