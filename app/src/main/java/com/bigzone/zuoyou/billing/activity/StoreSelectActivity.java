package com.bigzone.zuoyou.billing.activity;

import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.billing.adapter.AdapterStore;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.common.MyApp;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;


public class StoreSelectActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_store)
    ListView lvStore;
    private AdapterStore adapterStore;
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected int bindLayout() {
        return R.layout.activity_store_select;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        MyApp.addActivity(this);
        tvTitle.setText("销售开单");
        for (int i = 0; i < 10; i++) {
            arrayList.add("dfdfsfsafsfsdf");
        }
        adapterStore = new AdapterStore(arrayList, this);
        lvStore.setAdapter(adapterStore);
    }


    @OnItemClick(R.id.lv_store)
    void selectStore(int position) {
        changeActivity(BillingMainActivity.class);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            MyApp.remove();
        }
        return super.onKeyDown(keyCode, event);
    }
}
