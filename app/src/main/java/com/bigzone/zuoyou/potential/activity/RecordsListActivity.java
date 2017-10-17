package com.bigzone.zuoyou.potential.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.potential.adapter.PotentialRecordAdapter;
import com.bigzone.zuoyou.reception.bean.RecordEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/14.
 */

public class RecordsListActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_add;
    @BindView(R.id.listView)
    ListView listView;
    private List<RecordEntity> list = new ArrayList<>();
    private PotentialRecordAdapter recordAdapter;


    @Override
    protected int bindLayout() {
        return R.layout.activity_records_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_add.setText("添加");
        tv_add.setVisibility(View.VISIBLE);
        tv_title.setText("接待记录");
        recordAdapter = new PotentialRecordAdapter(list, this);
        listView.setAdapter(recordAdapter);
        initData();
    }

    private void initData() {
        list.add(new RecordEntity(0, "录音0", "2017-08-08 10:00-10:20", "新街口店张小姐"));
        list.add(new RecordEntity(1, "录音1", "2017-08-08 16:00-16:20", "常府街店张小姐"));
        list.add(new RecordEntity(2, "录音2", "2017-08-08 19:00-19:20", "夫子庙店张小姐"));
        list.add(new RecordEntity(3, "录音3", "2017-08-08 20:00-20:30", "张府园店张小姐"));
        list.add(new RecordEntity(4, "录音4", "2017-08-08 22:10-22:24", "新街口店李小姐"));
        recordAdapter.notifyDataSetChanged();
    }


    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
