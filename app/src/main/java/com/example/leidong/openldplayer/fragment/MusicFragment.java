package com.example.leidong.openldplayer.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.adapter.MusicMenuAdapter;
import com.example.leidong.openldplayer.adapter.MusicTop2Adapter;
import com.example.leidong.openldplayer.adapter.music.MusicCollectionAdapter;
import com.example.leidong.openldplayer.adapter.music.MusicSongListAdapter;
import com.example.leidong.openldplayer.bean.music.MusicCollectionBean;
import com.example.leidong.openldplayer.bean.music.MusicMenuBean;
import com.example.leidong.openldplayer.bean.music.MusicSongListBean;
import com.example.leidong.openldplayer.bean.music.Top2Bean;
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
public class MusicFragment extends Fragment implements OnBannerListener, MusicMenuAdapter.OnMusicMenuItemClickListener, MusicTop2Adapter.OnTop2ItemClickListener, MusicSongListAdapter.OnMusicSongListItemClickListener, MusicCollectionAdapter.OnMusicCollectionItemClickListener {
    private final String TAG = "MusicFragment";

    @BindView(R.id.toolbar_music)
    Toolbar mToolbar;

    @BindView(R.id.schv_music)
    SearchView mSearchView;

    @BindView(R.id.banner_music)
    Banner mBanner;

    @BindView(R.id.rcl_menu)
    RecyclerView mRclMenu;

    @BindView(R.id.rcl_top2)
    RecyclerView mRclTop2;

    @BindView(R.id.rcl_official_song_list)
    RecyclerView mRclOfficialSongList;

    @BindView(R.id.rcl_expert_song_list)
    RecyclerView mRclexpertSongList;

    @BindView(R.id.rcl_collection_area)
    RecyclerView mRclCollectionArea;

    /**
     * Banner下方的推荐列表适配器
     */
    private MusicMenuAdapter mMusicMenuAdapter;
    /**
     * Top2列表的适配器
     */
    private MusicTop2Adapter mMusicTop2Adapter;

