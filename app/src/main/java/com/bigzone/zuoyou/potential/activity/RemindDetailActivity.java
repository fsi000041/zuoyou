package com.bigzone.zuoyou.potential.activity;

import android.view.View;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/14.
 */

public class RemindDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_save;

    @Override
    protected int bindLayout() {
        return R.layout.activity_remind_detail;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_save.setText("保存");
        tv_save.setVisibility(View.VISIBLE);
        tv_title.setText("添加提醒");
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
