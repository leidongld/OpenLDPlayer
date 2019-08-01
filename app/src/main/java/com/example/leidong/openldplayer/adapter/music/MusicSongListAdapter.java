package com.example.leidong.openldplayer.adapter.music;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.bean.music.MusicSongListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2019/7/28.
 */
public class MusicSongListAdapter extends RecyclerView.Adapter<MusicSongListAdapter.ViewHolder> {
    public enum MusicSongListType {
        OFFICIAL,
        EXPERT
    }

    private Context mContext;

    private OnMusicSongListItemClickListener mListener;

    private List<MusicSongListBean> mMusicSongListBeanList;

    private MusicSongListType mType;

    public MusicSongListAdapter(Context context, List<MusicSongListBean> musicSongListBeanList, MusicSongListType type) {
        this.mContext = context;
        this.mMusicSongListBeanList = musicSongListBeanList;
        this.mType = type;
    }

    @NonNull
    @Override
    public MusicSongListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_song_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        if (!TextUtils.isEmpty(mMusicSongListBeanList.get(i).getImageUrl())) {
            Glide.with(mContext).load(mMusicSongListBeanList.get(i).getImageUrl()).into(viewHolder.imageTheme);
        }
        viewHolder.txtTheme.setText(mMusicSongListBeanList.get(i).getTheme());
        viewHolder.txtFansNum.setText("" + mMusicSongListBeanList.get(i).getFansNum());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onMusicSongListItemClick(mType, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMusicSongListBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_theme)
        ImageView imageTheme;

        @BindView(R.id.txt_theme)
        TextView txtTheme;

        @BindView(R.id.txt_fans_num)
        TextView txtFansNum;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnMusicSongListItemClickListener(OnMusicSongListItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnMusicSongListItemClickListener {
        void onMusicSongListItemClick(MusicSongListType type, int position);
    }
}
