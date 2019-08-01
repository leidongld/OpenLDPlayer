package com.example.leidong.openldplayer.bean.music;

/**
 * Created by Lei Dong on 2019/7/28.
 */
public class Top2Bean {
    private String imageUrl;

    private String title;

    private String description;

    public Top2Bean(String imageUrl, String title, String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
