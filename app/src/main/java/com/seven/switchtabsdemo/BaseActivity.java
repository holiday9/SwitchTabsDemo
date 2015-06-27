package com.seven.switchtabsdemo;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.seven.tabhost.TabHostActivty;

/**
 * Created by htyuan on 15-6-26.
 */
public class BaseActivity extends FragmentActivity{
    public void gotoActivity(Class<?> classzz) {
        Intent intent = new Intent(this, classzz);
        startActivity(intent);
    }
}
