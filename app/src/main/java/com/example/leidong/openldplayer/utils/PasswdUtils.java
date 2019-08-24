package com.example.leidong.openldplayer.utils;

import android.text.TextUtils;

/**
 * Created by Lei Dong on 2019/7/21.
 */
public class PasswdUtils {
    /**
     * 检查两次输入的密码是否合法
     *
     * @param passwd1
     * @param passwd2
     * @return
     */
    public static boolean checkPasswdFormat(String passwd1, String passwd2) {
        if (TextUtils.isEmpty(passwd1.trim()) || TextUtils.isEmpty(passwd2.trim())) {
            return false;
        }
        if (!passwd1.equals(passwd2)) {
            return false;
        }
        if (passwd1.length() < 8) {
            return false;
        }
        return true;
    }
}
