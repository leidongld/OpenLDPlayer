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
import com.example.leidong.openldplayer.bean.music.MusicCollectionBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2019/7/28.
 */
public class MusicCollectionAdapter extends RecyclerView.Adapter<MusicCollectionAdapter.ViewHolder> {
    private Context mContext;

    private List<MusicCollectionBean> mMusicCollectionBeanList;

    private OnMusicCollectionItemClickListener mListener;

    public MusicCollectionAdapter(Context mContext, List<MusicCollectionBean> mMusicCollectionBeanList) {
        this.mContext = mContext;
        this.mMusicCollectionBeanList = mMusicCollectionBeanList;
    }

    @NonNull
    @Override
    public MusicCollectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MusicCollectionAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_music_collection, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MusicCollectionAdapter.ViewHolder viewHolder, final int i) {
        if (!TextUtils.isEmpty(mMusicCollectionBeanList.get(i).getImageUrl())) {
            Glide.with(mContext).load(mMusicCollectionBeanList.get(i).getImageUrl()).into(viewHolder.imageTheme);
        }
        viewHolder.txtTheme.setText(mMusicCollectionBeanList.get(i).getTheme());
        viewHolder.txtDescription.setText(mMusicCollectionBeanList.get(i).getDescription());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onMusicCollectionItemClick(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMusicCollectionBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_theme)
        ImageView imageTheme;

        @BindView(R.id.txt_theme)
        TextView txtTheme;

        @BindView(R.id.txt_description)
        TextView txtDescription;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnMusicCollectionItemClickListener(OnMusicCollectionItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnMusicCollectionItemClickListener {
        void onMusicCollectionItemClick(int position);
    }
}
