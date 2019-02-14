package com.example.mryu.demo_y.utils;

import com.example.mryu.demo_y.base.BaseFragment;
import com.example.mryu.demo_y.fragments.R1BarGraphFragment;
import com.example.mryu.demo_y.fragments.R1ImageFragment;
import com.example.mryu.demo_y.fragments.R1TableFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lqhunter on 2018/12/26.
 */

public class R1FragmentCreator {


    private final static int INDEX_TABLE = 0;
    private final static int INDEX_IMAGE = 1;
    private final static int INDEX_BARGRAPH = 2;

    public final static int PAGE_COUNT = 3;
    private static final String TAG = "R1FragmentCreator";

    private static Map<Integer, BaseFragment> sCache = new HashMap<>();

    public static BaseFragment getFragment(int index) {

        BaseFragment indexFragment = sCache.get(index);
        if (indexFragment != null) {
            LogUtil.d(TAG, indexFragment.toString());
            return indexFragment;
        }

        switch (index) {
            case INDEX_TABLE:
                indexFragment = new R1TableFragment();
                break;
            case INDEX_IMAGE:
                indexFragment = new R1ImageFragment();
                break;
            case INDEX_BARGRAPH:
                indexFragment = new R1BarGraphFragment();
                break;

        }
        sCache.put(index, indexFragment);
        return indexFragment;
    }

}
