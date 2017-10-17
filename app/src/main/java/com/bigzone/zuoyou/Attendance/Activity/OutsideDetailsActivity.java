package com.bigzone.zuoyou.Attendance.Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OutsideDetailsActivity  extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;

    @Override
    protected int bindLayout() {
        return R.layout.activity_outside_ok_details;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("外勤申请");
    }




    @OnClick(R.id.iv_back)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.iv_back :
                finish();
                break;
        }

    }
}
