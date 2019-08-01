package com.example.leidong.openldplayer.bean.music;

/**
 * Created by Lei Dong on 2019/7/28.
 */
public class MusicCollectionBean {
    private String imageUrl;

    private String theme;

    private String description;

    public MusicCollectionBean(String imageUrl, String theme, String description) {
        this.imageUrl = imageUrl;
        this.theme = theme;
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
