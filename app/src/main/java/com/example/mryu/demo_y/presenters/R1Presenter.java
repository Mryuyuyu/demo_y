package com.example.mryu.demo_y.presenters;

import android.util.Log;

import com.example.mryu.demo_y.bean.DataBean;
import com.example.mryu.demo_y.interfaces.IR1Presenter;
import com.example.mryu.demo_y.interfaces.IR1ViewCallBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class R1Presenter implements IR1Presenter {

    private static final String TAG = "R1Presenter";
    private static R1Presenter mInstance = null;
    private  IR1ViewCallBack mR1ViewCallBack = null;
    private List<IR1ViewCallBack> mCallBacks = new ArrayList<>();

    private R1Presenter() {

    }

    public static R1Presenter getInstance() {
        if (mInstance == null) {
            synchronized (R1Presenter.class) {
                if (mInstance == null) {
                    mInstance = new R1Presenter();
                }
            }
        }
        return mInstance;
    }

    @Override
    public void loadData() {
        //TODO:连接数据库获取数据
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                DataBean dataBean = new DataBean();
                dataBean.setM1_up((float) (Math.random()*120));
                dataBean.setM1_down((float) (Math.random()*(-120)));
                dataBean.setPressure((float) (Math.random()*2400));
                Log.e(TAG,"没隔2秒执行一次操作");
                if (mCallBacks != null) {
                    for (int i = 0; i < mCallBacks.size(); i++) {
                        mCallBacks.get(i).onSuccess(dataBean);
                    }
                }
            }
        },1000,1000);
    }

    @Override
    public void registerImageViewCallBack(IR1ViewCallBack callBack) {
        //注册回调，此工程有3个界面的回调
        if (mCallBacks != null && !mCallBacks.contains(callBack)) {
            mCallBacks.add(callBack);
        }
    }

    @Override
    public void unRegisterImageViewCallBack(IR1ViewCallBack callBack) {
        if (mCallBacks != null) {
            mCallBacks.remove(callBack);
        }
    }
}
