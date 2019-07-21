package com.example.leidong.openldplayer.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.utils.FontUtils;

/**
 * Created by Lei Dong on 2019/6/22.
 */
public class LDPlayerDialog extends DialogFragment {
    private Context mContext;

    private ImageView mImageBg;

    private TextView mTxtTitle;

    private TextView mTxtMessage;

    private TextView mTxtRightOk;

    private TextView mTxtLeftCancel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.Theme_AppCompat_Dialog_MinWidth);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE); //无标题

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        View view = inflater.inflate(R.layout.common_dialog, container);

        mTxtTitle = view.findViewById(R.id.txt_title);
        mTxtMessage = view.findViewById(R.id.txt_message);
        mTxtLeftCancel = view.findViewById(R.id.txt_cancel);
        mTxtRightOk = view.findViewById(R.id.txt_ok);

        // 设置字体
        FontUtils.setTypeface(mContext, mTxtTitle, "fonts/kuaile.ttf");
        FontUtils.setTypeface(mContext, mTxtMessage, "fonts/kuaile.ttf");
        FontUtils.setTypeface(mContext, mTxtLeftCancel, "fonts/kuaile.ttf");
        FontUtils.setTypeface(mContext, mTxtRightOk, "fonts/kuaile.ttf");

        if (null != getArguments()) {
            mTxtTitle.setText(getArguments().getString("title"));
            mTxtMessage.setText(getArguments().getString("message"));
            mTxtLeftCancel.setText(getArguments().getString("leftBtnText"));
            mTxtRightOk.setText(getArguments().getString("rightBtnText"));
        }

        mTxtLeftCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                selectDialogClickListener.OnLeftClicked(LDPlayerDialog.this);
            }
        });

        mTxtRightOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                selectDialogClickListener.OnRightClicked(LDPlayerDialog.this);
            }
        });

        return view;
    }

    private OnSelectDialogClickListener selectDialogClickListener;

    public static LDPlayerDialog newInstance(String title, String message, String leftBtnText, String
            rightBtnText, OnSelectDialogClickListener selectDialogClickListener) {
        LDPlayerDialog selectDialog = new LDPlayerDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("message", message);
        bundle.putString("leftBtnText", leftBtnText);
        bundle.putString("rightBtnText", rightBtnText);
        //传入值，跟Fragment传值方法一样
        selectDialog.setArguments(bundle);
        selectDialog.selectDialogClickListener = selectDialogClickListener;
        return selectDialog;
    }


    public interface OnSelectDialogClickListener {
        /**
         * 左侧按钮点击事件
         */
        void OnLeftClicked(LDPlayerDialog dialog);

        /**
         * 右侧按钮点击事件
         */
        void OnRightClicked(LDPlayerDialog dialog);
    }
}
