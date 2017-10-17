package com.bigzone.zuoyou.Attendance.Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.Attendance.Activity.View.XCRoundImageView;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WorkOverTimeDetilActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.xcr_iv)
    XCRoundImageView xcrIv;

    @Override
    protected int bindLayout() {
        return R.layout.activity_work_over_time_detil;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        xcrIv.setImageResource(R.drawable.app_logo);
        tvTitle.setText("加班申请");
    }


    @OnClick({R.id.tv_title, R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_title:
                break;
            case R.id.iv_back:
                finish();
                break;

        }
    }




}
