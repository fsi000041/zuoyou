package com.bigzone.zuoyou.reception.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.reception.adapter.LinkAdapter;
import com.bigzone.zuoyou.reception.bean.LinkEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/9.
 */

public class LinkListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_add;
    @BindView(R.id.listView)
    ListView listView;
    private List<LinkEntity> list = new ArrayList<>();
    private LinkAdapter linkAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_link_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("关联潜客");
        tv_add.setText("关联新潜客");
        tv_add.setVisibility(View.VISIBLE);
        linkAdapter = new LinkAdapter(list, this);
        listView.setAdapter(linkAdapter);
        initData();
        listView.setOnItemClickListener(this);
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            list.add(new LinkEntity("老王" + i, "1383838438"));
        }
        linkAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        changeActivity(LinkDetailActivity.class);
    }
}
