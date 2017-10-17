package com.bigzone.zuoyou.potential.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/9.
 */

public class PotentialDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override
    protected int bindLayout() {
        return R.layout.activity_potent_detail;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("潜客详情");
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnClick(R.id.rl_record)
    void changeRecord() {
        changeActivity(RecordsListActivity.class);
    }

    @OnClick(R.id.rl_wish)
    void changeWish() {
        changeActivity(WishListActivity.class);
    }

    @OnClick(R.id.rl_remind)
    void changeRemind() {
        changeActivity(RemindListActivity.class);
    }

    @OnClick(R.id.rl_house)
    void changeHouse() {
        changeActivity(HouseListActivity.class);
    }

    @OnClick(R.id.rl_maintain)
    void changeMaintain() {
        changeActivity(MaintainListActivity.class);
    }


    @OnClick(R.id.rl_basic)
    void changeBasic() {
        changeActivity(BasicInfoActivity.class);
    }


    @OnClick(R.id.rl_contact)
    void changeContact() {
        changeActivity(ContactInfoActivity.class);
    }

    @OnClick(R.id.rl_schedule)
    void changeSchedule() {
        changeActivity(ScheduleActivity.class);
    }
}
