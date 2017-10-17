package com.bigzone.zuoyou.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.bigzone.zuoyou.Attendance.Activity.AttendanceListActivity;
import com.bigzone.zuoyou.BrandSearch.activity.BrandSearcheActivity;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.arrange.activity.ArrangeListActivity;
import com.bigzone.zuoyou.billing.activity.SalesOrderActivity;
import com.bigzone.zuoyou.category.activity.CategorySearchActivity;
import com.bigzone.zuoyou.clock.activity.ClockMainActivity;
import com.bigzone.zuoyou.common.BaseFragment;
import com.bigzone.zuoyou.examine.activity.ExamineListActivity;
import com.bigzone.zuoyou.expense.activity.ExpenseListActivity;
import com.bigzone.zuoyou.goodsearch.activity.GoodsSearchActivity;
import com.bigzone.zuoyou.loan.activity.LoanListActivity;
import com.bigzone.zuoyou.main.adapter.WorkAdapter;
import com.bigzone.zuoyou.main.bean.WorkEntity;
import com.bigzone.zuoyou.potential.activity.PotentialListActivity;
import com.bigzone.zuoyou.programme.activity.ProgrammeListActivity;
import com.bigzone.zuoyou.reception.activity.ReceptionMainActivity;
import com.bigzone.zuoyou.sales.activity.SalesListActivity;
import com.bigzone.zuoyou.sign.activity.SignListActivity;
import com.bigzone.zuoyou.stocktaking.activity.AtocktakingActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by haohongwei on 2017/7/17.
 */

public class WorkPointFragment extends BaseFragment {
    @BindView(R.id.gv_fuction)
    GridView gv_function;
    private WorkAdapter workAdapter;
    private List<WorkEntity> workList;
    private String[] name = {"接待", "潜客管理", "销售开单", "订单管理", "数据报表", "打卡", "考勤", "审批", "报销", "借款", "排车", "捡货", "订单签收", "门店盘点", "方案展示","商品查询","品牌查询","品类查询 "};
    private int[] img = {R.drawable.main_reception, R.drawable.main_latent, R.drawable.main_billing
            , R.drawable.main_order, R.drawable.main_form, R.drawable.main_clock, R.drawable.main_attend
            , R.drawable.main_examine, R.drawable.main_expense, R.drawable.main_loan, R.drawable.main_car
            , R.drawable.main_pick, R.drawable.main_sign, R.drawable.main_store, R.drawable.main_show
            ,R.drawable.main_goods,R.drawable.main_brand,R.drawable.main_category};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workpoint, container, false);
        ButterKnife.bind(this, view);
        workList = new ArrayList<>();
        workAdapter = new WorkAdapter(getActivity(), workList);
        gv_function.setAdapter(workAdapter);
        initData();
        return view;
    }

    @OnItemClick(R.id.gv_fuction)
    void inFunction(int position) {
        switch (position) {
            case 0:
                changeActivity(ReceptionMainActivity.class);
                break;
            case 1:
                changeActivity(PotentialListActivity.class);
                break;
            case 2:
                changeActivity(SalesOrderActivity.class);
                break;
            case 3:
                changeActivity(SalesListActivity.class);
                break;
            case 5:
                changeActivity(ClockMainActivity.class);
                break;
            case 6:
                changeActivity(AttendanceListActivity.class);
                break;
            case 7:
                changeActivity(ExamineListActivity.class);
                break;
            case 8:
                changeActivity(ExpenseListActivity.class);
                break;
            case 9:
                changeActivity(LoanListActivity.class);
                break;
            case 10:
                changeActivity(ArrangeListActivity.class);
                break;
            case 11:
                break;
            case 12:
                changeActivity(SignListActivity.class);
                break;
            case 13:
                changeActivity(AtocktakingActivity.class);
                break;
            case 14:
                changeActivity(ProgrammeListActivity.class);
                break;
            case 15:
                changeActivity(GoodsSearchActivity.class);
                break;
            case 16:
                changeActivity(BrandSearcheActivity.class);
                break;
            case 17:
                changeActivity(CategorySearchActivity.class);
        }
    }

    private void initData() {
        for (int i = 0; i < name.length; i++) {
            workList.add(new WorkEntity(img[i], name[i]));
        }
        workAdapter.notifyDataSetChanged();
    }
}
