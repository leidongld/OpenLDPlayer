package com.example.leidong.openldplayer.activities.playsong.nolyrics;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.activities.BaseActivity;

import butterknife.BindView;

/**
 * Created by Lei Dong on 2019/8/10.
 */
public class PlaySongNoLyricsActivity extends BaseActivity {
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

    /**
     * 点击了收藏图标
     *
     * @param view
     */
    public void onClickCollection(View view) {
        // TODO: 2019/12/1 待开发  点击收藏
        if (view.getId() == R.id.img_collection) {
            Toast.makeText(this, "点击了收藏图标", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 点击了下载图标
     *
     * @param view
     */
    public void onClickDownload(View view) {
        // TODO: 2019/12/1  待开发
        if (view.getId() == R.id.img_download) {
            Toast.makeText(this, "点击了下载按钮", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 点击了分享按钮
     *
     * @param view
     */
    public void onCLickShare(View view) {
        // TODO: 2019/12/1 待开发
        if (view.getId() == R.id.img_share) {
            Toast.makeText(this, "点击了分享图标", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 点击了评论图标
     *
     * @param view
     */
    public void onClickComment(View view) {
        // TODO: 2019/12/1 待开发
        if (view.getId() == R.id.img_comment) {
            Toast.makeText(this, "点击了评论图标", Toast.LENGTH_SHORT).show();
        }
    }
}
