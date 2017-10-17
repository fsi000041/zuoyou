package com.bigzone.zuoyou.loan.activity;

import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.expense.adapter.CostItemAdapter;
import com.bigzone.zuoyou.expense.bean.CostItemEntity;
import com.bigzone.zuoyou.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/6.
 */

public class LoanDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.lv_project)
    ListView lv_project;
    private List<CostItemEntity> costItemEntityList = new ArrayList<>();
    private CostItemAdapter costItemAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_loan_detail;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("借款申请");
        costItemAdapter = new CostItemAdapter(this, costItemEntityList);
        lv_project.setAdapter(costItemAdapter);
        initData();
    }

    private void initData() {
        costItemEntityList.add(new CostItemEntity("电话费", "快点交", "500"));
        costItemEntityList.add(new CostItemEntity("交通费", "火车票", "300"));
        costItemAdapter.notifyDataSetChanged();
        CommonUtil.setHeight(costItemAdapter,lv_project);
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
