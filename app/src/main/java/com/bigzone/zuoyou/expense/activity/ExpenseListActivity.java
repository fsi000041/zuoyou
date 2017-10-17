package com.bigzone.zuoyou.expense.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.expense.adapter.ExpenseListAdapter;
import com.bigzone.zuoyou.expense.bean.ExpenseEntity;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/6.
 */

public class ExpenseListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_add;
    @BindView(R.id.lv_expense)
    SwipeMenuListView lv_expense;
    private List<ExpenseEntity> list = new ArrayList<>();
    private ExpenseListAdapter adapter;
    private SwipeMenuCreator creator;

    @Override
    protected int bindLayout() {
        return R.layout.activity_expense_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("报销");
        tv_add.setText("新增");
        tv_add.setVisibility(View.VISIBLE);
        adapter = new ExpenseListAdapter(this, list);
        lv_expense.setAdapter(adapter);
        lv_expense.setOnItemClickListener(this);
        creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(R.color.colorRed);
                // set item width
                openItem.setWidth(200);
                // set item title
                openItem.setTitle("撤销");

                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);
            }
        };
        lv_expense.setMenuCreator(creator);
        lv_expense.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    //撤销
                    case 0:
                        ToastUtils.showShortMsg("撤销");
                        break;
                }
                return false;
            }
        });
        initData();

    }

    private void initData() {
        list.clear();
        for (int i = 0; i < 5; i++) {
            list.add(new ExpenseEntity("2017.08.04", "宽带费", "1234567890", "500"));
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
            list.add(new ExpenseEntity("2017.09.22", "电话费", "0987654321", "233"));
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
