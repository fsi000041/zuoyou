package com.bigzone.zuoyou.potential.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by haohongwei on 2017/8/15.
 */

public class MaintainListActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_add;

    @Override
    protected int bindLayout() {
        return R.layout.activity_maintain_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("客户维系结果");
        tv_add.setText("添加");
        tv_add.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.tv_top_right)
    void add() {
        Intent intent = new Intent(this, MaintainDetailActivity.class);
        intent.putExtra("type", 0);
        startActivity(intent);
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnItemClick(R.id.listView)
    void detail(int position) {
        Intent intent = new Intent(this, MaintainDetailActivity.class);
        intent.putExtra("type", 1);
        startActivity(intent);
    }
}
