package com.bigzone.zuoyou.billing.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.billing.adapter.AddressAdapter;
import com.bigzone.zuoyou.billing.bean.AddressEntity;
import com.bigzone.zuoyou.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by haohongwei on 2017/7/19.
 */

public class AddressSelectActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_top_right;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.ll_empty)
    LinearLayout ll_empty;
    private AddressAdapter addressAdapter;
    private List<AddressEntity> list = new ArrayList<>();


    @Override
    protected int bindLayout() {
        return R.layout.activity_selete_address;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
//        MyApp.addActivity(this);
        tv_title.setText("配送地址");
        tv_top_right.setText("添加");
        tv_top_right.setVisibility(View.VISIBLE);
        addressAdapter = new AddressAdapter(this, list);
        listView.setAdapter(addressAdapter);
        listView.setEmptyView(ll_empty);
    }

    private void initData() {
        list.clear();
        for (int i = 0; i < 20; i++) {
            AddressEntity entity = new AddressEntity("李XX", "13838389438", i + "新疆省乌鲁木齐市伊宁区", "集心路168号煤省商务区5号楼301室");
            list.add(entity);
        }
        addressAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnClick(R.id.tv_top_right)
    void addAddress() {
        changeActivity(AddressAddActivity.class);
    }

    @OnClick(R.id.btn_add)
    void emptyAdd() {
        changeActivity(AddressAddActivity.class);
    }

    @OnItemClick(R.id.listView)
    void selectAdd(int position) {
        Intent intent = getIntent();
        intent.putExtra("address", list.get(position).getAddress());
        this.setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onResume() {
        initData();
        super.onResume();
    }
}
