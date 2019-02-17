package com.example.mryu.demo_y.fragments;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mryu.demo_y.R;
import com.example.mryu.demo_y.base.BaseFragment;
import com.example.mryu.demo_y.bean.DataBean;
import com.example.mryu.demo_y.interfaces.IR1ViewCallBack;
import com.example.mryu.demo_y.presenters.R1Presenter;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class R1ImageFragment extends BaseFragment implements IR1ViewCallBack {
    private static final String TAG = "R1ImageFragment";
    private View mRootView;
    private LineChart mLineChart;
    private XAxis xAxis;                //X轴
    private YAxis leftYAxis;            //左侧Y轴
    private YAxis rightYaxis;           //右侧Y轴
    private Legend legend;              //图例
    private LimitLine limitLine;        //限制线
    private LineData mLineData;

    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        mRootView = layoutInflater.inflate(R.layout.fragment_r1_image, container, false);
        initView();
        return mRootView;
    }


    private void initView() {
        mLineChart = mRootView.findViewById(R.id.chart);
        initChart(mLineChart);
        mLineData = new LineData();


        showLineChart(initM1UpDataList(), "M1_up", Color.RED, "left");
        showLineChart(initM1DownDataList(), "M1_down", Color.GREEN, "left");
        showLineChart(initPressureDataList(), "P", Color.BLUE, "right");

    }

    @Override
    public void initData() {
        R1Presenter.getInstance().registerImageViewCallBack(this);
        R1Presenter.getInstance().loadData();
    }

    @Override
    public void onSuccess(DataBean data) {
        LineData lineData = mLineChart.getLineData();

        ILineDataSet lineM1Up = lineData.getDataSetByIndex(0);
        ILineDataSet lineM1Down = lineData.getDataSetByIndex(1);
        ILineDataSet linePressure = lineData.getDataSetByIndex(2);


        lineM1Up.removeFirst();
        lineM1Down.removeFirst();
        linePressure.removeFirst();
        for (int i = 0; i < 119; i++) {
            Entry entryM1Up = lineM1Up.getEntryForIndex(i);
            entryM1Up.setX(entryM1Up.getX() - 1);

            Entry entryM1Down = lineM1Down.getEntryForIndex(i);
            entryM1Down.setX(entryM1Down.getX() - 1);

            Entry entryPressure = linePressure.getEntryForIndex(i);
            entryPressure.setX(entryPressure.getX() - 1);
        }
        lineM1Up.addEntry(new Entry(120, data.getM1_up()));
        lineM1Down.addEntry(new Entry(120, data.getM1_down()));
        linePressure.addEntry(new Entry(120, data.getPressure()));

        mLineChart.notifyDataSetChanged();
        mLineChart.invalidate();
    }

    @Override
    public void onFail() {

    }

    private void initChart(LineChart lineChart) {
        /***图表设置***/
        //是否展示网格线
        lineChart.setDrawGridBackground(false);
        //是否显示边界
        lineChart.setDrawBorders(true);
        //是否可以拖动
        lineChart.setDragEnabled(false);
        //是否有触摸事件
        lineChart.setTouchEnabled(true);
        //设置XY轴动画效果
        //lineChart.animateY(2500);
        //lineChart.animateX(1500);

        /***XY轴的设置***/
        xAxis = lineChart.getXAxis();
        leftYAxis = lineChart.getAxisLeft();
        rightYaxis = lineChart.getAxisRight();
        //X轴设置显示位置在底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setAvoidFirstLastClipping(true);//显示最旁边坐标轴数字
        xAxis.setLabelCount(11, true);
        //保证Y轴从0开始，不然会上移一点
        //leftYAxis.setAxisMinimum(0f);
        leftYAxis.setAxisMaximum(300f);
        leftYAxis.setAxisMinimum(-300f);
        leftYAxis.setLabelCount(5, true);
        rightYaxis.setAxisMinimum(0f);
        rightYaxis.setAxisMaximum(2500f);
        rightYaxis.setLabelCount(5, true);


        /***折线图例 标签 设置***/
        legend = lineChart.getLegend();
        //设置显示类型，LINE CIRCLE SQUARE EMPTY 等等 多种方式，查看LegendForm 即可
        legend.setForm(Legend.LegendForm.LINE);
        legend.setTextSize(12f);
        //显示位置 左下方
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        //是否绘制在图表里面
        legend.setDrawInside(false);
    }

    /**
     * 曲线初始化设置 一个LineDataSet 代表一条曲线
     *
     * @param lineDataSet 线条
     * @param color       线条颜色
     * @param mode
     */
    private void initLineDataSet(LineDataSet lineDataSet, int color, LineDataSet.Mode mode, String leftOrRight) {
        lineDataSet.setColor(color);
        lineDataSet.setCircleColor(color);
        lineDataSet.setLineWidth(1f);
        lineDataSet.setCircleRadius(1f);
        //设置曲线值的圆点是实心还是空心
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setValueTextSize(10f);
        //设置折线图填充
        lineDataSet.setDrawFilled(false);
        lineDataSet.setFormLineWidth(1f);
        lineDataSet.setFormSize(15.f);
        if (mode == null) {
            //设置曲线展示为圆滑曲线（如果不设置则默认折线）
            lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        } else {
            lineDataSet.setMode(mode);
        }
        if (leftOrRight.equals("right")) {
            lineDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
        }
    }

    /**
     * 展示曲线
     *
     * @param dataList 数据集合
     * @param name     曲线名称
     * @param color    曲线颜色
     */
    public void showLineChart(List<DataBean> dataList, String name, int color, String leftOrRight) {
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            DataBean data = dataList.get(i);
            /**
             * 在此可查看 Entry构造方法，可发现 可传入数值 Entry(float x, float y)
             * 也可传入Drawable， Entry(float x, float y, Drawable icon) 可在XY轴交点 设置Drawable图像展示
             */
            Entry entry = new Entry(i, 0);
            entries.add(entry);
        }
        // 每一个LineDataSet代表一条线
        LineDataSet lineDataSet = new LineDataSet(entries, name);
        initLineDataSet(lineDataSet, color, LineDataSet.Mode.LINEAR, leftOrRight);//折线
        //initLineDataSet(lineDataSet, color, null, leftOrRight);//曲线
        mLineData.addDataSet(lineDataSet);
        mLineChart.setData(mLineData);
    }

    private List<DataBean> initM1UpDataList() {
        List<DataBean> dataBeans = new ArrayList<>();
        for (int i = 0; i < 121; i++) {
            DataBean dataBean = new DataBean();
            dataBeans.add(dataBean);
        }
        return dataBeans;
    }

    private List<DataBean> initM1DownDataList() {
        List<DataBean> dataBeans = new ArrayList<>();
        for (int i = 0; i < 121; i++) {
            DataBean dataBean = new DataBean();
            dataBeans.add(dataBean);
        }
        return dataBeans;
    }

    private List<DataBean> initPressureDataList() {
        List<DataBean> dataBeans = new ArrayList<>();
        for (int i = 0; i < 121; i++) {
            DataBean dataBean = new DataBean();
            dataBeans.add(dataBean);
        }
        return dataBeans;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        R1Presenter.getInstance().unRegisterImageViewCallBack(this);
    }
}
