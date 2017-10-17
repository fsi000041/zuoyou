package com.bigzone.zuoyou.sales.activity;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.sales.adapter.SalesListAdapter;
import com.bigzone.zuoyou.sales.bean.SalesEntity;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/7/24.
 */

public class SalesSearchListActivity extends BaseActivity {
    @BindView(R.id.ll_empty)
    RelativeLayout ll_empty;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.et_search)
    EditText etSearch;
    private List<SalesEntity> listFromNet;
    private SalesListAdapter salesAdapter;


    @Override
    protected int bindLayout() {
        return R.layout.activity_sales_search;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        listView.setEmptyView(ll_empty);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                // TODO: 2017/7/6 开启搜索网络请求
                ToastUtils.showShortMsg("你搜索了" + etSearch.getText().toString());
                return false;
            }
        });
        listFromNet = new ArrayList<>();
//        salesAdapter = new SalesListAdapter(this, listFromNet);
        listView.setAdapter(salesAdapter);
        initDataFromNet();
    }


    private void initDataFromNet() {
        listFromNet.clear();
//        listFromNet.add(new SalesEntity("XMDT3469XXXXX943DT", "2017-03-14",
//                "AP-555 (1+1+3) 布套沙发 卡其色亚麻色粉红色翡翠色布套", "共X件商品",
//                "应收: ¥590.00", "已收: ¥590.00",
//                "某某，上海市闵行区集心路168号煤省商务区5号楼301室，13737375849，☏", "", 0));
//        listFromNet.add(new SalesEntity("XMDT3469XXXXX943DT", "2017-03-14",
//                "AP-555 (1+1+3) 布套沙发 卡其色亚麻色粉红色翡翠色布套", "共X件商品",
//                "应收: ¥590.00", "已收: ¥590.00",
//                "某某，上海市闵行区集心路168号煤省商务区5号楼301室，13737375849，☏", "", 1));
//        listFromNet.add(new SalesEntity("XMDT3469XXXXX943DT", "2017-03-14",
//                "AP-555 (1+1+3) 布套沙发 卡其色亚麻色粉红色翡翠色布套", "共X件商品",
//                "应收: ¥590.00", "全款已付",
//                "某某，上海市闵行区集心路168号煤省商务区5号楼301室，13737375849，☏", "", 2));
//        listFromNet.add(new SalesEntity("XMDT3469XXXXX943DT", "2017-03-14",
//                "AP-555 (1+1+3) 布套沙发 卡其色亚麻色粉红色翡翠色布套", "共X件商品",
//                "应收: ¥590.00", "已收: ¥590.00",
//                "某某，上海市闵行区集心路168号煤省商务区5号楼301室，13737375849，☏", "", 0));
//        listFromNet.add(new SalesEntity("XMDT3469XXXXX943DT", "2017-03-14",
//                "AP-555 (1+1+3) 布套沙发 卡其色亚麻色粉红色翡翠色布套", "共X件商品",
//                "应收: ¥590.00", "全款已付",
//                "某某，上海市闵行区集心路168号煤省商务区5号楼301室，13737375849，☏", "", 3));
//        listFromNet.add(new SalesEntity("XMDT3469XXXXX943DT", "2017-03-14",
//                "AP-555 (1+1+3) 布套沙发 卡其色亚麻色粉红色翡翠色布套", "共X件商品",
//                "应收: ¥590.00", "全款已付",
//                "某某，上海市闵行区集心路168号煤省商务区5号楼301室，13737375849，☏", "", 2));
//        listFromNet.add(new SalesEntity("XMDT3469XXXXX943DT", "2017-03-14",
//                "AP-555 (1+1+3) 布套沙发 卡其色亚麻色粉红色翡翠色布套", "共X件商品",
//                "应收: ¥590.00", "已收: ¥590.00",
//                "某某，上海市闵行区集心路168号煤省商务区5号楼301室，13737375849，☏", "", 1));
//        listFromNet.add(new SalesEntity("XMDT3469XXXXX943DT", "2017-03-14",
//                "AP-555 (1+1+3) 布套沙发 卡其色亚麻色粉红色翡翠色布套", "共X件商品",
//                "应收: ¥590.00", "全款已付",
//                "某某，上海市闵行区集心路168号煤省商务区5号楼301室，13737375849，☏", "", 3));
    }

    @OnClick(R.id.tv_cancel)
    void cancel() {
        finish();
    }
}
