package com.bigzone.zuoyou.Attendance.Activity;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.bigzone.zuoyou.Attendance.Activity.Adapter.OutSideAdapter;
import com.bigzone.zuoyou.Attendance.Activity.bean.OutSideBean;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OutsideActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.iv_top_right)
    ImageView ivTopRight;
    @BindView(R.id.iv_top_left)
    ImageView ivTopLeft;
    @BindView(R.id.tv_top_right)
    TextView tvTopRight;
    @BindView(R.id.tv_top_left)
    TextView tvTopLeft;
    @BindView(R.id.rb_all)
    RadioButton rbAll;
    @BindView(R.id.rb_recent)
    RadioButton rbRcent;
    @BindView(R.id.sm_listview)
    SwipeMenuListView listView;
    private ArrayList<OutSideBean> list = new ArrayList<>();
    OutSideAdapter adapter = new OutSideAdapter(OutsideActivity.this,list);
    private SwipeMenuCreator creator;


    @Override
    protected int bindLayout() {
        return R.layout.activity_outside;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("外勤");
        tvTopRight.setText("新增");
        tvTopRight.setVisibility(View.VISIBLE);
        initData();
        listView.setAdapter(adapter);

        creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(R.color.colorRed);
                // set item width
                openItem.setWidth(200);
                // set item title
                openItem.setTitle("撤销");
                // set item title fontsize
                openItem.setTitleSize(16);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);
            }
        };
        listView.setMenuCreator(creator);
        //侧滑的item点击事件
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                }
                return false;
            }
        });
        //item的点击
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> paret, View view, int position, long id) {
                ToastUtils.showShortMsg("go");
                changeActivity(OutsideDetailsActivity.class);
            }
        });
    }
    private void initData() {
        for (int i = 0; i <20 ; i++) {
            list.add(new OutSideBean("2016.10."+22+i,"事由: 查看商品质量","地址: 上海市xx地点"));
        }

    }


    @OnClick({R.id.iv_back,R.id.tv_top_right})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_top_right:
                changeActivity(ApplyForOutSideActivity.class);
                break;

        }

    }

}
