package com.bigzone.zuoyou.arrange.activity;

import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/20.
 */

public class PlatoonOrderActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override
    protected int bindLayout() {
        return R.layout.activity_platoon_order;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("排车顺序");
    }


    @OnClick(R.id.btn_next)
    void changeNext() {
        changeActivity(PlatoonBillingActivity.class);
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
