package com.example.leidong.openldplayer.adapter.music;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.bean.NewAlbumBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2019/8/4.
 */
public class MusicNewAlbumAdapter extends RecyclerView.Adapter<MusicNewAlbumAdapter.ViewHolder> {
    private Context mContext;

    private List<NewAlbumBean> mNewAlbumBeanList;

    private OnMusicNewAlbumItemClickListener mListener;

    public MusicNewAlbumAdapter(Context mContext, List<NewAlbumBean> mNewAlbumBeanList) {
        this.mContext = mContext;
        this.mNewAlbumBeanList = mNewAlbumBeanList;
    }

    @NonNull
    @Override
    public MusicNewAlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MusicNewAlbumAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_new_album, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.mTxtTheme.setText(mNewAlbumBeanList.get(i).getTheme());
        Glide.with(mContext).load(mNewAlbumBeanList.get(i).getImageUrl()).into(viewHolder.mImageTheme);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onMusicNewAlbumItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewAlbumBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_theme)
        TextView mTxtTheme;

        @BindView(R.id.image_theme)
        ImageView mImageTheme;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnMusicNewAlbumItemClickListener(OnMusicNewAlbumItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnMusicNewAlbumItemClickListener {
        void onMusicNewAlbumItemClick(int position);
    }
}
