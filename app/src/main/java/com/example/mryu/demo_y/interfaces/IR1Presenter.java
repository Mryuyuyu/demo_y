package com.example.mryu.demo_y.interfaces;

import com.example.mryu.demo_y.bean.DataBean;

public interface IR1Presenter {

    /**
     * 加载数据
     *
     */
    void loadData();

    /**
     * 注册回调
     * @param callBack
     */
    void registerImageViewCallBack(IR1ViewCallBack callBack);


    /**
     * 取消注册
     */
    void unRegisterImageViewCallBack(IR1ViewCallBack callBack);

}
