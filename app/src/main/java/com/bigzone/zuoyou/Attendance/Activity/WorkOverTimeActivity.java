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
import com.bigzone.zuoyou.Attendance.Activity.Adapter.WorkOverTimeAdapter;
import com.bigzone.zuoyou.Attendance.Activity.bean.WorkOverTimeBean;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WorkOverTimeActivity extends BaseActivity implements View.OnClickListener {


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
    RadioButton rbRecent;
    @BindView(R.id.rb_warm)
    RadioButton rbWarm;
    @BindView(R.id.listView)
    SwipeMenuListView listView;
    ArrayList<WorkOverTimeBean> list = new ArrayList<>();
    WorkOverTimeAdapter adapter = new WorkOverTimeAdapter(WorkOverTimeActivity.this,list);
    private SwipeMenuCreator creator;

    @Override
    protected int bindLayout() {
        return R.layout.activity_work_over_time;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("加班");
        tvTopRight.setText("新增");
        tvTopRight.setVisibility(View.VISIBLE);
        initDate();
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
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index){
                    //撤销
                    case 0:
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                        break;
                    case 1:
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                changeActivity(WorkOverTimeDetilActivity.class);
            }
        });

    }

    private void initDate() {
        list.clear();
        for (int i = 0; i < 5 ; i++) {
            list.add(new WorkOverTimeBean("123"+i,"待审批","2017.5.6"+"" +"加班"+(i+1)+"小时"));
        }
        adapter.notifyDataSetChanged();
    }


    @OnClick({R.id.iv_back, R.id.iv_top_right,R.id.rb_warm,R.id.rb_recent,R.id.rb_all,R.id.tv_top_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_top_right:
                break;
            case R.id.rb_all:
                initDate();
                break;
            case R.id.rb_warm:
                changeData();
                break;
            case R.id.rb_recent:
                changeData1();
                break;
            case R.id.tv_top_right:
                changeActivity(WorkOverTimeAddActivity.class);

        }
    }

    private void changeData1() {
        list.clear();
        for (int i = 0; i < 5 ; i++) {
            list.add(new WorkOverTimeBean("12123"+i,"已审批","2017.5.6"+"" +"加班"+(i+1)+"小时"));
        }
        adapter.notifyDataSetChanged();
    }

    private void changeData() {
        list.clear();
        for (int i = 0; i < 5 ; i++) {
            list.add(new WorkOverTimeBean("1233333"+i,"被驳回","2017.5.6"+"" +"加班"+(i+1)+"小时"));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        changeActivity(WorkOverTimeAddActivity.class);
    }
}
