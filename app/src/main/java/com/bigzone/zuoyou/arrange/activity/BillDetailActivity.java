package com.bigzone.zuoyou.arrange.activity;

import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/14.
 */

public class BillDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override
    protected int bindLayout() {
        return R.layout.activity_bill_detail;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("单据详情");
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}

