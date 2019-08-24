package com.example.leidong.openldplayer.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.leidong.openldplayer.views.LDPlayerDialog;

import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2019/6/20.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public String TAG = setTag();

    protected abstract String setTag();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initScreenParams();

        setContentView(setLayout());
        ButterKnife.bind(this);

        initWidgets();

        doBusiness();
    }

    /**
     * 设置屏幕的基本参数
     */
    protected abstract void initScreenParams();

    /**
     * 设置全屏显示
     */
    public void setFullScreen() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void hideTitleBar() {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    /**
     * 设置View
     *
     * @return
     */
    protected abstract int setLayout();

    /**
     * 初始化组件
     */
    protected abstract void initWidgets();

    /**
     * 进行业务处理
     */
    protected abstract void doBusiness();

    /**
     * 展示自定义的弹框
     *
     * @param message
     * @param leftBtnText
     * @param rightBtnText
     * @param selectDialogClickListener
     */
    public void showLDPlayerDialog(String title, String message, String leftBtnText, String
            rightBtnText, LDPlayerDialog.OnSelectDialogClickListener selectDialogClickListener) {
        LDPlayerDialog dialog = LDPlayerDialog.newInstance(title, message, leftBtnText, rightBtnText, selectDialogClickListener);
        dialog.show(getSupportFragmentManager(), "lose");
    }
}