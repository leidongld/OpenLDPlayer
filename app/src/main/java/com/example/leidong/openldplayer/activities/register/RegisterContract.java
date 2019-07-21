package com.example.leidong.openldplayer.activities.register;

/**
 * Created by Lei Dong on 2019/7/7.
 */
public class RegisterContract {

    public interface IRegisterView {
        /**
         * 清除用户名输入框
         */
        void clearUsername();

        /**
         * 清除密码输入框
         */
        void clearPasswd();

        /**
         * 注册成功
         */
        void dealRegisterSuccess();

        /**
         * 注册失败
         */
        void dealRegisterFail();
    }

    public interface IRegisterPresenter {
        /**
         * 执行注册
         *
         * @param username
         * @param passwd
         */
        void executeRegister(String username, String passwd);
    }
}
