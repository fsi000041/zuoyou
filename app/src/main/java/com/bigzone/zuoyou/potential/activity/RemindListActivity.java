package com.bigzone.zuoyou.potential.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.potential.adapter.RemindAdapter;
import com.bigzone.zuoyou.potential.bean.RemindEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/14.
 */

public class RemindListActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_add;
    @BindView(R.id.listView)
    ListView listView;
    private List<RemindEntity> list = new ArrayList<>();
    private RemindAdapter adapter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_remind_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_add.setText("添加");
        tv_add.setVisibility(View.VISIBLE);
        tv_title.setText("提醒");
        adapter = new RemindAdapter(list, this);
        listView.setAdapter(adapter);
        initData();
    }

    private void initData() {
        list.add(new RemindEntity("2017.08.15 10:00", "张设计", "去客户家测量沙发", false));
        list.add(new RemindEntity("2017.08.15 12:30", "王导购", "给客户发设计图", true));
        list.add(new RemindEntity("2017.08.20 14:40", "李设计", "去客户家测量尺寸，注意客户不一定在家，一定要提前半小时电话沟通", false));
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnClick(R.id.tv_top_right)
    void addRemind(){
        changeActivity(RemindDetailActivity.class);
    }
}
