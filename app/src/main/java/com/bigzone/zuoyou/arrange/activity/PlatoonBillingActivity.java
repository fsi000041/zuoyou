package com.bigzone.zuoyou.arrange.activity;

import android.view.View;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/20.
 */

public class PlatoonBillingActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_clear;

    @Override
    protected int bindLayout() {
        return R.layout.activity_platoon_billing;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_clear.setText("清空筛选条件");
        tv_clear.setVisibility(View.VISIBLE);
        tv_title.setText("排车开单");
    }


    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
