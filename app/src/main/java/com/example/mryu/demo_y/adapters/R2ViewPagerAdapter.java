package com.example.mryu.demo_y.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.mryu.demo_y.utils.R2FragmentCreator;

public class R2ViewPagerAdapter extends FragmentPagerAdapter {
    public R2ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return R2FragmentCreator.getFragment(position);
    }

    @Override
    public int getCount() {
        return R2FragmentCreator.PAGE_COUNT;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //如果注释这行，那么不管怎么切换，page都不会被销毁
        //super.destroyItem(container, position, object);
    }
}
