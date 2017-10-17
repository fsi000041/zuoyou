package com.bigzone.zuoyou.billing.activity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.billing.adapter.ProductListAdapter;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by Seriex.X on 2017/7/6.
 */

public class SearchProductActivity extends BaseActivity implements ProductListAdapter.MyClickListener {
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.lv_product)
    ListView lvProduct;
    @BindView(R.id.ll_empty)
    RelativeLayout llEmpty;
    private ProductListAdapter adapter;
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected int bindLayout() {
        return R.layout.activity_search_product;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                // TODO: 2017/7/6 开启搜索网络请求
                    ToastUtils.showShortMsg("你搜索了" + etSearch.getText().toString());
                return false;
            }
        });

//        for (int i = 0; i < 50; i++) {
//            arrayList.add("");
//        }
        adapter = new ProductListAdapter(this, arrayList,this);
        lvProduct.setAdapter(adapter);
        lvProduct.setEmptyView(llEmpty);
    }

    @OnClick(R.id.tv_cancel)
    void cancel() {
        finish();
    }

    @OnItemClick(R.id.lv_product)
    void selectProduct(int position) {
        changeActivity(ProductDetailActivity.class);

    }

    @Override
    public void clickListener(View v) {

    }
}
