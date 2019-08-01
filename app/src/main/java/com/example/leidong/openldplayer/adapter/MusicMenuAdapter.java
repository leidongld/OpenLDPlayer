package com.example.leidong.openldplayer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.bean.music.MusicMenuBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2019/7/24.
 */
public class MusicMenuAdapter extends RecyclerView.Adapter<MusicMenuAdapter.ViewHolder> {
    private OnMusicMenuItemClickListener listener;

    private Context mContext;

    private List<MusicMenuBean> mMusicMenuBeanList;

    public MusicMenuAdapter(Context mContext, List<MusicMenuBean> mMusicMenuBeanList) {
        this.mContext = mContext;
        this.mMusicMenuBeanList = mMusicMenuBeanList;
    }

    @NonNull
    @Override
    public MusicMenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_music_menu, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.imgIcon.setImageResource(mMusicMenuBeanList.get(i).getIcon());
        viewHolder.txtName.setText(mMusicMenuBeanList.get(i).getName());
        viewHolder.llyItemMusicMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMusicMenuItemClickListener(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMusicMenuBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_music_menu)
        LinearLayout llyItemMusicMenu;

        @BindView(R.id.img_icon)
        ImageView imgIcon;

        @BindView(R.id.txt_name)
        TextView txtName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setMusicMenuItemClickListener(OnMusicMenuItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnMusicMenuItemClickListener {
        void onMusicMenuItemClickListener(int position);
    }
}
