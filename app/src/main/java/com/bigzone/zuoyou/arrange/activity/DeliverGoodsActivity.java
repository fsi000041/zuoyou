package com.bigzone.zuoyou.arrange.activity;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.arrange.adapter.DeliverGoodsAdapter;
import com.bigzone.zuoyou.arrange.bean.DeliverGoodsEntity;
import com.bigzone.zuoyou.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/13.
 */

public class DeliverGoodsActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.listView)
    ExpandableListView listView;
    private List<DeliverGoodsEntity> list = new ArrayList<>();
    private DeliverGoodsAdapter adapter;

    @Override
    protected int bindLayout() {
        return R.layout.acitivity_deliver_goods;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("排车开单");
        adapter = new DeliverGoodsAdapter(this, list);
        listView.setAdapter(adapter);
        initData();
        int groupCount = listView.getCount();
        for (int i = 0; i < groupCount; i++) {
            listView.expandGroup(i);
        }
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //不可折叠
                return true;
            }
        });
    }

    private void initData() {
        DeliverGoodsEntity entity1 = new DeliverGoodsEntity();
        DeliverGoodsEntity.GoodsBean goodsBean1 = new DeliverGoodsEntity.GoodsBean();
        goodsBean1.setCar("2");
        goodsBean1.setContent("印花布料，真皮沙发，铁头哇，愣头青等四件商品");
        goodsBean1.setCount("4");
        DeliverGoodsEntity.GoodsBean goodsBean2 = new DeliverGoodsEntity.GoodsBean();
        goodsBean2.setCar("1");
        goodsBean2.setContent("你皮任你皮，把你当瓜皮……等2件商品");
        goodsBean2.setCount("2");
        entity1.setAddress("上海闵行区");
        entity1.setName("张天宇");
        entity1.setTime("2017-09-15");
        List<DeliverGoodsEntity.GoodsBean> goodsList1 = new ArrayList<>();
        goodsList1.add(goodsBean1);
        goodsList1.add(goodsBean2);
        entity1.setGoods(goodsList1);
        list.add(entity1);

        DeliverGoodsEntity entity2 = new DeliverGoodsEntity();
        DeliverGoodsEntity.GoodsBean goodsBean3 = new DeliverGoodsEntity.GoodsBean();
        goodsBean3.setCar("5");
        goodsBean3.setContent("世界顶级材质，纯牛皮的沙发……等两件商品");
        goodsBean3.setCount("2");
        entity2.setAddress("上海闵行区");
        entity2.setName("张天宇");
        entity2.setTime("2017-09-15");
        List<DeliverGoodsEntity.GoodsBean> goodsList2 = new ArrayList<>();
        goodsList2.add(goodsBean3);
        entity2.setGoods(goodsList2);
        list.add(entity2);

        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
