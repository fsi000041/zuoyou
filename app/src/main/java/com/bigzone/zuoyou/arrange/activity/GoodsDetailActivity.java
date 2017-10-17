package com.bigzone.zuoyou.arrange.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/14.
 */

public class GoodsDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_number)
    TextView tv_number;
    @BindView(R.id.iv_add)
    ImageView iv_add;
    @BindView(R.id.iv_cut)
    ImageView iv_cut;

    @Override
    protected int bindLayout() {
        return R.layout.activity_goods_detail;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("商品详情");
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnClick(R.id.iv_add)
    void addCar() {
        if (Integer.parseInt(tv_number.getText().toString()) < 5) {
            tv_number.setText((Integer.parseInt(tv_number.getText().toString().trim()) + 1) + "");
            if (Integer.parseInt(tv_number.getText().toString()) == 5) {
                iv_add.setVisibility(View.INVISIBLE);
            }
        }
        iv_cut.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.iv_cut)
    void cutCar() {
        if (Integer.parseInt(tv_number.getText().toString()) > 0) {
            tv_number.setText((Integer.parseInt(tv_number.getText().toString().trim()) - 1) + "");
            if (Integer.parseInt(tv_number.getText().toString()) == 0) {
                iv_cut.setVisibility(View.INVISIBLE);
            }
        }
        iv_add.setVisibility(View.VISIBLE);
    }
}
