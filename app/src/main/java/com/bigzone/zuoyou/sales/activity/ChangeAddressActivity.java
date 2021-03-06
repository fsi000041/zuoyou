package com.bigzone.zuoyou.sales.activity;

import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/7/27.
 */

public class ChangeAddressActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override
    protected int bindLayout() {
        return R.layout.activity_changeaddress;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("变更订单");
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
