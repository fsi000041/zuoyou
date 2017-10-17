package com.bigzone.zuoyou.billing.activity;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.main.activity.MainActvity;
import com.bigzone.zuoyou.sales.activity.SalesListActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sszz on 2017/9/28.
 */

public class SalesSuccessActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.bt_go)
    Button btGo;
    @BindView(R.id.bt_back)
    Button btBack;
    private static ArrayList<Activity> activities;
    @Override
    protected int bindLayout() {
        return R.layout.activity_sales_success;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("结果页");
        ivBack.setVisibility(View.GONE);
    }


    @OnClick({R.id.bt_go, R.id.bt_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_go:
                //去订单界面
                changeActivity(SalesListActivity.class);
                break;
            case R.id.bt_back:
                //返回首页
                changeActivity(MainActvity.class);
                break;
        }
    }
}
