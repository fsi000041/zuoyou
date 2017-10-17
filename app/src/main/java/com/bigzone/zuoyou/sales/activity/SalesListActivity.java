package com.bigzone.zuoyou.sales.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.common.Constants;
import com.bigzone.zuoyou.main.activity.MainActvity;
import com.bigzone.zuoyou.sales.adapter.SalesListAdapter;
import com.bigzone.zuoyou.sales.bean.SalesEntity;
import com.bigzone.zuoyou.utils.GsonUtils;
import com.bigzone.zuoyou.utils.Logger;
import com.bigzone.zuoyou.utils.ToastUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;

import static com.bigzone.zuoyou.common.Constants.CALL_PERMISSION;

/**
 * Created by haohongwei on 2017/7/20.
 */

public class SalesListActivity extends BaseActivity implements AdapterView.OnItemClickListener, SalesListAdapter.OnTelListenet {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.sale_listview)
    ListView sale_listview;
    @BindView(R.id.iv_top_right)
    ImageView iv_search;
    @BindView(R.id.ll_empty)
    LinearLayout ll_empty;
    //0 待审核，1 待付款，2 已收款，3 已结案
    private String type = "0";

    private SalesListAdapter salesAdapter;
    private List<SalesEntity.RpdataBean.ListBean> listToDivide = new ArrayList<>();
    private List<SalesEntity.RpdataBean.ListBean> listFromNet = new ArrayList<>();

    @Override
    protected int bindLayout() {
        return R.layout.activity_sales_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("订单");
        iv_search.setImageResource(R.drawable.search_gray);
        iv_search.setVisibility(View.VISIBLE);
        salesAdapter = new SalesListAdapter(this, listToDivide);
        sale_listview.setAdapter(salesAdapter);
        sale_listview.setEmptyView(ll_empty);
        sale_listview.setOnItemClickListener(this);
        initData();
        salesAdapter.setOnTelListener(this);
    }

    private void initData() {
//        MyRetrofit.getInstance().getSalesList(new Observer<String>() {
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
//                Logger.d("SalesListActivity", s);
//                listFromNet.clear();
//                try {
//                    JSONObject jsonObject = new JSONObject(s);
//                    JSONObject jsonElements = jsonObject.getJSONObject("rpdata");
//                    JSONArray jsonArray = jsonElements.getJSONArray("list");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        SalesEntity.RpdataBean.ListBean entity = GsonUtils.parseJsonWithGson(jsonArray.get(i).toString(), SalesEntity.RpdataBean.ListBean.class);
//                        listFromNet.add(entity);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                initDataFromDivide("0");
//            }
//        });

    }

    private void initDataFromDivide(String type) {
        listToDivide.clear();
        for (SalesEntity.RpdataBean.ListBean entity : listFromNet) {
            if (entity.getStatus().equals(type)) {
                listToDivide.add(entity);
            }
        }
        salesAdapter.notifyDataSetChanged();
    }

    private void initDataFromNet() {
//        listFromNet.clear();
    }

    @OnClick(R.id.rb_examine)
    void changeExamine() {
        type = "0";
        initDataFromDivide(type);
    }

    @OnClick(R.id.rb_paying)
    void changePaying() {
        type = "1";
        initDataFromDivide(type);
    }

    @OnClick(R.id.rb_paid)
    void changePaid() {
        type = "2";
        initDataFromDivide(type);
    }

    @OnClick(R.id.rb_over)
    void changeOver() {
        type = "3";
        initDataFromDivide(type);
    }

    @OnClick(R.id.iv_back)
    void back() {
        Intent intent = new Intent(this, MainActvity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.iv_top_right)
    void search() {
        changeActivity(SalesSearchListActivity.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, SalesDetailActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("billno", listToDivide.get(position).getBillno());
        startActivity(intent);
    }

    @Override
    public void whitchPhone(int position) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + listToDivide.get(position).getTelephone()));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(
                        new String[]{Manifest.permission.CALL_PHONE},
                        CALL_PERMISSION);
            }
            return;
        }
        startActivity(intent);
    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == Constants.CALL_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                ToastUtils.showShortMsg("权限获取成功");
            } else {
                ToastUtils.showShortMsg("请在设置里面给予权限");
            }
        }

    }
}
