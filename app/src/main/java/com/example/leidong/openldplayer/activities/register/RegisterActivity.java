package com.example.leidong.openldplayer.activities.register;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.activities.BaseActivity;
import com.example.leidong.openldplayer.activities.main.MainActivity;
import com.example.leidong.openldplayer.utils.PasswdUtils;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity implements RegisterContract.IRegisterView {
    private RegisterContract.IRegisterPresenter mPresenter;

    @BindView(R.id.edt_username)
    EditText mEdtUsername;

    @BindView(R.id.edt_passwd)
    EditText mEdtPasswd;

    @BindView(R.id.edt_passwd_confirm)
    EditText mEdtPasswdConfirm;

    @Override
    protected String setTag() {
        return "RegisterActivity";
    }

    @Override
    protected void initScreenParams() {
        setFullScreen();
        hideTitleBar();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initWidgets() {
        mPresenter = new RegisterPresenter(this);
    }

    @Override
    protected void doBusiness() {

    }

    /**
     * 点击注册按钮
     *
     * @param view
     */
    public void onClickRegisterBtn(View view) {
        String username = mEdtUsername.getText().toString();
        String passwd = mEdtPasswd.getText().toString();
        String passwdConfirm = mEdtPasswdConfirm.getText().toString();
        if (!TextUtils.isEmpty(username.trim()) && PasswdUtils.checkPasswdFormat(passwd, passwdConfirm)) {
            mPresenter.executeRegister(username, passwd);
        } else {
            Toast.makeText(this, "请保证输入的合法性", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void clearUsername() {
        mEdtUsername.setText("");
    }

    @Override
    public void clearPasswd() {
        mEdtPasswd.setText("");
        mEdtPasswdConfirm.setText("");
    }

    @Override
    public void dealRegisterSuccess() {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void dealRegisterFail() {
        clearUsername();
        clearPasswd();
    }
}
