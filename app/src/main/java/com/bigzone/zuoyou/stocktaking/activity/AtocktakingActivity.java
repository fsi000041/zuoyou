package com.bigzone.zuoyou.stocktaking.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sszz on 2017/9/15.
 */

public class AtocktakingActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.iv_top_right)
    ImageView ivTopRight;
    @BindView(R.id.rl_new)
    RelativeLayout rlNew;
    @BindView(R.id.rl_record)
    RelativeLayout rlRecord;

    @Override
    protected int bindLayout() {
        return R.layout.activity_atocktaking;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("盘点");
    }


    @OnClick({R.id.iv_back, R.id.rl_new,R.id.rl_record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_new:
                changeActivity(SweepCodePhotoActivity.class);
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_record:
                changeActivity(AtocktakingRecordActivity.class);
        }
    }


}
