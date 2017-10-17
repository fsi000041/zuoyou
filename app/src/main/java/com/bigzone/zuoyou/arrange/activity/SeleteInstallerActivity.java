package com.bigzone.zuoyou.arrange.activity;

import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.arrange.adapter.CarAdapter;
import com.bigzone.zuoyou.arrange.bean.CarEntity;
import com.bigzone.zuoyou.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/15.
 */

public class SeleteInstallerActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.listView)
    ListView listView;
    private List<CarEntity> list=new ArrayList<>();
    private CarAdapter carAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_selete_car;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("选择安装工");
        carAdapter=new CarAdapter(this,list);
        listView.setAdapter(carAdapter);
        initData();

    }

    private void initData() {
        list.add(new CarEntity("安装工1", "工号：001"));
        list.add(new CarEntity("安装工2", "工号：002"));
        list.add(new CarEntity("安装工3", "工号：003"));
        carAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_back)
    void back(){
        finish();
    }
}
