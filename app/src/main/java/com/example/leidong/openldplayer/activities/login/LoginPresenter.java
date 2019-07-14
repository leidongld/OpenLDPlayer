package com.example.leidong.openldplayer.activities.login;

/**
 * Created by Lei Dong on 2019/7/7.
 */
public class LoginPresenter implements LoginContract.ILoginPresenter {
    private LoginContract.ILoginView mView;

    LoginPresenter(LoginContract.ILoginView view) {
        this.mView = view;
    }

    @Override
    public void executeLogin(String username, String password) {
        if ("leidong".equalsIgnoreCase(username)
                && "123456".equalsIgnoreCase(password)) {
            mView.dealLoginSuccess();
        } else {
            mView.dealLoginFail();
            mView.clearUsername();
            mView.clearPassword();
        }
    }
}
