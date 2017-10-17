package com.bigzone.zuoyou.billing.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_top_right)
    ImageView ivShoppingCart;
    @BindView(R.id.tv_settle)
    TextView tvSettle;

    @Override
    protected int bindLayout() {

        return R.layout.activity_product_detail;

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        Intent intent =getIntent();
        String tittle = intent.getStringExtra("tittle");
        tv_title.setText(tittle);
        ivShoppingCart.setImageResource(R.drawable.shopping_cart_line);
        ivShoppingCart.setVisibility(View.VISIBLE);
        Intent intent1 =getIntent();
        String qrcode = intent1.getStringExtra("qrcode");
        ToastUtils.showShortMsg(qrcode);
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();

    }
    @OnClick(R.id.tv_settle)
    void tiaozhuan() {
        changeActivity(EditParaActivity.class);
    }

    @OnClick(R.id.iv_top_right)
    void shoppingCart() {
        ToastUtils.showShortMsg("点了购物车");
        changeActivity(ShoppingCartActivity.class);
    }


}
