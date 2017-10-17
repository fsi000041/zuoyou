package com.bigzone.zuoyou.Attendance.Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sszz on 2017/9/12.
 */

public class LeaveDetalActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;

    @Override
    protected int bindLayout() {
        return R.layout.activity_leave_detail;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("请假详情");

    }


    @OnClick({R.id.tv_title, R.id.iv_back, R.id.tv_top_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_title:
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_top_right:
                break;
        }
    }
}
