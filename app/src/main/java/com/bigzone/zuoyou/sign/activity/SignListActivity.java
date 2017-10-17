package com.bigzone.zuoyou.sign.activity;

import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.sign.adapter.SignListAdapter;
import com.bigzone.zuoyou.sign.bean.SignEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/26.
 */

public class SignListActivity extends BaseActivity implements SignListAdapter.onBtnClickListener {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.listView)
    ListView listView;
    private List<SignEntity> list = new ArrayList<>();
    private SignListAdapter signListAdapter;


    @Override
    protected int bindLayout() {
        return R.layout.activity_sign_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("订单签收");
        signListAdapter = new SignListAdapter(this, list);
        listView.setAdapter(signListAdapter);
        initData();
        signListAdapter.setOnBtnClickListener(this);
    }

    private void initData() {
        list.clear();
        for (int i = 0; i < 5; i++) {
            list.add(new SignEntity("5NDS342325", "2017-09-30", "上海市闵行区集庆路100号SOHO商务楼1888室", false));
        }
        signListAdapter.notifyDataSetChanged();
    }

    private void initOtherData() {
        list.clear();
        for (int i = 0; i < 5; i++) {
            list.add(new SignEntity("7IDFS31234", "2017-0822", "江苏省南京市秦淮区洪武路洪武大厦2102室", true));
        }
        signListAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.rb_doing)
    void changeLeft() {
        initData();
    }

    @OnClick(R.id.rb_complete)
    void changeRight() {
        initOtherData();
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }


    @Override
    public void takePhoto(int position) {
        changeActivity(SignPhotoActivity.class);
    }

    @Override
    public void takeSign(int position) {
        changeActivity(SignDetailActivity.class);
    }
}
