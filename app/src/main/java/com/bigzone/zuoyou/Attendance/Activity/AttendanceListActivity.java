package com.bigzone.zuoyou.Attendance.Activity;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.Attendance.Activity.Adapter.BVAdapter;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.tandong.bottomview.view.BottomView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by liangxu on 2017/9/8.
 */

public class AttendanceListActivity extends BaseActivity {


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
    @BindView(R.id.tv_kaoqing)
    TextView tvKaoqing;
    @BindView(R.id.tv_qingjia)
    TextView tvQingjia;
    @BindView(R.id.tv_waichu)
    TextView tvWaichu;
    @BindView(R.id.tv_jiaban)
    TextView tvJiaban;
    @BindView(R.id.kaoqing)
    RelativeLayout kaoqing;
    @BindView(R.id.rl_qingjia)
    RelativeLayout rlQingjia;
    @BindView(R.id.rl_waichu)
    RelativeLayout rlWaichu;
    @BindView(R.id.rl_jiaban)
    RelativeLayout rlJiaban;
    ArrayList<String> list;
    private BottomView bottomView;
    private ListView listView;
    private BVAdapter bvAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_attendance_list;

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("考勤");
        tvTopRight.setText("新增");
        tvTopRight.setVisibility(View.VISIBLE);
        tvJiaban.setText("11");
        initData();

    }

    private void initData() {
         list = new ArrayList<>();
        list.add("请假外出");
        list.add("外勤申请");
        list.add("加班申请");
        list.add("取消");
    }


    @OnClick({R.id.kaoqing, R.id.rl_qingjia, R.id.rl_waichu, R.id.rl_jiaban, R.id.iv_back, R.id.tv_top_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;

            case R.id.tv_top_right:
                tvTopRight.setText("添加");
                //底部弹出
                bottomView = new BottomView(AttendanceListActivity.this,
                        R.style.BottomViewTheme_Defalut, R.layout.bottom_view);

                bottomView.setAnimation(R.style.BottomToTopAnim);

                bottomView.showBottomView(false);

                listView = (ListView) bottomView.getView().findViewById(R.id.lv_list);
                bvAdapter = new BVAdapter(AttendanceListActivity.this,list);
                listView.setAdapter(bvAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       if (list.get(position).equals("请假外出") ) {

                          changeActivity(LeaveRequest.class);
                           tvTopRight.setText("新增");
                          bottomView.dismissBottomView();
                       }if (list.get(position) .equals("外勤申请")) {
                            tvTopRight.setText("新增");
                            changeActivity(ApplyForOutSideActivity.class);
                            bottomView.dismissBottomView();
                        }if (list.get(position).equals("加班申请")) {
                            tvTopRight.setText("新增");
                            bottomView.dismissBottomView();
                            changeActivity(WorkOverTimeAddActivity.class);
                        }if (list.get(position).equals("取消")) {
                            bottomView.dismissBottomView();
                            tvTopRight.setText("新增");
                        }
                    }
                });
                break;
            case R.id.kaoqing:


                break;
            case R.id.rl_qingjia:
                changeActivity(AskForLeaveActivity.class);
                break;
            case R.id.rl_waichu:
                changeActivity(OutsideActivity.class);
                break;
            case R.id.rl_jiaban:
                changeActivity(WorkOverTimeActivity.class);
                break;

        }
    }
}
