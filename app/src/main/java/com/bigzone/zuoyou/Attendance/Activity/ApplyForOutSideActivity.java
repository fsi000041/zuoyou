package com.bigzone.zuoyou.Attendance.Activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.Attendance.Activity.Adapter.GoodsCategory;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DateTimePicker;
import cn.qqtheme.framework.picker.SinglePicker;

public class ApplyForOutSideActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.iv_top_right)
    ImageView ivTopRight;
    @BindView(R.id.iv_top_left)
    ImageView ivTopLeft;
    @BindView(R.id.tv_top_right)
    TextView tvTopRight;
    @BindView(R.id.tv_top_left)
    TextView tvTopLeft;
    @BindView(R.id.tv_apply_for)
    TextView tvApplyFor;
    @BindView(R.id.tv_apply_for_time)
    TextView tvApplyForTime;
    @BindView(R.id.tv_department)
    TextView tvDepartment;
    @BindView(R.id.et_why_out)
    EditText etWhyOut;
    @BindView(R.id.rl_why_out)
    RelativeLayout rlWhyOut;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.rl_for_what)
    RelativeLayout rlForWhat;
    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.rl_for_where)
    RelativeLayout rlForWhere;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.rl_start_time)
    RelativeLayout rlStartTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.rl_end_time)
    RelativeLayout rlEndTime;
    @BindView(R.id.et_they)
    EditText etThey;
    @BindView(R.id.et_us)
    EditText etUs;
    @BindView(R.id.rl_liucheng)
    RelativeLayout rlLiucheng;
   /* @BindView(R.id.rl_sumbit_leave)
    Button rlSumbitLeave;*/


    @Override
    protected int bindLayout() {
        return R.layout.activity_apply_for_out_side;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("外出申请");


    }
    //单项假期类型选择器
    public void onSinglePicker() {
        List<GoodsCategory> data = new ArrayList<>();
        data.add(new GoodsCategory(1, "事价"));
        data.add(new GoodsCategory(2, "丧家  "));
        data.add(new GoodsCategory(3, "休假"));
        data.add(new GoodsCategory(4, "病假"));
        SinglePicker<GoodsCategory> picker = new SinglePicker<>(this, data);
        picker.setCanceledOnTouchOutside(false);
        picker.setSelectedIndex(0);
        picker.setDividerVisible(false);
        // picker.setCycleDisable(false);
        picker.setOnItemPickListener(new SinglePicker.OnItemPickListener<GoodsCategory>() {
            @Override
            public void onItemPicked(int index, GoodsCategory item) {
                String leixing = item.getName().toString();
                ToastUtils.showShortMsg("index=" + index + ", id=" + item.getId() + ", name=" + item.getName());
                textView.setText(leixing);
            }
        });
        picker.show();
    }

    //开始时间选择器
    public void onStartYearMonthDayTimePicker() {
        DateTimePicker picker = new DateTimePicker(this, DateTimePicker.HOUR_24);
        picker.setDateRangeStart(2017, 1, 1);
        picker.setDateRangeEnd(2025, 11, 11);
        picker.setTimeRangeStart(9, 0);
        picker.setTimeRangeEnd(20, 30);
        picker.setTopLineColor(0x99FF0000);
        picker.setLabelTextColor(0xff000000);
        picker.setDividerColor(0xff000000);
        picker.setDividerVisible(false);
        picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
            @Override
            public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                String startTime = year + "-" + month + "-" + day + " " + hour + ":" + minute;
                ToastUtils.showShortMsg(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                tvStartTime.setText(startTime);
            }
        });
        picker.show();
    }

    //结束时间选择器
    public void onEndYearMonthDayTimePicker() {
        DateTimePicker picker = new DateTimePicker(this, DateTimePicker.HOUR_24);
        picker.setDateRangeStart(2017, 1, 1);
        picker.setDateRangeEnd(2025, 11, 11);
        picker.setTimeRangeStart(9, 0);
        picker.setTimeRangeEnd(20, 30);
        picker.setTopLineColor(0x99FF0000);
        picker.setLabelTextColor(0xff000000);
        picker.setDividerColor(0xff000000);
        picker.setDividerVisible(false);
        picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
            @Override
            public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                String endtTime = year + "-" + month + "-" + day + " " + hour + ":" + minute;
                ToastUtils.showShortMsg(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                tvEndTime.setText(endtTime);
            }
        });
        picker.show();
    }

    @OnClick({R.id.iv_back, R.id.rl_start_time,R.id.rl_end_time,R.id.rl_for_what})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_start_time:
                onStartYearMonthDayTimePicker();
                break;
            case R.id.rl_end_time:
                onEndYearMonthDayTimePicker();
                break;
            case R.id.rl_for_what:
                onSinglePicker();
        }
    }


}
