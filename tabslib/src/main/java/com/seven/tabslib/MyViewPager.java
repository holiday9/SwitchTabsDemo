package com.seven.tabslib;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by htyuan on 15-6-27.
 */
public class MyViewPager extends ViewPager{
    private boolean mScrollable;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollable(boolean scrollable) {
        this.mScrollable = scrollable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /* return false;//super.onTouchEvent(arg0); */
        if (mScrollable)
            return super.onTouchEvent(event);
        else
            return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (mScrollable)
            return super.onInterceptTouchEvent(event);
        else
            return false;
    }

}
