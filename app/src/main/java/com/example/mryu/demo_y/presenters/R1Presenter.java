package com.example.mryu.demo_y.presenters;

import com.example.mryu.demo_y.bean.DataBean;
import com.example.mryu.demo_y.interfaces.IR1Presenter;
import com.example.mryu.demo_y.interfaces.IR1ViewCallBack;

import java.util.ArrayList;
import java.util.List;

public class R1Presenter implements IR1Presenter {

    private static R1Presenter mInstance = null;
    private  IR1ViewCallBack mR1ViewCallBack = null;
    private List<IR1ViewCallBack> mCallBacks = new ArrayList<>();

    private R1Presenter() {

    }

    public R1Presenter getInstance() {
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
    public void loadData(DataBean dataBean) {
        //TODO:连接数据库获取数据
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
