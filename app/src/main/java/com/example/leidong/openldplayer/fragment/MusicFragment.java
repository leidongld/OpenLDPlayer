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
import android.widget.Toast;

import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2019/6/20.
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MusicFragment extends Fragment implements OnBannerListener {
    private final String TAG = "MusicFragment";

    @BindView(R.id.toolbar_music)
    Toolbar mToolbar;

    @BindView(R.id.schv_music)
    SearchView mSearchView;

    @BindView(R.id.banner_music)
    Banner mBanner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBanner.startAutoPlay();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initWidgets();
    }

    /**
     * 初始化组件
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initWidgets() {
        initSearchView();
        initToolbar();
        initBanner();
    }

    /**
     * 初始Banner
     */
    private void initBanner() {
        // 设置填充再Banner中的图片
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.banner_pic1);
        imageList.add(R.drawable.banner_pic2);
        imageList.add(R.drawable.banner_pic3);
        imageList.add(R.drawable.banner_pic4);

        // 设置图片的标题
        List<String> titleList = new ArrayList<>();
        titleList.add("标题一");
        titleList.add("标题二");
        titleList.add("标题三");
        titleList.add("标题四");

        mBanner.setImages(imageList)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .setBannerTitles(titleList)
                .start();
    }

    /**
     * 初始化查询组件
     */
    private void initSearchView() {
        mSearchView.setIconifiedByDefault(false);
    }

    /**
     * 初始化Toolbar
     */
    private void initToolbar() {
        mToolbar.inflateMenu(R.menu.menu_music);
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
        mBanner.stopAutoPlay();
    }

    @Override
    public void OnBannerClick(int position) {
        // TODO: 2019/6/23 点击了某个Banner
        Toast.makeText(getContext(), "hahaha" + position, Toast.LENGTH_SHORT).show();
    }
}

