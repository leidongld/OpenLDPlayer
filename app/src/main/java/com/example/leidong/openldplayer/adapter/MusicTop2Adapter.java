package com.example.leidong.openldplayer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.bean.music.Top2Bean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2019/7/28.
 */
public class MusicTop2Adapter extends RecyclerView.Adapter<MusicTop2Adapter.ViewHolder> {
    private OnTop2ItemClickListener mListener;

    private Context mContext;

    private List<Top2Bean> mTop2BeanList;

    public MusicTop2Adapter(Context mContext, List<Top2Bean> mTop2BeanList) {
        this.mContext = mContext;
        this.mTop2BeanList = mTop2BeanList;
    }

    @NonNull
    @Override
    public MusicTop2Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_music_top2, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        if (!TextUtils.isEmpty(mTop2BeanList.get(i).getImageUrl())) {
            Glide.with(mContext).load(mTop2BeanList.get(i).getImageUrl()).into(viewHolder.imageTheme);
        }
        viewHolder.txtTheme.setText(mTop2BeanList.get(i).getTitle());
        viewHolder.txtDesc.setText(mTop2BeanList.get(i).getDescription());

        viewHolder.top2Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onTop2ItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTop2BeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.top2_item)
        FrameLayout top2Item;

        @BindView(R.id.image_theme)
        ImageView imageTheme;

        @BindView(R.id.txt_theme)
        TextView txtTheme;

        @BindView(R.id.txt_description)
        TextView txtDesc;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnTop2ItemClickListener(OnTop2ItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnTop2ItemClickListener {
        void onTop2ItemClick(int position);
    }
}
