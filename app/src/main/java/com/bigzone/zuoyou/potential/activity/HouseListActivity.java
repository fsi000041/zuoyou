package com.bigzone.zuoyou.potential.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.potential.adapter.HouseAdapter;
import com.bigzone.zuoyou.potential.bean.HouseEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/14.
 */

public class HouseListActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_save;
    @BindView(R.id.listView)
    ListView listView;
    private List<HouseEntity> list = new ArrayList<>();
    private HouseAdapter adapter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_house_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("住宅");
        tv_save.setText("添加");
        tv_save.setVisibility(View.VISIBLE);
        adapter = new HouseAdapter(list, this);
        listView.setAdapter(adapter);
        initData();
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            list.add(new HouseEntity("小区名称", "三室一厅", "2017.08.10"));
        }
        adapter.notifyDataSetChanged();
    }


    @OnClick(R.id.tv_top_right)
    void changeHouseAdd() {
        changeActivity(HouseDetailActivity.class);
    }

    @OnClick(R.id.iv_back)
    void back(){
        finish();
    }
}
