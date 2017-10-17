package com.bigzone.zuoyou.billing.activity;

import android.view.View;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/7/19.
 *
 */

public class AddressAddActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_top_right;

    @Override
    protected int bindLayout() {
        return R.layout.activity_add_addresss;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
//        MyApp.addActivity(this);
        tv_title.setText("编辑地址");
        tv_top_right.setText("保存并使用");
        tv_top_right.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnClick(R.id.rl_address)
    void chooseAddress() {
        ToastUtils.showShortMsg("请选择地址");
    }

    @OnClick(R.id.tv_top_right)
    void saveAndUser() {
        ToastUtils.showShortMsg("保存使用成功");
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
