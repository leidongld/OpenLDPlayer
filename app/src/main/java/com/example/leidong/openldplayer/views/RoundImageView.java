package com.example.leidong.openldplayer.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.example.leidong.openldplayer.R;
import com.example.leidong.openldplayer.utils.SizeUtils;

/**
 * Created by Lei Dong on 2019/6/23.
 */
public class RoundImageView extends AppCompatImageView {
    private Paint paint;

    private int cx;
    private int cy;
    private int radius;
    private int strokeColor;
    private int strokeWidth;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint = new Paint();

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RoundImageView);
        initParams(context, ta);
        ta.recycle();
    }

    /**
     * 获取参数
     *
     * @param context
     * @param ta
     */
    private void initParams(Context context, TypedArray ta) {
        strokeColor = ta.getColor(R.styleable.RoundImageView_strokeColor, getContext().getResources().getColor(R.color.white));
        strokeWidth = (int) ta.getDimension(R.styleable.RoundImageView_strokeWidth, SizeUtils.dp2px(context, 2));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();

        if (measuredWidth > measuredHeight) {
            measuredWidth = measuredHeight;
        } else {
            measuredHeight = measuredWidth;
        }

        cx = measuredWidth / 2;
        cy = measuredHeight / 2;
        radius = cx;

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2 * strokeWidth);
        paint.setColor(strokeColor);

        canvas.drawCircle(cx, cy, radius, paint);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();

        Path path = new Path();
        path.addCircle(cx, cy, radius, Path.Direction.CCW);
        canvas.clipPath(path);
        super.draw(canvas);
    }
}
