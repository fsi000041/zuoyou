package com.bigzone.zuoyou.potential.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.potential.adapter.ScheduleAdapter;
import com.bigzone.zuoyou.potential.bean.ScheduleEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/23.
 */

public class ScheduleActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_change;
    @BindView(R.id.listView)
    ListView listView;
    private ScheduleAdapter scheduleAdapter;
    private List<ScheduleEntity> list = new ArrayList<>();

    @Override
    protected int bindLayout() {
        return R.layout.activity_schedule;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("接待进度");
        tv_change.setText("切换模板");
        tv_change.setVisibility(View.VISIBLE);
        scheduleAdapter = new ScheduleAdapter(list, this);
        listView.setAdapter(scheduleAdapter);
        initData();
    }

    private void initData() {
        list.add(new ScheduleEntity("初次接待", "2017-07-01 16:00 完成"));
        list.add(new ScheduleEntity("初次接待", "2017-08-11 18:30 完成"));
        list.add(new ScheduleEntity("出方案", "标记完成"));
        list.add(new ScheduleEntity("报价", "未开始"));
        list.add(new ScheduleEntity("上门测量", "未开始"));
        list.add(new ScheduleEntity("交易完成", "未开始"));
        list.add(new ScheduleEntity("回访", "未开始"));
        scheduleAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
