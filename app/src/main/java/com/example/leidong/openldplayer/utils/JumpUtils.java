package com.example.leidong.openldplayer.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Lei Dong on 2019/12/1.
 */
public class JumpUtils {
    /**
     * 实现简单的Activity跳转，可带参数
     *
     * @param context
     * @param toActivity
     * @param params
     */
    public static void jump2Activity(Context context, Class<Activity> toActivity, Map<String, String> params) {
        if (context != null) {
            Intent intent = new Intent(context, toActivity);
            if (params != null && !params.isEmpty()) {
                for (Iterator<String> iterator = params.keySet().iterator(); iterator.hasNext(); ) {
                    String key = iterator.next();
                    intent.putExtra(key, params.get(key));
                }
            }
            context.startActivity(intent);
        }
    }
}
