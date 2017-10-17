package com.bigzone.zuoyou.billing.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.billing.adapter.AdapterStore;
import com.bigzone.zuoyou.common.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectStoresActivity extends BaseActivity implements android.support.v7.widget.SearchView.OnQueryTextListener {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.lv_list)
    ListView lvList;
   /* @BindView(R.id.rl_search)
    RelativeLayout rlSearch;*/


    private ListView lv;
    private ArrayList<String> alist;
    private AdapterStore adapter;
    private android.support.v7.widget.SearchView srv1;

    @Override
    protected int bindLayout() {
        return R.layout.activity_select_stores;
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        tvTitle.setText("选择门店");
        srv1 = (android.support.v7.widget.SearchView) findViewById(R.id.srv1);
        lv = (ListView) findViewById(R.id.lv_list);
        lv.setTextFilterEnabled(true);
        srv1.setOnQueryTextListener(this);
        initData();
        adapter = new AdapterStore(alist,this);
        lv.setAdapter(adapter);

    }

    private void initData() {
        alist = new ArrayList<>();
        alist.add("aa");
        alist.add("ddfa");
        alist.add("qw");
        alist.add("sd");
        alist.add("fd");
        alist.add("cf");
        alist.add("re");
    }

    @OnClick({R.id.iv_back,/*R.id.rl_search*/})
    public void onViewClicked(View v) {
       switch (v.getId()) {
           case R.id.iv_back:
               finish();
               break;
           /*case R.id.rl_search:
               ToastUtils.showShortMsg("点击了");
               changeActivity(SalesSearchNullActivity.class);*/
       }
    }

    // 单击搜索按钮时激发该方法
    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(SelectStoresActivity.this, "textChange--->" + query, Toast.LENGTH_SHORT).show();
        if (TextUtils.isEmpty(query)) {
            // 清除ListView的过滤
            lv.clearTextFilter();

        } else {
            // 使用用户输入的内容对ListView的列表项进行过滤
            lv.setFilterText(query);
            adapter.notifyDataSetChanged();
        }
        return true;
    }


    // 用户输入字符时激发该方法
    @Override
    public boolean onQueryTextChange(String newText) {
        Toast.makeText(this, "您的选择是:" + newText, Toast.LENGTH_SHORT).show();
        return false;
    }
}
