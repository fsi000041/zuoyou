package com.bigzone.zuoyou.clock.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.clock.bean.ClockRecordEntity;

import java.util.List;

/**
 * Created by haohongwei on 2017/8/2.
 */

public class ClockRecordAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<ClockRecordEntity> dataset;

    public ClockRecordAdapter(Context context, List<ClockRecordEntity> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    //  获得某个父项的某个子项
    @Override
    public Object getChild(int parentPos, int childPos) {
        return dataset.get(parentPos).getTimeEntityList().get(childPos);
    }

    //  获得父项的数量
    @Override
    public int getGroupCount() {
        return dataset.size();
    }

    //  获得某个父项的子项数目
    @Override
    public int getChildrenCount(int parentPos) {
        return dataset.get(parentPos).getTimeEntityList().size();
    }

    //  获得某个父项
    @Override
    public Object getGroup(int parentPos) {
        return dataset.get(parentPos);
    }

    //  获得某个父项的id
    @Override
    public long getGroupId(int parentPos) {
        return parentPos;
    }

    //  获得某个父项的某个子项的id
    @Override
    public long getChildId(int parentPos, int childPos) {
        return childPos;
    }

    //  按函数的名字来理解应该是是否具有稳定的id，这个方法目前一直都是返回false，没有去改动过
    @Override
    public boolean hasStableIds() {
        return false;
    }

    //  获得父项显示的view
    @Override
    public View getGroupView(int parentPos, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_parent_record_clock, null);
        }
        view.setTag(R.layout.item_parent_record_clock, parentPos);
        view.setTag(R.layout.item_parent_record_clock, -1);
        TextView text = (TextView) view.findViewById(R.id.tv_date);
        text.setText(dataset.get(parentPos).getTime());
        return view;
    }


    //  获得子项显示的view
    @Override
    public View getChildView(final int parentPos, final int childPos, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_child_record_clock, null);
        }
        view.setTag(R.layout.item_parent_record_clock, parentPos);
        view.setTag(R.layout.item_parent_record_clock, childPos);
        TextView text = (TextView) view.findViewById(R.id.tv_time);
        TextView text1 = (TextView) view.findViewById(R.id.tv_content);
        text.setText(dataset.get(parentPos).getTimeEntityList().get(childPos).getTime());
        text1.setText(dataset.get(parentPos).getTimeEntityList().get(childPos).getContent());
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点了" + parentPos + "的第" + childPos, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    //  子项是否可选中，如果需要设置子项的点击事件，需要返回true
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
