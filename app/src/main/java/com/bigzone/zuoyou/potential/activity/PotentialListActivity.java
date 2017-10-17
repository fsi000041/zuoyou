package com.bigzone.zuoyou.potential.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.reception.activity.LinkDetailActivity;
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

public class PotentialListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
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
        return R.layout.activity_potent_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("潜在客户");
        tv_add.setText("添加");
        tv_add.setVisibility(View.VISIBLE);
        linkAdapter = new LinkAdapter(list, this);
        listView.setAdapter(linkAdapter);
        initData();
        listView.setOnItemClickListener(this);
    }

    private void initData() {
        list.add(new LinkEntity("老王1", "首次接待"));
        list.add(new LinkEntity("老王2", "已完成"));
        list.add(new LinkEntity("老王3", "已报价"));
        linkAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        changeActivity(PotentialDetailActivity.class);
    }
}
