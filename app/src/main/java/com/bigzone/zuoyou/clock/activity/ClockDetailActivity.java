package com.bigzone.zuoyou.clock.activity;

import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/16.
 */

public class ClockDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.tv_address)
    TextView tv_address;

    @Override
    protected int bindLayout() {
        return R.layout.activity_clock_detail;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("签到");
        tv_time.setText(getIntent().getStringExtra("time"));
        tv_address.setText(getIntent().getStringExtra("address"));
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
