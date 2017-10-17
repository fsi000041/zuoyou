package com.bigzone.zuoyou.utils;

import android.app.Activity;

import com.bigzone.zuoyou.Attendance.Activity.Adapter.GoodsCategory;

import java.util.ArrayList;
import java.util.List;

import cn.qqtheme.framework.picker.DateTimePicker;
import cn.qqtheme.framework.picker.SinglePicker;

/**
 * Created by sszz on 2017/10/17.
 */

public class PickerUtils {
    private static Activity context;

    //单项假期类型选择器
    public static void onSinglePicker() {
        List<GoodsCategory> data = new ArrayList<>();
        data.add(new GoodsCategory(1, "事价"));
        data.add(new GoodsCategory(2, "丧家  "));
        data.add(new GoodsCategory(3, "休假"));
        data.add(new GoodsCategory(4, "病假"));
        SinglePicker<GoodsCategory> picker = new SinglePicker<GoodsCategory>(context, data);
        picker.setCanceledOnTouchOutside(false);
        picker.setSelectedIndex(0);
        // picker.setCycleDisable(false);
        picker.setOnItemPickListener(new SinglePicker.OnItemPickListener<GoodsCategory>() {
            @Override
            public void onItemPicked(int index, GoodsCategory item) {
                String leixing = item.getName().toString();
                //tvLeave.setText(leixing);
                ToastUtils.showShortMsg("index=" + index + ", id=" + item.getId() + ", name=" + item.getName());
            }
        });
        picker.show();
    }

    //开始时间选择器
    public static void onStartYearMonthDayTimePicker() {
        DateTimePicker picker = new DateTimePicker(context, DateTimePicker.HOUR_24);
        picker.setDateRangeStart(2017, 1, 1);
        picker.setDateRangeEnd(2025, 11, 11);
        picker.setTimeRangeStart(9, 0);
        picker.setTimeRangeEnd(20, 30);
        picker.setTopLineColor(0x99FF0000);
        picker.setLabelTextColor(0xFFFF0000);
        picker.setDividerColor(0xFFFF0000);
        picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
            @Override
            public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                String startTime = year + "-" + month + "-" + day + " " + hour + ":" + minute;
                ToastUtils.showShortMsg(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                //tvStartTime.setText(startTime);
            }
        });
        picker.show();
    }

    //结束时间选择器
    public static void onEndYearMonthDayTimePicker() {
        DateTimePicker picker = new DateTimePicker(context, DateTimePicker.HOUR_24);
        picker.setDateRangeStart(2017, 1, 1);
        picker.setDateRangeEnd(2025, 11, 11);
        picker.setTimeRangeStart(9, 0);
        picker.setTimeRangeEnd(20, 30);
        picker.setTopLineColor(0x99FF0000);
        picker.setLabelTextColor(0xFFFF0000);
        picker.setDividerColor(0xFFFF0000);
        picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
            @Override
            public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                String endtTime = year + "-" + month + "-" + day + " " + hour + ":" + minute;
                ToastUtils.showShortMsg(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                //tvEndTime.setText(endtTime);
            }
        });
        picker.show();
    }
}
