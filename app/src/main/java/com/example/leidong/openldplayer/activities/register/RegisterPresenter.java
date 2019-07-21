package com.example.leidong.openldplayer.activities.register;

/**
 * Created by Lei Dong on 2019/7/7.
 */
public class RegisterPresenter implements RegisterContract.IRegisterPresenter {
    private RegisterContract.IRegisterView mView;

    public RegisterPresenter(RegisterContract.IRegisterView mView) {
        this.mView = mView;
    }

    /**
     * 执行注册
     *
     * @param username
     * @param passwd
     */
    @Override
    public void executeRegister(String username, String passwd) {
        if (true) {
            mView.dealRegisterSuccess();
        } else {
            mView.dealRegisterFail();
        }
    }
}
