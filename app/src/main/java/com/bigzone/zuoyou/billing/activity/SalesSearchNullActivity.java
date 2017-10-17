package com.bigzone.zuoyou.billing.activity;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.ButterKnife;

public class SalesSearchNullActivity extends BaseActivity {

 /*   @BindView(R.id.searchView)
    SearchView searchView;*/

    @Override
    protected int bindLayout() {
        return R.layout.activity_sales_search_null;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

    }


}
