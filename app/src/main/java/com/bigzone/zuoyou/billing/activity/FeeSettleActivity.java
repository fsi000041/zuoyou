package com.bigzone.zuoyou.billing.activity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Seriex.X on 2017/7/7.
 */

public class FeeSettleActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tvSave;
    @BindView(R.id.et_persent)
    EditText et_persent;
    @BindView(R.id.et_discount)
    EditText et_discount;
    @BindView(R.id.et_true_money)
    EditText et_true_money;
    private int totle_money = 600;

    @Override
    protected int bindLayout() {
        return R.layout.activity_settle_fee;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
//        MyApp.addActivity(this);
        tv_title.setText("");
        tvSave.setText("保存");
        tvSave.setVisibility(View.VISIBLE);
        initEditNum();
    }

    private void initEditNum() {
        et_persent.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                et_discount.setText("" + (totle_money * Double.parseDouble(et_persent.getText().toString().trim()) / 100.0));
                et_true_money.setText("" + (totle_money - Double.parseDouble(et_discount.getText().toString().trim())));
                return true;
            }
        });
        et_discount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                et_persent.setText("" + (Double.parseDouble(et_discount.getText().toString().trim())) / totle_money);
                et_true_money.setText("" + (totle_money - Double.parseDouble(et_discount.getText().toString().trim())));
                return true;
            }
        });
        et_true_money.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                et_discount.setText("" + (totle_money - Double.parseDouble(et_true_money.getText().toString().trim())));
                et_persent.setText("" + Double.parseDouble(et_discount.getText().toString().trim()) / totle_money);
                return true;
            }
        });

    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();

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
