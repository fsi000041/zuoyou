package com.bigzone.zuoyou.stocktaking.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.stocktaking.activity.adapter.AtocktakingRecordAdapter;
import com.bigzone.zuoyou.stocktaking.activity.bean.AtocktakingRecordBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AtocktakingRecordActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv)
    ListView lv;
    private List<AtocktakingRecordBean> list;


    @Override
    protected int bindLayout() {
        return R.layout.activity_atocktaking_record;
    }

    @Override
    protected void initView()    {
        ButterKnife.bind(this);
        tvTitle.setText("盘点记录");
        initData();
        lv.setAdapter(new AtocktakingRecordAdapter(list,this));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                changeActivity(AtocktakingRecordDetailActivity.class);
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add(new AtocktakingRecordBean("2017.10.22","盘点单号：828282822222"));
        }
    }


    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();

        }
    }
}
