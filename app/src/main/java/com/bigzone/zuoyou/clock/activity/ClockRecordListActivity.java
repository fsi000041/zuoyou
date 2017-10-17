package com.bigzone.zuoyou.clock.activity;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.clock.adapter.ClockRecordAdapter;
import com.bigzone.zuoyou.clock.bean.ClockRecordEntity;
import com.bigzone.zuoyou.clock.bean.ItemRecordEntity;
import com.bigzone.zuoyou.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/17.
 */

public class ClockRecordListActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_search;
    @BindView(R.id.listView)
    ExpandableListView listView;
    private ClockRecordAdapter clockRecordAdapter;
    private List<ClockRecordEntity> list = new ArrayList<>();


    @Override
    protected int bindLayout() {
        return R.layout.activity_clock_record_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_search.setText("筛选");
        tv_search.setVisibility(View.VISIBLE);
        tv_title.setText("考勤记录");
        clockRecordAdapter = new ClockRecordAdapter(this, list);
        listView.setAdapter(clockRecordAdapter);
        initData();
    }

    private void initData() {
        ClockRecordEntity entity11 = new ClockRecordEntity();
        entity11.setTime("今日");
        ItemRecordEntity timeEntity12 = new ItemRecordEntity("08:55", "签到");
        ItemRecordEntity timeEntity13 = new ItemRecordEntity("18:05", "签退");
        List<ItemRecordEntity> list11 = new ArrayList<>();
        list11.add(timeEntity12);
        list11.add(timeEntity13);
        entity11.setTimeEntityList(list11);
        list.add(entity11);

        ClockRecordEntity entity21 = new ClockRecordEntity();
        entity21.setTime("昨日");
        ItemRecordEntity timeEntity22 = new ItemRecordEntity("08:30", "签到");
        ItemRecordEntity timeEntity23 = new ItemRecordEntity("08:45", "签到");
        ItemRecordEntity timeEntity24 = new ItemRecordEntity("18:30", "签退");
        List<ItemRecordEntity> list21 = new ArrayList<>();
        list21.add(timeEntity22);
        list21.add(timeEntity23);
        list21.add(timeEntity24);
        entity21.setTimeEntityList(list21);
        list.add(entity21);

        ClockRecordEntity entity31 = new ClockRecordEntity();
        entity31.setTime("2017.08.15");
        ItemRecordEntity timeEntity32 = new ItemRecordEntity("08:44", "签到");
        ItemRecordEntity timeEntity33 = new ItemRecordEntity("18:22", "签退");
        ItemRecordEntity timeEntity34 = new ItemRecordEntity("18:30", "签退");
        List<ItemRecordEntity> list31 = new ArrayList<>();
        list31.add(timeEntity32);
        list31.add(timeEntity33);
        list31.add(timeEntity34);
        entity31.setTimeEntityList(list31);
        list.add(entity31);

        clockRecordAdapter.notifyDataSetChanged();

        int groupCount = listView.getCount();

        for (int i = 0; i < groupCount; i++) {

            listView.expandGroup(i);

        }
        ;
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
