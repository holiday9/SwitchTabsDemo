package com.seven.switchtabsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;

import com.seven.tabhost.TabHostActivty;
import com.seven.widget.TabLabelSwitch;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private TabLabelSwitch mTabLabelSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabLabelSwitch();
    }

    private void initTabLabelSwitch() {
        View rootView = findViewById(R.id.switch_tab_label_root);
        mTabLabelSwitch = new TabLabelSwitch(rootView);
        mTabLabelSwitch.setOnSwitchListener(new TabLabelSwitch.OnSWitchListener() {
            @Override
            public void onSwitch(int index) {
                System.out.println("index = " + index);
            }
        });
        List<String> lables = new ArrayList<>();
        lables.add("未使用");
        lables.add("已使用");
        lables.add("已过期");
        mTabLabelSwitch.setLables(lables);
    }

    int pos = 0;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.simple_switch) {
            pos++;
            pos = pos % 3;
            mTabLabelSwitch.switchTo(pos);
        } else if (v.getId() == R.id.tabhost) {
            gotoActivity(TabHostActivty.class);
        }
    }
}
