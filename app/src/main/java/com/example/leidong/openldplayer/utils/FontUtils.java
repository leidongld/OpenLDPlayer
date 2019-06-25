package com.example.leidong.openldplayer.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by Lei Dong on 2019/6/25.
 */
public class FontUtils {
    /**
     * 设置字体
     *
     * @param contxt
     * @param view
     * @param fontPath
     */
    public static void setTypeface(Context contxt, TextView view, String fontPath) {
        if (TextUtils.isEmpty(fontPath)) {
            return;
        }
        try {
            AssetManager assetManager = contxt.getAssets();
            Typeface typeface = Typeface.createFromAsset(assetManager, fontPath);
            view.setTypeface(typeface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
