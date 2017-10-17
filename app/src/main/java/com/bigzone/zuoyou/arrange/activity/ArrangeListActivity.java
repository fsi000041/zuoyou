package com.bigzone.zuoyou.arrange.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.arrange.adapter.ArrangeListAdapter;
import com.bigzone.zuoyou.arrange.bean.ArrangeEntity;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by haohongwei on 2017/9/12.
 */

public class ArrangeListActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_add;
    @BindView(R.id.listView)
    SwipeMenuListView listView;
    private SwipeMenuCreator creator;
    private ArrangeListAdapter adapter;
    private List<ArrangeEntity> list = new ArrayList<>();

    @Override
    protected int bindLayout() {
        return R.layout.activity_arrange_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("排车");
        tv_add.setText("新增");
        tv_add.setVisibility(View.VISIBLE);
        adapter = new ArrangeListAdapter(this, list);
        listView.setAdapter(adapter);
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
                openItem.setTitle("删除");

                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);
            }
        };
        listView.setMenuCreator(creator);
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    //撤销
                    case 0:
                        ToastUtils.showShortMsg("删除");
                        break;
                }
                return false;
            }
        });
        initData();
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            list.add(new ArrangeEntity(1, "1231543534523984932", "2017-09-09", "张XX"));
        }
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnItemClick(R.id.listView)
    void ClickItem(int position) {
        changeActivity(ArrangeDetailActivity.class);
    }


    @OnClick(R.id.tv_top_right)
    void addArrange() {
        changeActivity(PlatoonOrderActivity.class);
    }
}
