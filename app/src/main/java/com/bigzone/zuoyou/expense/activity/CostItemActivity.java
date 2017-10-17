package com.bigzone.zuoyou.expense.activity;

import android.view.View;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/8.
 */

public class CostItemActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_add;

    @Override
    protected int bindLayout() {
        return R.layout.activity_cost_item;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("费用");
        tv_add.setText("保存");
        tv_add.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
