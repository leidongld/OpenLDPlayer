package com.example.leidong.openldplayer.activities.splash;

/**
 * Created by Lei Dong on 2019/7/7.
 */
public class SplashPresenter implements SplashContract.ISplashPresenter {
    private SplashContract.ISplashView view;

    SplashPresenter(SplashContract.ISplashView view) {
        this.view = view;
    }

    @Override
    public void changeFont() {
        view.onChangeFont();
    }

    @Override
    public void playAnim() {
        view.onPlayAnim();
    }
}
