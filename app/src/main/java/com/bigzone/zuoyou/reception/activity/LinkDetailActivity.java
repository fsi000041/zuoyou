package com.bigzone.zuoyou.reception.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/9.
 */

public class LinkDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_add;


    @Override
    protected int bindLayout() {
        return R.layout.activity_link_detail;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("关联新潜客");
        tv_add.setText("保存并关联");
        tv_add.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

}
