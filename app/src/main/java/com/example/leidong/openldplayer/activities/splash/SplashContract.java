package com.example.leidong.openldplayer.activities.splash;

/**
 * Created by Lei Dong on 2019/7/7.
 */
public class SplashContract {
    public interface ISplashView {
        void onChangeFont();

        void onPlayAnim();
    }

    public interface ISplashPresenter {
        void changeFont();

        void playAnim();
    }
}