    /**
     * 歌单适配器 官方
     *
     * @param savedInstanceState
     */
    private MusicSongListAdapter mMusicSongListAdapter1;
    /**
     * 歌单适配器 达人
     *
     * @param savedInstanceState
     */
    private MusicSongListAdapter mMusicSongListAdapter2;
    /**
     * 分类专区适配器
     */
    private MusicCollectionAdapter mMusicCollectionAdapter;

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
        initMenu();
        initTop2();
        initOfficialSongList();
        initExpertSongList();
        initMusicCollectionArea();
    }

    /**
     * 初始化分类专区
     */
    private void initMusicCollectionArea() {
        List<MusicCollectionBean> musicCollectionBeanList = new ArrayList<>();
        MusicCollectionBean bean1 = new MusicCollectionBean("https://images.pexels.com/photos/6320/smartphone-vintage-technology-music.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940", "综艺专区", "谁是你心目中的HOT5");
        MusicCollectionBean bean2 = new MusicCollectionBean("https://images.pexels.com/photos/160846/french-bulldog-summer-smile-joy-160846.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500", "亲子专区", "更快乐更专业的亲子陪伴");
        MusicCollectionBean bean3 = new MusicCollectionBean("http://img.ph.126.net/ZDQ6_7eu5IewG3ZaNFZ01g==/3714906742627324240.jpg", "ACG专区", "动漫游戏音乐随心听");
        MusicCollectionBean bean4 = new MusicCollectionBean("https://images.pexels.com/photos/373893/pexels-photo-373893.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500", "Urban专区", "用节奏定义城市");

        musicCollectionBeanList.add(bean1);
        musicCollectionBeanList.add(bean2);
        musicCollectionBeanList.add(bean3);
        musicCollectionBeanList.add(bean4);

        mMusicCollectionAdapter = new MusicCollectionAdapter(getContext(), musicCollectionBeanList);
        mMusicCollectionAdapter.setOnMusicCollectionItemClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRclCollectionArea.setLayoutManager(linearLayoutManager);
        mRclCollectionArea.setAdapter(mMusicCollectionAdapter);
    }

    /**
     * 初始达人方歌单
     */
    private void initExpertSongList() {
        List<MusicSongListBean> musicSongListBeanList = new ArrayList<>();
        MusicSongListBean bean1 = new MusicSongListBean("", "孤独患者：人还在心却走远了", 13000L);
        MusicSongListBean bean2 = new MusicSongListBean("", "文艺细胞大散发，小清新最爱", 3210000L);
        MusicSongListBean bean3 = new MusicSongListBean("", "重温昨夜：郑秀文2019香港演唱会", 387000L);
        MusicSongListBean bean4 = new MusicSongListBean("", "90后 承载着青春回忆的童谣", 1693000L);
        MusicSongListBean bean5 = new MusicSongListBean("", "评价999+的欧美歌曲", 238000L);

        musicSongListBeanList.add(bean1);
        musicSongListBeanList.add(bean2);
        musicSongListBeanList.add(bean3);
        musicSongListBeanList.add(bean4);
        musicSongListBeanList.add(bean5);


        mMusicSongListAdapter2 = new MusicSongListAdapter(getContext(), musicSongListBeanList, MusicSongListAdapter.MusicSongListType.EXPERT);
        mMusicSongListAdapter2.setOnMusicSongListItemClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRclexpertSongList.setAdapter(mMusicSongListAdapter2);
        mRclexpertSongList.setLayoutManager(linearLayoutManager);
    }

    /**
     * 初始化官方歌单
     */
    private void initOfficialSongList() {
        List<MusicSongListBean> musicSongListBeanList = new ArrayList<>();
        MusicSongListBean bean1 = new MusicSongListBean("", "孤独患者：人还在心却走远了", 13000L);
        MusicSongListBean bean2 = new MusicSongListBean("", "文艺细胞大散发，小清新最爱", 3210000L);
        MusicSongListBean bean3 = new MusicSongListBean("", "重温昨夜：郑秀文2019香港演唱会", 387000L);
        MusicSongListBean bean4 = new MusicSongListBean("", "90后 承载着青春回忆的童谣", 1693000L);
        MusicSongListBean bean5 = new MusicSongListBean("", "评价999+的欧美歌曲", 238000L);

        musicSongListBeanList.add(bean1);
        musicSongListBeanList.add(bean2);
        musicSongListBeanList.add(bean3);
        musicSongListBeanList.add(bean4);
        musicSongListBeanList.add(bean5);


        mMusicSongListAdapter1 = new MusicSongListAdapter(getContext(), musicSongListBeanList, MusicSongListAdapter.MusicSongListType.OFFICIAL);
        mMusicSongListAdapter1.setOnMusicSongListItemClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRclOfficialSongList.setAdapter(mMusicSongListAdapter1);
        mRclOfficialSongList.setLayoutManager(linearLayoutManager);
    }

    /**
     * 初始化Top2
     */
    private void initTop2() {
        List<Top2Bean> top2BeanList = new ArrayList<>();
        Top2Bean bean1 = new Top2Bean("", "新歌新碟", "punchine艺术家");
        Top2Bean bean2 = new Top2Bean("", "数字专辑", "王者小分队出道");
        top2BeanList.add(bean1);
        top2BeanList.add(bean2);

        mMusicTop2Adapter = new MusicTop2Adapter(getContext(), top2BeanList);
        mMusicTop2Adapter.setOnTop2ItemClickListener(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mRclTop2.setAdapter(mMusicTop2Adapter);
        mRclTop2.setLayoutManager(gridLayoutManager);
    }

    /**
     * 初始化中间菜单
     */
    private void initMenu() {
        List<MusicMenuBean> musicMenuBeanList = new ArrayList<>();
        MusicMenuBean bean1 = new MusicMenuBean(R.drawable.icon_singer, "歌手");
        MusicMenuBean bean2 = new MusicMenuBean(R.drawable.icon_rank, "排行");
        MusicMenuBean bean3 = new MusicMenuBean(R.drawable.icon_collection, "分类歌单");
        MusicMenuBean bean4 = new MusicMenuBean(R.drawable.icon_channel, "电台");
        MusicMenuBean bean5 = new MusicMenuBean(R.drawable.icon_together, "一起听");
        musicMenuBeanList.add(bean1);
        musicMenuBeanList.add(bean2);
        musicMenuBeanList.add(bean3);
        musicMenuBeanList.add(bean4);
        musicMenuBeanList.add(bean5);


        mMusicMenuAdapter = new MusicMenuAdapter(getContext(), musicMenuBeanList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5);
        mRclMenu.setLayoutManager(gridLayoutManager);
        mRclMenu.setAdapter(mMusicMenuAdapter);
        mMusicMenuAdapter.setMusicMenuItemClickListener(this);
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

    /**
     * 点击了某个Banner
     *
     * @param position
     */
    @Override
    public void OnBannerClick(int position) {
        // TODO: 2019/6/23 点击了某个Banner
        Toast.makeText(getContext(), "hahaha" + position, Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击了某个menu
     *
     * @param position
     */
    @Override
    public void onMusicMenuItemClickListener(int position) {
        Toast.makeText(getContext(), "hahaha" + position, Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击了某个Top2主题
     *
     * @param position
     */
    @Override
    public void onTop2ItemClick(int position) {
        Toast.makeText(getContext(), "点击了第" + position + "个Top2主题", Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击了某个歌单
     *
     * @param type
     * @param position
     */
    @Override
    public void onMusicSongListItemClick(MusicSongListAdapter.MusicSongListType type, int position) {
        Toast.makeText(getContext(), "点击了" + type.toString() + "的第" + position + "个条目", Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击了某个分类专区条目
     *
     * @param position
     */
    @Override
    public void onMusicCollectionItemClick(int position) {
        Toast.makeText(getContext(), "点击了第" + position + "个分类专区条目", Toast.LENGTH_SHORT).show();
    }
}

