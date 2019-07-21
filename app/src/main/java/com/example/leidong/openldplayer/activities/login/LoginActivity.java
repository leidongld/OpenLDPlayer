package com.example.leidong.openldplayer.activities.login;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.activities.main.MainActivity;
import com.example.leidong.openldplayer.activities.register.RegisterActivity;
import com.example.leidong.openldplayer.activities.BaseActivity;
import com.example.leidong.openldplayer.utils.FontUtils;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements LoginContract.ILoginView {
    private LoginContract.ILoginPresenter mPresenter;

    @BindView(R.id.btn_login)
    Button mBtnLogin;

    @BindView(R.id.btn_forget_passwd)
    Button mBtnForgetPasswd;

    @BindView(R.id.txt_appname)
    TextView mTxtAppName;

    @BindView(R.id.txt_register)
    TextView mTxtRegister;

    @BindView(R.id.edt_username)
    EditText mEdtUsername;

    @BindView(R.id.edt_passwd)
    EditText mEdtPasswd;

    private boolean mUsernameEdited = false;

    private boolean mPasswdEdited = false;

    @Override
    protected String setTag() {
        return null;
    }

    @Override
    protected void initScreenParams() {
        setFullScreen();
        hideTitleBar();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initWidgets() {
        mPresenter = new LoginPresenter(this);

        mBtnLogin.setEnabled(false);

        FontUtils.setTypeface(this, mTxtAppName, "fonts/Smoothie_Shoppe.ttf");

        mEdtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mUsernameEdited = s.length() > 0;
                if (mUsernameEdited && mPasswdEdited) {
                    changeBtnEnabledState(true);
                } else {
                    changeBtnEnabledState(false);
                }
            }
        });

        mEdtPasswd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPasswdEdited = s.length() > 0;
                if (mUsernameEdited && mPasswdEdited) {
                    changeBtnEnabledState(true);
                } else {
                    changeBtnEnabledState(false);
                }
            }
        });
    }

    /**
     * 改变按钮的状态
     *
     * @param b
     */
    private void changeBtnEnabledState(boolean b) {
        mBtnLogin.setEnabled(b);
    }

    @Override
    protected void doBusiness() {
    }

    /**
     * 清除用户名
     */
    @Override
    public void clearUsername() {
        mEdtUsername.setText("");
    }

    /**
     * 清除密码
     */
    @Override
    public void clearPassword() {
        mEdtPasswd.setText("");
    }

    /**
     * 处理登录成功
     */
    @Override
    public void dealLoginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    /**
     * 处理登录失败
     */
    @Override
    public void dealLoginFail() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击注册
     *
     * @param view
     */
    public void onClickRegisterTxt(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    /**
     * 点击登录按钮
     *
     * @param view
     */
    public void onClickLoginBtn(View view) {
        mPresenter.executeLogin(mEdtUsername.getText().toString(), mEdtPasswd.getText().toString());
    }

    /**
     * 点击忘记密码按钮
     *
     * @param view
     */
    public void onClickForgetBtn(View view) {

    }
}
