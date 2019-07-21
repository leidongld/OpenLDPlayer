package com.example.leidong.openldplayer.activities.main;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.activities.BaseActivity;
import com.example.leidong.openldplayer.fragment.FindFragment;
import com.example.leidong.openldplayer.fragment.MainFragments;
import com.example.leidong.openldplayer.fragment.MusicFragment;
import com.example.leidong.openldplayer.fragment.MyFragment;

import butterknife.BindView;

/**
 * 主Activity
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.lly_fragment)
    LinearLayout mLlyFragment;

    @BindView(R.id.rdg_bars)
    RadioGroup mRdgBars;

    @BindView(R.id.rdbtn_music)
    RadioButton mRdbtnMusic;

    @BindView(R.id.rdbtn_find)
    RadioButton mRdbtnFind;

    @BindView(R.id.rdbtn_my)
    RadioButton mRdbtnMy;

    private MusicFragment mMusicFragment;
    private FindFragment mFindFragment;
    private MyFragment mMyFragment;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private MainFragments mCurrentMainFragment = MainFragments.MUSIC_FRAGMENT;

    @Override
    protected String setTag() {
        return "MainActivity";
    }

    @Override
    protected void initScreenParams() {
        hideTitleBar();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initWidgets() {
        mRdbtnMusic.setChecked(true);
        loadMusicFragment();
    }

    /**
     * 加载我的页面
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void loadMyFragment() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mMyFragment = new MyFragment();
        mFragmentTransaction.replace(R.id.lly_fragment, mMyFragment);
        mFragmentTransaction.commit();

        mCurrentMainFragment = MainFragments.MY_FRAGMENT;
    }

    /**
     * 加载发现页
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void loadFindFragment() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFindFragment = new FindFragment();
        mFragmentTransaction.replace(R.id.lly_fragment, mFindFragment);
        mFragmentTransaction.commit();

        mCurrentMainFragment = MainFragments.FIND_FRAGMENT;
    }

    /**
     * 加载音乐馆界面
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void loadMusicFragment() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mMusicFragment = new MusicFragment();
        mFragmentTransaction.replace(R.id.lly_fragment, mMusicFragment);
        mFragmentTransaction.commit();

        mCurrentMainFragment = MainFragments.MUSIC_FRAGMENT;
    }

    @Override
    protected void doBusiness() {

    }

    /**
     * 点击音乐馆
     *
     * @param view
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClickMusicBar(View view) {
        if (MainFragments.MUSIC_FRAGMENT != mCurrentMainFragment) {
            loadMusicFragment();
        }
    }

    /**
     * 点击发现
     *
     * @param view
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClickFindBar(View view) {
        if (MainFragments.FIND_FRAGMENT != mCurrentMainFragment) {
            loadFindFragment();
        }
    }

    /**
     * 点击我的
     *
     * @param view
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClickMyBar(View view) {
        if (MainFragments.MY_FRAGMENT != mCurrentMainFragment) {
            loadMyFragment();
        }
    }
}
