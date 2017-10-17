package com.bigzone.zuoyou.billing.activity;

import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CodeScanActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_code_scan;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
//        MyApp.addActivity(this);
        tv_title.setText("扫一扫");
    }
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK
//                && event.getAction() == KeyEvent.ACTION_DOWN) {
//            MyApp.remove();
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
