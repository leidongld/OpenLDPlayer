package com.example.leidong.openldplayer.bean.login;

import com.example.leidong.openldplayer.bean.BaseBean;

/**
 * Created by Lei Dong on 2019/7/13.
 */
public class LoginBean extends BaseBean {
    private String uid;

    private String username;

    private String passwd;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
