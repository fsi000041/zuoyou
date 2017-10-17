package com.bigzone.zuoyou.stocktaking.activity;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.stocktaking.activity.adapter.NewStocktakingAdapter;
import com.bigzone.zuoyou.stocktaking.activity.bean.GoodsFatherBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AtocktakingRecordDetailActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.rb_need)
    RadioButton rbNeed;
    @BindView(R.id.rb_ok)
    RadioButton rbOk;
    @BindView(R.id.rb_cancel)
    RadioButton rbCancel;
    @BindView(R.id.elv)
    ExpandableListView elv;
    private List<GoodsFatherBean> groupList;
    @Override
    protected int bindLayout() {
        return R.layout.activity_atocktaking_record_detail;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("2017.10.22");
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
        elv.setAdapter(new NewStocktakingAdapter(this,groupList));
    }


    @OnClick({R.id.iv_back, R.id.rb_need, R.id.rb_ok, R.id.rb_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rb_need:
                break;
            case R.id.rb_ok:
                break;
            case R.id.rb_cancel:
                break;
        }
    }

}
