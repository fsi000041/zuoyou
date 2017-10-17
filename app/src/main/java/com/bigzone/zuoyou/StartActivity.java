package com.bigzone.zuoyou;

import android.os.Handler;

import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.common.Constants;
import com.bigzone.zuoyou.login.activity.LoginActivity;

public class StartActivity extends BaseActivity {

    @Override
    protected int bindLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                changeActivity(LoginActivity.class);
                finish();
            }
        }, Constants.START_TIME);
    }

}
