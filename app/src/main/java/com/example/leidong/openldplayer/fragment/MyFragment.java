package com.example.leidong.openldplayer.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leidong.openldplayer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2019/6/20.
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyFragment extends Fragment {
    private final String TAG = "MyFragment";

    @BindView(R.id.toolbar_my)
    Toolbar mToolbar;

    @BindView(R.id.schv_my)
    SearchView mSearchView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initWidgets();
    }

    /**
     * 初始化组件
     */
    private void initWidgets() {
        initSearchView();
        initToolbar();
    }

    /**
     * 初始化搜索组件
     */
    private void initSearchView() {
        mSearchView.setIconifiedByDefault(false);
    }

    /**
     * 初始化Toolbar
     */
    private void initToolbar() {
        mToolbar.inflateMenu(R.menu.menu_my);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
