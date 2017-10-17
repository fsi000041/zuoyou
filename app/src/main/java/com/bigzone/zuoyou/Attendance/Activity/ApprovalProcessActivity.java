package com.bigzone.zuoyou.Attendance.Activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.Attendance.Activity.Adapter.ApprovalProcessAdapter;
import com.bigzone.zuoyou.Attendance.Activity.bean.ApprovalProcessBean;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class ApprovalProcessActivity extends BaseActivity {

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
    @BindView(R.id.listView)
    ListView listView;
    ArrayList<ApprovalProcessBean> list = new ArrayList<>();
    ApprovalProcessAdapter adapter = new ApprovalProcessAdapter(ApprovalProcessActivity.this,list);
    @Override
    protected int bindLayout() {
        return R.layout.activity_approval_process;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("审批流程");
        tvTopRight.setText("保存");
        tvTopRight.setVisibility(View.VISIBLE);
       initData();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                changeActivity(ApprovalPickerActivity.class);
            }
        });
    }

    private void initData() {
        for (int i = 0; i <3 ; i++) {
            list.add(new ApprovalProcessBean("老王头","审批人"+i));
        }
    }


    @OnClick({ R.id.iv_back, R.id.iv_top_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_top_right:
                break;
        }
    }
}
