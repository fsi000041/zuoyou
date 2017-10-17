package com.bigzone.zuoyou.sign.activity;

import android.widget.Button;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by haohongwei on 2017/9/27.
 */

public class DrawNameActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override
    protected int bindLayout() {
        return R.layout.activity_draw_name;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("签名");
    }
}
