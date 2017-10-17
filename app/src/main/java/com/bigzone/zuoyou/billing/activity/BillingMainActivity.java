package com.bigzone.zuoyou.billing.activity;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.billing.adapter.DrawableFilterAdapter;
import com.bigzone.zuoyou.billing.adapter.PoductClassAdapter;
import com.bigzone.zuoyou.billing.adapter.ProductListAdapter;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.common.MyApp;
import com.bigzone.zuoyou.utils.CommonUtil;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class BillingMainActivity extends BaseActivity implements ProductListAdapter.MyClickListener{
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_top_right)
    ImageView ivSearch;
    @BindView(R.id.ck_sales)
    CheckBox ckSales;
    @BindView(R.id.ck_price)
    CheckBox ckPrice;
    @BindView(R.id.tv_filter)
    TextView tvFilter;
    @BindView(R.id.tv_number_cart)
    TextView tvNumCart;
    @BindView(R.id.lv_class)
    ListView lvClass;
    @BindView(R.id.lv_product)
    ListView lvProduct;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.drawer)
    RelativeLayout drawer;

    @BindView(R.id.gv_style)
    GridView gvStyle;
    @BindView(R.id.gv_brand)
    GridView gvBrand;
    @BindView(R.id.gv_material)
    GridView gvMaterial;
    @BindView(R.id.gv_room)
    GridView gvRoom;
    @BindView(R.id.gv_series)
    GridView gvSeries;
    private ArrayList<String> arrayListClass = new ArrayList<>();
    private ArrayList<String> arrayListProduct = new ArrayList<>();
    private ArrayList<Map<String, String>> arrayListFilter = new ArrayList<>();
    private PoductClassAdapter classAdapter;//商品品类
    private ProductListAdapter productAdapter;//商品列表
    private DrawableFilterAdapter filterAdapter;//筛选抽屉

    @Override
    protected int bindLayout() {
        return R.layout.activity_billing_main;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        MyApp.addActivity(this);
        tv_title.setText("销售开单");
        tvNumCart.setText("99");
        ivSearch.setImageResource(R.drawable.search_gray);
        ivSearch.setVisibility(View.VISIBLE);
        for (int i = 0; i < 100; i++) {
            arrayListClass.add("dsdsdsdd");
            arrayListProduct.add("");
        }
        for (int i = 0; i < 10; i++) {
            arrayListFilter.add(new HashMap<String, String>());
        }
        classAdapter = new PoductClassAdapter(this, arrayListClass);
        productAdapter = new ProductListAdapter(this, arrayListProduct,this);
        filterAdapter = new DrawableFilterAdapter(this, arrayListFilter);
        lvClass.setAdapter(classAdapter);
        lvProduct.setAdapter(productAdapter);

        gvStyle.setAdapter(filterAdapter);
        gvBrand.setAdapter(filterAdapter);
        gvRoom.setAdapter(filterAdapter);
        gvMaterial.setAdapter(filterAdapter);
        gvSeries.setAdapter(filterAdapter);
        CommonUtil.setHeight(filterAdapter, gvStyle);
        CommonUtil.setHeight(filterAdapter, gvBrand);
        CommonUtil.setHeight(filterAdapter, gvRoom);
        CommonUtil.setHeight(filterAdapter, gvMaterial);
        CommonUtil.setHeight(filterAdapter, gvSeries);
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();

    }

    @OnClick(R.id.tv_filter)
    void select() {
        drawerLayout.openDrawer(GravityCompat.END);
    }


    //搜索
    @OnClick(R.id.iv_top_right)
    void search() {
        changeActivity(SearchProductActivity.class);
    }

    @OnClick(R.id.iv_shopping_cart)
    void shoppingCart() {
        ToastUtils.testMsg("点了购物车");
        changeActivity(ShoppingCartActivity.class);
    }

    //选择商品品类
    @OnItemClick(R.id.lv_class)
    void selectClass(int position) {
        ToastUtils.testMsg("选择了第" + (position + 1) + "个品类");
    }

    @OnItemClick(R.id.lv_product)
    void selectProduct(int position) {
        changeActivity(ProductDetailActivity.class);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //如果抽屉是开的先关一哈
        if (drawerLayout.isDrawerOpen(drawer)) {
            drawerLayout.closeDrawers();
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            MyApp.remove();
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void clickListener(View v) {

    }
}
