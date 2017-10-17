package com.bigzone.zuoyou.potential.activity;

import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.potential.adapter.WishAdapter;
import com.bigzone.zuoyou.potential.bean.WishEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/14.
 */

public class WishListActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.listView)
    ListView listView;
    private List<WishEntity> list = new ArrayList<>();
    private WishAdapter adapter;


    @Override
    protected int bindLayout() {
        return R.layout.activity_wish_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("欲购清单");
        adapter = new WishAdapter(list, this);
        listView.setAdapter(adapter);
        initData();
    }

    private void initData() {
        list.add(new WishEntity("真皮沙发", "2017.08.10", "设计部", "小王"));
        list.add(new WishEntity("牛皮沙发，檀香木的洗澡桶，钻石的玻璃茶几,沉香木的鼻烟壶", "2017.07.20", "设计部", "小刘"));
        adapter.notifyDataSetChanged();
    }


    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
