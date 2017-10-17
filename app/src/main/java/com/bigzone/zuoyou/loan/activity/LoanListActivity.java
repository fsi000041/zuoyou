package com.bigzone.zuoyou.loan.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.expense.activity.ExpenseAddActivity;
import com.bigzone.zuoyou.expense.activity.ExpenseDetailActivity;
import com.bigzone.zuoyou.expense.adapter.ExpenseListAdapter;
import com.bigzone.zuoyou.expense.bean.ExpenseEntity;
import com.bigzone.zuoyou.loan.adapter.LoanListAdapter;
import com.bigzone.zuoyou.loan.bean.LoanEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/6.
 */

public class LoanListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_add;
    @BindView(R.id.lv_expense)
    ListView lv_expense;
    private List<LoanEntity> list = new ArrayList<>();
    private LoanListAdapter adapter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_loan_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("借款");
        tv_add.setText("新增");
        tv_add.setVisibility(View.VISIBLE);
        adapter = new LoanListAdapter(this, list);
        lv_expense.setAdapter(adapter);
        lv_expense.setOnItemClickListener(this);
        initData();
    }

    private void initData() {
        list.clear();
        for (int i = 0; i < 5; i++) {
            list.add(new LoanEntity("2017.08.04", "宽带费", "1234567890", "500"));
        }
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnClick(R.id.rb_complete)
    void turnComplete() {
        list.clear();
        for (int i = 0; i < 5; i++) {
            list.add(new LoanEntity("2017.09.22", "电话费", "0987654321", "233"));
        }
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.rb_doing)
    void turnDoing() {
        initData();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        changeActivity(ExpenseDetailActivity.class);
    }

    @OnClick(R.id.tv_top_right)
    void changeAdd() {
        changeActivity(ExpenseAddActivity.class);
    }

}
