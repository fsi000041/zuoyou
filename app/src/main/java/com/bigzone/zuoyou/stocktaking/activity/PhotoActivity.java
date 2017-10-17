package com.bigzone.zuoyou.stocktaking.activity;

import android.view.View;
import android.widget.ExpandableListView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.stocktaking.activity.adapter.GoodsFAdapter;
import com.bigzone.zuoyou.stocktaking.activity.bean.GoodsFatherBean;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;



public class PhotoActivity extends BaseActivity {

    List<GoodsFatherBean> groupList = new ArrayList<>();
    GoodsFAdapter adapter = new GoodsFAdapter(this, groupList);
    @BindView(R.id.elv)
    ExpandableListView elv;


    @Override
    protected int bindLayout() {
        return R.layout.activity_photo;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        setContentView(R.layout.activity_photo);
        initData1();

        elv.setGroupIndicator(null);
        elv.setAdapter(adapter);
        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                ToastUtils.showShortMsg("123123");

                return false;
            }
        });
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ToastUtils.showShortMsg("aaaaaaa");
                return false;
            }
        });
    }


    private void initData1() {
        GoodsFatherBean entity= new GoodsFatherBean();

        GoodsFatherBean.GoodsSonBean goodsSonBean = new GoodsFatherBean.GoodsSonBean();
        goodsSonBean.setName("你大妈");
        goodsSonBean.setBianhao("编号：25437477318637618");
        goodsSonBean.setXinghao("型号：G5000Q");

        GoodsFatherBean.GoodsSonBean goodsSonBean2 = new GoodsFatherBean.GoodsSonBean();
        goodsSonBean.setName("你大爷");
        goodsSonBean.setBianhao("编号：25437477318637618");
        goodsSonBean.setXinghao("型号：G5000Q");

        List<GoodsFatherBean.GoodsSonBean> list = new ArrayList<>();
        list.add(goodsSonBean);
        list.add(goodsSonBean2);

        entity.setName("aoeoeoe");
        entity.setXinghao("gggg21312");
        entity.setBianhao("123213213");
        entity.setGoodsSonList(list);
        groupList.add(entity);

/*
        GoodsFatherBean entity2 = new GoodsFatherBean();

        groupList.add(entity2);*/
       /*Goodz
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
        list.add(entity1);*/
    }
}
