package com.bigzone.zuoyou.sales.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/7/21.
 */

public class PayMoneyActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_save;
    @BindView(R.id.rl_bank)
    RelativeLayout rl_bank;

    @Override
    protected int bindLayout() {
        return R.layout.activity_paymoney;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("交款");
        tv_save.setText("提交");
        tv_save.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnClick(R.id.tv_top_right)
    void save() {
        ToastUtils.showShortMsg("提交");
    }

    @OnClick(R.id.rb_cash)
    void cash() {
        rl_bank.setVisibility(View.GONE);
    }

    @OnClick(R.id.rb_bank)
    void bank() {
        rl_bank.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.rb_ali)
    void ali() {
        rl_bank.setVisibility(View.GONE);
    }

    @OnClick(R.id.rb_wechat)
    void wechat() {
        rl_bank.setVisibility(View.GONE);
    }
}
