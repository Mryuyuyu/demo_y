package com.example.mryu.demo_y.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.mryu.demo_y.utils.R1FragmentCreator;

public class R1ViewPagerAdapter extends FragmentPagerAdapter {
    public R1ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return R1FragmentCreator.getFragment(position);
    }

    @Override
    public int getCount() {
        return R1FragmentCreator.PAGE_COUNT;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //如果注释这行，那么不管怎么切换，page都不会被销毁
        //super.destroyItem(container, position, object);
    }
}
