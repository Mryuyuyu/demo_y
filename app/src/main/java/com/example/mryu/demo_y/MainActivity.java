package com.example.mryu.demo_y;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mryu.demo_y.fragments.R1MainFragment;
import com.example.mryu.demo_y.fragments.R2MainFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        initView();
    }

    private void initView() {
        BottomTabBar bottomTabBar = findViewById(R.id.bottom_tab_bar);
        bottomTabBar.init(getSupportFragmentManager())
                .setFontSize(20)//设置文字的尺寸
                .setTabPadding(10, 6, 10)//设置ICON图片与上部分割线的间隔、图片与文字的间隔、文字与底部的间隔
                .addTabItem("R1", null, R1MainFragment.class)//设置文字、一张图片、fragment
                .addTabItem("R2", null, R2MainFragment.class)
                .isShowDivider(false)//设置是否显示分割线
                .setTabBarBackgroundResource(R.drawable.bg_white)//设置底部导航栏的背景图片【与设置底部导航栏颜色方法不能同时使用，否则会覆盖掉前边设置的颜色】
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {
                        switch (position) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                        }
                    }
                })
                .setCurrentTab(0);   //设置当前选中的Tab，从0开始
    }
}
