package com.example.mryu.demo_y.fragments;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mryu.demo_y.R;
import com.example.mryu.demo_y.adapters.R1IndicatorAdapter;
import com.example.mryu.demo_y.adapters.R1ViewPagerAdapter;
import com.example.mryu.demo_y.base.BaseFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

public class R1MainFragment extends BaseFragment {

    private View mRootView;
    private ViewPager mViewPager;
    private R1IndicatorAdapter mR1IndicatorAdapter;

    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        mRootView = layoutInflater.inflate(R.layout.fragment_r1_main, container, false);
        initView();
        return mRootView;
    }

    private void initView() {
        //初始化ViewPager
        mViewPager = mRootView.findViewById(R.id.content_pager);
        //创建内容适配器
        R1ViewPagerAdapter r1ViewPagerAdapter = new R1ViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(r1ViewPagerAdapter);

        //2.初始化 MagicIndicator
        MagicIndicator magicIndicator = mRootView.findViewById(R.id.magic_indicator);
        magicIndicator.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        //创建 CommonNavigator 和 R1IndicatorAdapter
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        mR1IndicatorAdapter = new R1IndicatorAdapter(getContext(), R.array.indicator_array);
        mR1IndicatorAdapter.setIndicaterListener(new R1IndicatorAdapter.OnIndicaterTapClickListener() {
            @Override
            public void onTabClick(int index) {
                mViewPager.setCurrentItem(index);
            }
        });
        commonNavigator.setAdapter(mR1IndicatorAdapter);
        commonNavigator.setAdjustMode(true);
        magicIndicator.setNavigator(commonNavigator);
        //把 ViewPager 和 indicator  绑定, viewPager滑动, indicator也跟着滑动
        ViewPagerHelper.bind(magicIndicator, mViewPager);

        mViewPager.setCurrentItem(1);
    }

    @Override
    public void initData() {
        super.initData();
    }
}
