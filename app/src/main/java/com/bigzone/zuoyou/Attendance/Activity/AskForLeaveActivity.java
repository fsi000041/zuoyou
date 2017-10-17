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
import com.bigzone.zuoyou.Attendance.Activity.Adapter.AskForLeaveAdapter;
import com.bigzone.zuoyou.Attendance.Activity.bean.AskForLeaveBean;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AskForLeaveActivity extends BaseActivity implements View.OnClickListener {

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

    @BindView(R.id.lv_ask_for_leave)
    SwipeMenuListView lvAskForLeave;
    @BindView(R.id.rb_need)
    RadioButton rbNeed;
    @BindView(R.id.rb_ok)
    RadioButton rbOk;
    @BindView(R.id.rb_cancel)
    RadioButton rbCancel;

    private List<AskForLeaveBean> list = new ArrayList<>();
    private AskForLeaveAdapter adapter;
    private SwipeMenuCreator creator;
    private SwipeMenuCreator creator1;


    @Override
    protected int bindLayout() {
        return R.layout.activity_ask_for_leave;
    }

    @Override
    protected void onPause() {
        tvTopRight.setText("新增");
        super.onPause();

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("请假");
        tvTopRight.setText("新增");
        tvTopRight.setVisibility(View.VISIBLE);
        tvTopRight.setOnClickListener(this);
        adapter = new AskForLeaveAdapter(this, list);
        lvAskForLeave.setAdapter(adapter);
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
        lvAskForLeave.setMenuCreator(creator);
        lvAskForLeave.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index){
                    //撤销
                    case 0:

                }
                return false;
            }
        });
        initData();
        rbOk.setOnClickListener(this);
        rbNeed.setOnClickListener(this);
        rbCancel.setOnClickListener(this);
        ivBack.setOnClickListener(this  );
        lvAskForLeave.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                changeActivity(LeaveDetalActivity.class);
            }
        });
    }

    private void initData() {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(new AskForLeaveBean("请假" + (i + 1) + "天", "状态: 待审批", "请假单号: 123456"));
        }
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_top_right:
                changeActivity(LeaveRequest.class);
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.rb_ok :
                changeData();
                break;
            case R.id.rb_need:
                initData();
                break;
            case R.id.rb_cancel:
                changeDataTwo();
        }
    }

    private void changeDataTwo() {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(new AskForLeaveBean("请假" + (i + 1) + "天", "状态: 驳回", "请假单号: "+(123456+i)));
        }
        adapter.notifyDataSetChanged();
    }


    private void changeData() {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(new AskForLeaveBean("请假" + (i + 1) + "天", "状态: 已审批", "请假单号: "+(123456+i)));
        }
        adapter.notifyDataSetChanged();
    }


}
