package com.bigzone.zuoyou.potential.activity;

import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/23.
 */

public class ContactInfoActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override
    protected int bindLayout() {
        return R.layout.activity_contact_info;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("联系方式");
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
