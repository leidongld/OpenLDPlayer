package com.example.leidong.openldplayer.activities.login;

/**
 * Created by Lei Dong on 2019/7/7.
 */
public class LoginContract {
    // 界面逻辑卸载这里
    public interface ILoginView {
        /**
         * 清除用户名
         */
        void clearUsername();

        /**
         * 清除密码
         */
        void clearPassword();

        /**
         * 处理登录成功
         */
        void dealLoginSuccess();

        /**
         * 处理登录失败
         */
        void dealLoginFail();
    }

    // 业务逻辑写在这里
    public interface ILoginPresenter {
        /**
         * 登录
         *
         * @param username
         * @param password
         */
        void executeLogin(String username, String password);
    }
}
