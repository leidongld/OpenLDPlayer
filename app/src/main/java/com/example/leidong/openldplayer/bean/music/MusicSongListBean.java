package com.example.leidong.openldplayer.bean.music;

/**
 * Created by Lei Dong on 2019/7/28.
 */
public class MusicSongListBean {
    private String imageUrl;

    private String theme;

    private long fansNum;

    public MusicSongListBean(String imageUrl, String theme, long fansNum) {
        this.imageUrl = imageUrl;
        this.theme = theme;
        this.fansNum = fansNum;
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

    public long getFansNum() {
        return fansNum;
    }

    public void setFansNum(long fansNum) {
        this.fansNum = fansNum;
    }
}
