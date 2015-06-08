package com.seven.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seven.switchtabsdemo.R;

import java.util.List;

/**
 * Created by htyuan on 15-6-8.
 * <p/>
 * 切换标签widget
 */
public class TabLabelSwitch implements View.OnClickListener {
    private Context mContext;
    private ViewGroup mRootView;
    private int mCurrentPos = -1;
    private OnSWitchListener mOnSwitchListener;


    public static interface OnSWitchListener {
        public void onSwitch(int index);
    }


    public TabLabelSwitch(View rootView) {
        this.mRootView = (ViewGroup) rootView;
        mContext = mRootView.getContext();
    }

    /**
     * 标签，暂时是3个
     *
     * @param lables
     */
    public void setLables(List<String> lables) {
        for (int index = 0; index < lables.size(); index++) {
            View panel = mRootView.getChildAt(index);
            panel.setOnClickListener(this);
            panel.setTag(index);

            TextView label = (TextView) panel.findViewById(R.id.label);
            label.setText(lables.get(index));

            ImageView cursorView = (ImageView) mRootView.findViewById(R.id.cursor);
            cursorView.setImageResource(R.drawable.ic_cursor_label_default);
        }

        switchTo(0);
    }

    public void switchTo(int willIndex) {
        if (willIndex == mCurrentPos) {
            return;
        }

        if (mCurrentPos >= 0) {
            View currentPanel = mRootView.getChildAt(mCurrentPos);
            setDefaultStyle(currentPanel);
        }

        View nextPanel = mRootView.getChildAt(willIndex);
        setActiveStyle(nextPanel);

        mCurrentPos = willIndex;
    }

    @Override
    public void onClick(View v) {
        int index = (int) v.getTag();
        if (index == mCurrentPos) {
            return;
        }

        if (mOnSwitchListener != null) {
            mOnSwitchListener.onSwitch(index);
        }

        switchTo(index);
    }

    private void setActiveStyle(View panel) {
        TextView label = (TextView) panel.findViewById(R.id.label);
        //TODO
        ImageView cursorView = (ImageView) panel.findViewById(R.id.cursor);
        cursorView.setImageResource(R.drawable.ic_cursor_label_select);
    }

    private void setDefaultStyle(View panel) {
        TextView label = (TextView) panel.findViewById(R.id.label);
        //TODO
        ImageView cursorView = (ImageView) panel.findViewById(R.id.cursor);
        cursorView.setImageResource(R.drawable.ic_cursor_label_default);
    }

    public void setOnSwitchListener(OnSWitchListener onSWitchListener) {
        this.mOnSwitchListener = onSWitchListener;
    }
}


































