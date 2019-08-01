package com.example.leidong.openldplayer.bean.music;

/**
 * Created by Lei Dong on 2019/7/24.
 */
public class MusicMenuBean {
    private int icon;

    private String name;

    public MusicMenuBean(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
