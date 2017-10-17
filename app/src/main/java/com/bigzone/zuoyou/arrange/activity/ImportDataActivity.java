package com.bigzone.zuoyou.arrange.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.arrange.adapter.ImportDataAdapter;
import com.bigzone.zuoyou.arrange.bean.ImportDataEntity;
import com.bigzone.zuoyou.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by haohongwei on 2017/9/18.
 */

public class ImportDataActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.listView)
    ListView listView;
    private ImportDataAdapter importDataAdapter;
    private List<ImportDataEntity> list = new ArrayList<>();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_import_data;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        importDataAdapter = new ImportDataAdapter(this, list);
        listView.setAdapter(importDataAdapter);
        initData();
        listView.setOnItemClickListener(this);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                list.add(new ImportDataEntity("512398590184", "李老板 XXXXXXX", "上海市闵行区", "2017-09-20", false));
            } else {
                list.add(new ImportDataEntity("435928394839", "顾老板 XXXXXXX", "南京市秦淮区", "2017-10-01", true));
            }
        }
        importDataAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_back)
    void back(){
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        changeActivity(DataDetailActivity.class);
    }
}
