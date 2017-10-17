package com.bigzone.zuoyou.billing.activity;

import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.billing.adapter.GuiderAdapter;
import com.bigzone.zuoyou.common.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by Seriex.X on 2017/7/20.
 */

public class ShoppingGuideSelectActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.lv_guider)
    ListView lvGuider;
    private ArrayList<String> arrayList = new ArrayList();
    private GuiderAdapter adapter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_shopping_guide_select;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("导购员");
        for (int i = 0; i < 20; i++) {

            arrayList.add("导购员" + (i + 1));
        }
        adapter = new GuiderAdapter(arrayList, this);
        lvGuider.setAdapter(adapter);
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnItemClick(R.id.lv_guider)
    void selectGuider(int position) {
        Intent intent = getIntent();
        intent.putExtra("guider", arrayList.get(position));
        this.setResult(RESULT_OK, intent);
        finish();
    }
}
