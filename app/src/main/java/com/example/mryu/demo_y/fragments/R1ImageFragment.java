package com.example.mryu.demo_y.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mryu.demo_y.R;
import com.example.mryu.demo_y.base.BaseFragment;
import com.example.mryu.demo_y.bean.DataBean;
import com.example.mryu.demo_y.interfaces.IR1ViewCallBack;
import com.example.mryu.demo_y.presenters.R1Presenter;
import com.github.mikephil.charting.charts.LineChart;

public class R1ImageFragment extends BaseFragment implements IR1ViewCallBack {
    private View mRootView;

    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        mRootView = layoutInflater.inflate(R.layout.fragment_r1_image, container, false);
        initView();
        return mRootView;
    }


    private void initView() {
        LineChart chart = mRootView.findViewById(R.id.chart);
    }

    @Override
    public void onSuccess(DataBean data) {

    }

    @Override
    public void onFail() {

    }
}
