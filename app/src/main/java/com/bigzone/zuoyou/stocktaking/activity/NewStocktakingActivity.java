package com.bigzone.zuoyou.stocktaking.activity;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.stocktaking.activity.adapter.NewStocktakingAdapter;
import com.bigzone.zuoyou.stocktaking.activity.bean.GoodsFatherBean;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewStocktakingActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.elv_listView)
    ExpandableListView elvListView;
    private List<GoodsFatherBean> groupList;

    @Override
    protected int bindLayout() {
        return R.layout.activity_new_stocktaking;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        groupList = new ArrayList<>();
        GoodsFatherBean entity= new GoodsFatherBean();
        GoodsFatherBean entity1 = new GoodsFatherBean();
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

        entity1.setBianhao("编号：25437477318637618");
        entity1.setXinghao("型号： G123f");
        entity1.setName("大力丸");
        entity1.setGoodsSonList(list);
        groupList.add(entity);
        groupList.add(entity1);
        elvListView.setAdapter(new NewStocktakingAdapter(this,groupList));
        elvListView.expandGroup(0);
        elvListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                ToastUtils.showShortMsg("我展开了啊 快躲开");
                return false;
            }
        });

        elvListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ToastUtils.showShortMsg("我展开了啊 快躲开");
                return true;
            }
        });
    }



    @OnClick(R.id.iv_back)
    public void onViewClicked() {
    }
}
