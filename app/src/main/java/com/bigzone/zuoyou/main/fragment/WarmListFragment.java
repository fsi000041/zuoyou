package com.bigzone.zuoyou.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseFragment;
import com.bigzone.zuoyou.main.activity.LeaveDetailActivity;
import com.bigzone.zuoyou.main.adapter.WarmAdapter;
import com.bigzone.zuoyou.main.bean.WarmEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by haohongwei on 2017/7/17.
 */

public class WarmListFragment extends BaseFragment {
    @BindView(R.id.listView)
    ListView listView;
    private List<WarmEntity> list = new ArrayList<>();
    private WarmAdapter warmAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_warmming, container, false);
        ButterKnife.bind(this, view);
        warmAdapter = new WarmAdapter(getActivity(), list);
        listView.setAdapter(warmAdapter);
        initData();
        return view;
    }

    private void initData() {
        list.clear();
        list.add(new WarmEntity(1, "请假单 cjx -100800231 待您审批", "某某人因为某某事请假 请假时间：2018.08.08 16:00-2018.08.09 18:30", false, "2017.08.08 由系统发错"));
        list.add(new WarmEntity(2, "公告", "公告标题公告标题公告标题公告标题公告标题公告标题公告标题公告标题", false, "2017.08.08 由系统发错"));
        list.add(new WarmEntity(3, "老王的提醒 2017:10:10 --潜客", "去客户家测量时，一定要提前打电话联系一下", true, "2017.08.08 由系统发错"));
        warmAdapter.notifyDataSetChanged();
    }

}
