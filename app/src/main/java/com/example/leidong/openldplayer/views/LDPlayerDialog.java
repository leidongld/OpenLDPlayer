package com.example.leidong.openldplayer.views;

import android.content.Context;
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

        View view = inflater.inflate(R.layout.common_dialog, container);
        mTxtLeftCancel = view.findViewById(R.id.txt_cancel);
        mTxtRightOk = view.findViewById(R.id.txt_ok);
        return view;
    }

    private OnSelectDialogClickListener selectDialogClickListener;

    public static LDPlayerDialog newInstance(String message, String leftBtnText, String
            rightBtnText, OnSelectDialogClickListener selectDialogClickListener) {
        LDPlayerDialog selectDialog = new LDPlayerDialog();
        Bundle bundle = new Bundle();
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
        public void OnLeftClicked(LDPlayerDialog dialog);
        /**
         * 右侧按钮点击事件
         */
        public void OnRightClicked(LDPlayerDialog dialog);
    }
}
