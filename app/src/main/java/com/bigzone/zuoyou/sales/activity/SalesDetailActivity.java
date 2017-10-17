package com.bigzone.zuoyou.sales.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.sales.adapter.SalesDetailAdapter;
import com.bigzone.zuoyou.sales.bean.SalesDetailEntity;
import com.bigzone.zuoyou.utils.CommonUtil;
import com.bigzone.zuoyou.utils.GsonUtils;
import com.bigzone.zuoyou.utils.Logger;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;

/**
 * Created by haohongwei on 2017/7/21.
 */

public class SalesDetailActivity extends BaseActivity {
    private static String TAG = "SalesDetailActivity";
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.listView)
    ListView listView;
    List<SalesDetailEntity.OrderBean.ProductBean> list;
    private SalesDetailAdapter salesDetailAdapter;
    private String type;
    private String billno;
    @BindView(R.id.tv_billno)
    TextView tv_billno;
    @BindView(R.id.tv_billdate)
    TextView tv_billdate;
    @BindView(R.id.tv_storename)
    TextView tv_storename;


    @Override
    protected int bindLayout() {
        return R.layout.activity_sales_detail;
    }

    @BindView(R.id.btn_left)
    Button btn_left;
    @BindView(R.id.btn_mid)
    Button btn_mid;
    @BindView(R.id.btn_right)
    Button btn_right;
    @BindView(R.id.rl_btn)
    RelativeLayout rl_btn;


    @Override
    protected void initView() {
        ButterKnife.bind(this);
        type = getIntent().getStringExtra("type");
        billno = getIntent().getStringExtra("billno");
        initButtonView(type);
        tv_title.setText("订单详情");
        list = new ArrayList<>();
        salesDetailAdapter = new SalesDetailAdapter(this, list);
        listView.setAdapter(salesDetailAdapter);
        initData();
    }

    private void initButtonView(String type) {
        if (type.equals("0")) {
            btn_mid.setText("审核");
            btn_right.setText("修改");
            btn_left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortMsg("删除");
                }
            });
            btn_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortMsg("修改");
                    changeActivity(ChangeDetailActivity.class);
                }
            });
            btn_mid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortMsg("审核");
                }
            });
        } else if (type.equals("1")) {
            btn_left.setVisibility(View.GONE);
            btn_mid.setText("交款");
            btn_right.setText("变更");
            btn_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortMsg("变更");
                    changeActivity(ChangeAddressActivity.class);
                }
            });
            btn_mid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortMsg("交款");
                    changeActivity(PayMoneyActivity.class);
                }
            });
        } else if (type.equals("2")) {
            btn_left.setVisibility(View.GONE);
            btn_mid.setVisibility(View.GONE);
            btn_right.setText("变更");
            btn_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortMsg("变更");
                    changeActivity(ChangeAddressActivity.class);
                }
            });
        } else if (type.equals("3")) {
            rl_btn.setVisibility(View.GONE);
        }
    }

    private void initData() {
//        MyRetrofit.getInstance().getSalesDetail(new Observer<String>() {
//
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Logger.d(TAG, "------------- " + s);
//                SalesDetailEntity entity = GsonUtils.parseJsonWithGson(s, SalesDetailEntity.class);
//                list.clear();
//                for (int i = 0; i < entity.getOrder().getProduct().size(); i++) {
//                    list.add(entity.getOrder().getProduct().get(i));
//                }
//                salesDetailAdapter.notifyDataSetChanged();
//                CommonUtil.setHeight(salesDetailAdapter, listView);
//                tv_billno.setText("订单号："+entity.getOrder().getBillno());
//                tv_billdate.setText("日期："+entity.getOrder().getBilldate());
//                tv_storename.setText("门店："+entity.getOrder().getStorename());
//            }
//        });
    }


    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
