package com.bigzone.zuoyou.billing.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.billing.adapter.ProductListAdapter;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import q.rorbin.badgeview.QBadgeView;

/**
 * Created by Seriex.X on 2017/7/7.
 */

public class ProductListActivity extends BaseActivity implements ProductListAdapter.MyClickListener, View.OnClickListener {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.bt_shop)
    Button bt_shop;
    @BindView(R.id.lv_product)
    ListView lvProduct;
    private ProductListAdapter adapter;
    private ArrayList<String> arrayList = new ArrayList<>();
    private QBadgeView badgeView;
    private int num;

    @Override
    protected int bindLayout() {
        return R.layout.activity_product_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("商品列表");
        for (int i = 0; i < 50; i++) {
            arrayList.add("");
        }
        adapter = new ProductListAdapter(this, arrayList,this);
        lvProduct.setAdapter(adapter);
        initNum();
        bt_shop.setOnClickListener(this);
    }
    //购物车右上角数
    private void initNum() {
        num = 0;
        badgeView = new QBadgeView(this);
        badgeView.bindTarget(bt_shop);


    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @Override
    public void clickListener(View v) {
        ToastUtils.showShortMsg("点击了哦" );
        num++;
        badgeView.setBadgeNumber(num).setBadgeBackgroundColor(Color.RED);
        if (num> 0 ) {
            bt_shop.setBackgroundResource(R.drawable.shoping_red);
        }
    }

    @Override
    public void onClick(View v) {
        changeActivity(ShopCarActivity.class);
    }
}
