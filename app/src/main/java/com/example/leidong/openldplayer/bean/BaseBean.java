package com.example.leidong.openldplayer.bean;

import java.io.Serializable;

/**
 * Created by Lei Dong on 2019/7/13.
 */
public class BaseBean implements Serializable {
    private String respCode;

    private String respMsg;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
}
