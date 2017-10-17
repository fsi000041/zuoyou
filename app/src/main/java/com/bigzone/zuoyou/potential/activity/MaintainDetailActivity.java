package com.bigzone.zuoyou.potential.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/15.
 */

public class MaintainDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_add;
    private int type;
    @BindView(R.id.rl_memo)
    RelativeLayout rl_memo;
    @BindView(R.id.rl_reason)
    RelativeLayout rl_reason;
    @BindView(R.id.rl_num)
    RelativeLayout rl_num;
    @BindView(R.id.cb_result)
    CheckBox cb_result;

    @Override
    protected int bindLayout() {
        return R.layout.activity_maintain_detail;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        type = getIntent().getIntExtra("type", 0);
        if (type == 0) {
            tv_title.setText("添加维系结果");
            tv_add.setText("保存");
            tv_add.setVisibility(View.VISIBLE);
        } else {
            tv_title.setText("维系结果详情");
        }
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnCheckedChanged(R.id.cb_result)
    void result(boolean isSuccess) {
        if(isSuccess){
            rl_num.setVisibility(View.VISIBLE);
            rl_memo.setVisibility(View.GONE);
            rl_reason.setVisibility(View.GONE);
            cb_result.setText("成功");
        }else {
            rl_num.setVisibility(View.GONE);
            rl_memo.setVisibility(View.VISIBLE);
            rl_reason.setVisibility(View.VISIBLE);
            cb_result.setText("失败");
        }
    }

}
