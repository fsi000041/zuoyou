package com.bigzone.zuoyou.arrange.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.arrange.activity.BillDetailActivity;
import com.bigzone.zuoyou.arrange.activity.GoodsDetailActivity;
import com.bigzone.zuoyou.arrange.bean.DeliverGoodsEntity;

import java.util.List;

/**
 * Created by haohongwei on 2017/9/13.
 */

public class DeliverGoodsAdapter extends BaseExpandableListAdapter {
    private Context c;
    private List<DeliverGoodsEntity> list;

    public DeliverGoodsAdapter(Context c, List<DeliverGoodsEntity> list) {
        this.c = c;
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getGoods().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getGoods().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder = null;
        if (convertView == null) {
            groupHolder = new GroupHolder();
            convertView = LayoutInflater.from(c).inflate(R.layout.item_deliver_group, parent, false);
            groupHolder.address = (TextView) convertView.findViewById(R.id.address);
            groupHolder.time = (TextView) convertView.findViewById(R.id.time);
            groupHolder.name = (TextView) convertView.findViewById(R.id.name);
            groupHolder.look = (TextView) convertView.findViewById(R.id.look);
            convertView.setTag(groupHolder);
        } else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        groupHolder.address.setText("," + list.get(groupPosition).getAddress());
        groupHolder.time.setText("," + list.get(groupPosition).getTime());
        groupHolder.name.setText(list.get(groupPosition).getName());
        groupHolder.look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.startActivity(new Intent(c, BillDetailActivity.class));
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder = null;
        if (convertView == null) {
            childHolder = new ChildHolder();
            convertView = LayoutInflater.from(c).inflate(R.layout.item_deliver_child, parent, false);
            childHolder.content = (TextView) convertView.findViewById(R.id.content);
            childHolder.car = (TextView) convertView.findViewById(R.id.car);
            childHolder.count = (TextView) convertView.findViewById(R.id.count);
            convertView.setTag(childHolder);
        } else {
            childHolder = (ChildHolder) convertView.getTag();
        }
        childHolder.content.setText(list.get(groupPosition).getGoods().get(childPosition).getContent());
        childHolder.car.setText("可排车数量:" + list.get(groupPosition).getGoods().get(childPosition).getCar());
        childHolder.count.setText("X " + list.get(groupPosition).getGoods().get(childPosition).getCar());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.startActivity(new Intent(c, GoodsDetailActivity.class));
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    class GroupHolder {
        TextView name, time, address, look;
    }

    class ChildHolder {
        TextView content, count, car;
        ImageView good;
    }
}
