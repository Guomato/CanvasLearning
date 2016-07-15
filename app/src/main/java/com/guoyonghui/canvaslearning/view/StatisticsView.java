package com.guoyonghui.canvaslearning.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.guoyonghui.canvaslearning.R;

public class StatisticsView extends View {

    private Context mContext;

    private Paint mPaint;

    private Rect mRect;

    private Paint.FontMetricsInt mFmi;

    private String mText;

    private int mBaselineY;

    private boolean mDrawBase = false;

    private boolean mDrawTop = false;

    private boolean mDrawBottom = false;

    private boolean mDrawAscent = false;

    private boolean mDrawDescent = false;

    private boolean mDrawText = false;

    public void drawBaseline() {
        mDrawBase = true;
        invalidate();
    }

    public void drawTop() {
        mDrawTop = true;
        invalidate();
    }

    public void drawBottom() {
        mDrawBottom = true;
        invalidate();
    }

    public void drawAscent() {
        mDrawAscent = true;
        invalidate();
    }

    public void drawDescent() {
        mDrawDescent = true;
        invalidate();
    }

    public void drawText(String text) {
        mText = text;
        mDrawText = true;
        invalidate();
    }

    public void reset() {
        mDrawBase = false;
        mDrawTop = false;
        mDrawBottom = false;
        mDrawAscent = false;
        mDrawDescent = false;
        mDrawText = false;
        invalidate();
    }

    public StatisticsView(Context context) {
        super(context);

        init(context);
    }

    public StatisticsView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public StatisticsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        mContext = context;

        mRect = new Rect();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);
        mPaint.setTextSize(72);

        mFmi = mPaint.getFontMetricsInt();
    }

    private int getColor(int resId) {
        return getResources().getColor(resId);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRect.set(0, 400, getWidth(), 600);
        mBaselineY = (mRect.top + mRect.bottom - mFmi.top - mFmi.bottom) / 2;

        canvas.save();

        //draw background
        mPaint.setColor(getColor(R.color.canvas_color));
        canvas.drawRect(mRect, mPaint);

        canvas.restore();

        if (mDrawBase) {
            drawBaseline(canvas);
        }

        if (mDrawTop) {
            drawTop(canvas);
        }

        if (mDrawBottom) {
            drawBottom(canvas);
        }

        if (mDrawAscent) {
            drawAscent(canvas);
        }

        if (mDrawDescent) {
            drawDescent(canvas);
        }

        if (mDrawText) {
            drawText(canvas);
        }
    }

    private void drawBaseline(Canvas canvas) {
        canvas.save();

        mPaint.setColor(getColor(android.R.color.holo_red_light));
        canvas.drawLine(0, mBaselineY, getWidth(), mBaselineY, mPaint);

        canvas.restore();
    }

    private void drawTop(Canvas canvas) {
        canvas.save();

        mPaint.setColor(getColor(android.R.color.black));
        canvas.drawLine(0, mBaselineY + mFmi.top, getWidth(), mBaselineY + mFmi.top, mPaint);

        canvas.restore();
    }

    private void drawBottom(Canvas canvas) {
        canvas.save();

        mPaint.setColor(getColor(android.R.color.black));
        canvas.drawLine(0, mBaselineY + mFmi.bottom, getWidth(), mBaselineY + mFmi.bottom, mPaint);

        canvas.restore();
    }

    private void drawAscent(Canvas canvas) {
        canvas.save();

        mPaint.setColor(getColor(android.R.color.holo_blue_light));
        canvas.drawLine(0, mBaselineY + mFmi.ascent, getWidth(), mBaselineY + mFmi.ascent, mPaint);

        canvas.restore();
    }

    private void drawDescent(Canvas canvas) {
        canvas.save();

        mPaint.setColor(getColor(android.R.color.holo_green_light));
        canvas.drawLine(0, mBaselineY + mFmi.descent, getWidth(), mBaselineY + mFmi.descent, mPaint);

        canvas.restore();
    }

    private void drawText(Canvas canvas) {
        canvas.save();

        mPaint.setColor(getColor(R.color.colorPrimary));
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(mText, mRect.centerX(), mBaselineY, mPaint);

        canvas.restore();
    }
}
