package com.example.leidong.openldplayer.activities.playsong.nolyrics;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.activities.BaseActivity;
import com.example.leidong.openldplayer.multimedia.AudioPlayer;
import com.example.leidong.openldplayer.multimedia.PlayListener;
import com.example.leidong.openldplayer.multimedia.PlayStatus;

import java.io.IOException;

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

    @BindView(R.id.img_play_or_pause)
    ImageView mImgPlayOrPause;

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

    private AudioPlayer mAudioPlayer;

    private PlayStatus mPlayStatus = PlayStatus.STOP;

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

    /**
     * 点击播放或者暂停按钮
     *
     * @param view
     */
    public void onClickPlayOrPause(View view) throws IOException {
        mAudioPlayer = AudioPlayer.getInstance();
        mAudioPlayer.setSongUrl("https://sharefs.yun.kugou.com/201912222122/89007500b2443b370744f95fe01c9dce/G137/M03/17/1D/aZQEAFt-jsuAFmXqAD2w54GV4Z0351.mp3");
        mAudioPlayer.setPlayListener(new PlayListener() {
            @Override
            public void onStartSong() {
                Toast.makeText(PlaySongNoLyricsActivity.this, "onStartSong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCompleteSong() {
                Toast.makeText(PlaySongNoLyricsActivity.this, "onCompleteSong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPauseSong() {
                Toast.makeText(PlaySongNoLyricsActivity.this, "onPauseSong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResumeSong() {
                Toast.makeText(PlaySongNoLyricsActivity.this, "onResumeSong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopSong() {
                Toast.makeText(PlaySongNoLyricsActivity.this, "onStopSong", Toast.LENGTH_SHORT).show();
            }
        });
        if(mPlayStatus == PlayStatus.STOP) {
            mImgPlayOrPause.setImageDrawable(getResources().getDrawable(R.drawable.icon_pause));
            mAudioPlayer.start();
            mPlayStatus = PlayStatus.PLAYING;
        } else if (mPlayStatus == PlayStatus.PLAYING) {
            mAudioPlayer.pause();
            mImgPlayOrPause.setImageDrawable(getResources().getDrawable(R.drawable.icon_play));
            mPlayStatus = PlayStatus.PAUSED;
        } else if (mPlayStatus == PlayStatus.PAUSED) {
            mAudioPlayer.resume();
            mImgPlayOrPause.setImageDrawable(getResources().getDrawable(R.drawable.icon_pause));
            mPlayStatus = PlayStatus.PLAYING;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAudioPlayer != null) {
            mAudioPlayer.stop();
            mAudioPlayer = null;
        }
    }
}
