package com.bigzone.zuoyou.sign.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.sign.adapter.SignDetailAdapter;
import com.bigzone.zuoyou.sign.bean.GoodsEntity;
import com.bigzone.zuoyou.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/27.
 */

public class SignDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_complete;
    @BindView(R.id.listView)
    ListView listView;
    List<GoodsEntity> list;
    private SignDetailAdapter signDetailAdapter;
    @BindView(R.id.iv_sign)
    ImageView iv_sign;


    @Override
    protected int bindLayout() {
        return R.layout.activity_sign_detail;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("签收");
        tv_complete.setText("完成");
        tv_complete.setVisibility(View.VISIBLE);

        list = new ArrayList<>();
        signDetailAdapter = new SignDetailAdapter(this, list);
        listView.setAdapter(signDetailAdapter);
        initData();
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            list.add(new GoodsEntity("AP-666 (1+1+3) 布套沙发 卡其色亚麻布套", "1", ""));
        }
        signDetailAdapter.notifyDataSetChanged();
        CommonUtil.setHeight(signDetailAdapter, listView);
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }


    @OnClick(R.id.rl_sign)
    void getSign() {
        changeActivity(DrawNameActivity.class);
    }
}
