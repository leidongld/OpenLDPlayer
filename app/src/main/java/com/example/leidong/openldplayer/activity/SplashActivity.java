package com.example.leidong.openldplayer.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.utils.FontUtils;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {
    @BindView(R.id.lly_splash_container)
    LinearLayout mLlySplashContainer;

    @BindView(R.id.lly_bg)
    LinearLayout mLlySplashBg;

    @BindView(R.id.txt_app_title)
    TextView mTxtAppTitle;

    @BindView(R.id.txt_app_author)
    TextView mTxtAppAuthor;

    private ObjectAnimator mAnimator;
    private Animation mAnimation;

    @Override
    protected String setTag() {
        return "SplashActivity";
    }

    @Override
    protected void initScreenParams() {
        setFullScreen();
        hideTitleBar();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initWidgets() {
        initTxt();

        initBgAnimation();
    }

    /**
     * 初始化文字
     */
    private void initTxt() {
        FontUtils.setTypeface(this, mTxtAppTitle, "fonts/Smoothie_Shoppe.ttf");
        FontUtils.setTypeface(this, mTxtAppAuthor, "fonts/Smoothie_Shoppe.ttf");
    }

    /**
     * 初始化背景动画
     */
    private void initBgAnimation() {
        mAnimator = ObjectAnimator.ofFloat(mLlySplashBg, "alpha", 0, 1);
        mAnimator.setDuration(3000);
        mAnimator.start();
    }

    @Override
    protected void doBusiness() {

    }

    /**
     * 点击Splash页面
     *
     * @param view
     */
    public void onClickSplash(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
