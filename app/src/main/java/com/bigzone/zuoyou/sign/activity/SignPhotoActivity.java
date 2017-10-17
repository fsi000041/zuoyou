package com.bigzone.zuoyou.sign.activity;

import android.widget.GridView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/27.
 */

public class SignPhotoActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_back;
    @BindView(R.id.gv_one)
    GridView gv_one;

    @Override
    protected int bindLayout() {
        return R.layout.activity_sign_photo;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_back.setText("拍照");
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
