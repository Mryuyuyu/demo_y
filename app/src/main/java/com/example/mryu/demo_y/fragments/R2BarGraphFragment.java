package com.example.mryu.demo_y.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mryu.demo_y.R;
import com.example.mryu.demo_y.base.BaseFragment;

public class R2BarGraphFragment extends BaseFragment {
    private View mRootView;

    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        mRootView = layoutInflater.inflate(R.layout.fragment_r1_bar_graph, container, false);
        initView();
        return mRootView;
    }

    private void initView() {

    }
}
