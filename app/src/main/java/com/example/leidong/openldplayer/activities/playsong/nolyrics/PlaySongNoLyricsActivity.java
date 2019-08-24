package com.example.leidong.openldplayer.activities.playsong.nolyrics;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.activities.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2019/8/10.
 */
public class PlaySongNoLyricsActivity extends BaseActivity {

    @BindView(R.id.icon_back)
    ImageView mIconBack;

    @BindView(R.id.image_song)
    ImageView mImageSong;

    @BindView(R.id.txt_title)
    TextView mTxtTitle;

    @BindView(R.id.txt_single_line)
    TextView mTxtSingleLine;

    @BindView(R.id.txt_current_time)
    TextView mTxtCurrentTime;

    @BindView(R.id.txt_total_time)
    TextView mTxtTotalTime;

    @BindView(R.id.pgb_song_progress)
    ProgressBar mPgbSongProgress;

    @BindView(R.id.img_loop_status)
    ImageView mImgLoopStatus;

    @BindView(R.id.img_previous)
    ImageView mImgPrevious;

    @BindView(R.id.img_play_or_stop)
    ImageView mImgPlayOrStop;

    @BindView(R.id.img_next)
    ImageView mImgNext;

    @BindView(R.id.img_list)
    ImageView mImgList;

    @BindView(R.id.linearLayout)
    LinearLayout mLinearLayout;

    @BindView(R.id.img_collection)
    ImageView mImgCollection;

    @BindView(R.id.img_download)
    ImageView mImgDownload;

    @BindView(R.id.img_share)
    ImageView mImgShare;

    @BindView(R.id.img_comment)
    ImageView mImgComment;

    private ObjectAnimator mSpinAnimater;


    @Override
    protected String setTag() {
        return "PlaySongNoLyricsActivity";
    }

    @Override
    protected void initScreenParams() {
        setFullScreen();
        hideTitleBar();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_play_song_no_lyrics;
    }

    @Override
    protected void initWidgets() {

    }

    @Override
    protected void doBusiness() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
