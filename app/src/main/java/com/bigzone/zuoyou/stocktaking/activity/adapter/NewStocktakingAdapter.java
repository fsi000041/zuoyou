package com.bigzone.zuoyou.stocktaking.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.stocktaking.activity.bean.GoodsFatherBean;

import java.util.List;

/**
 * Created by haohongwei on 2017/9/13.
 */

public class NewStocktakingAdapter extends BaseExpandableListAdapter {
    private Context c;
    private List<GoodsFatherBean> list;

    public NewStocktakingAdapter(Context c, List<GoodsFatherBean> list) {
        this.c = c;
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getGoodsSonList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getGoodsSonList().get(childPosition);
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
        return true;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder = null;
        if (convertView == null) {
            groupHolder = new GroupHolder();
            convertView = LayoutInflater.from(c).inflate(R.layout.item_goods_father, parent, false);
            groupHolder.xinghao = (TextView) convertView.findViewById(R.id.tv_xinghao);
            groupHolder.bianhao = (TextView) convertView.findViewById(R.id.tv_bianhao);
            groupHolder.name = (TextView) convertView.findViewById(R.id.tv_name);
            groupHolder.shuliang = (TextView)convertView.findViewById(R.id.tv_shuliang);
            groupHolder.jia = (Button)convertView.findViewById(R.id.bt_jia);
            groupHolder.jian = (Button)convertView.findViewById(R.id.bt_jia);

            convertView.setTag(groupHolder);
        } else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        groupHolder.name.setText("," + list.get(groupPosition).getName());
        groupHolder.xinghao.setText("," + list.get(groupPosition).getXinghao());
        groupHolder.bianhao.setText(","+list.get(groupPosition).getBianhao());
        groupHolder.jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder = null;
        if (convertView == null) {
            childHolder = new ChildHolder();
            convertView = LayoutInflater.from(c).inflate(R.layout.item_goods_child, parent, false);
            childHolder.name1 = (TextView) convertView.findViewById(R.id.tv_name1);
            childHolder.xinghao1 = (TextView) convertView.findViewById(R.id.tv_xinghao1);
            childHolder.bianhao1 = (TextView) convertView.findViewById(R.id.tv_bianhao1);
            convertView.setTag(childHolder);
        } else {
            childHolder = (ChildHolder) convertView.getTag();
        }
        childHolder.name1.setText(list.get(groupPosition).getGoodsSonList().get(childPosition).getName() + "123");
        childHolder.xinghao1.setText("可排车数量:" + list.get(groupPosition).getGoodsSonList().get(childPosition).getXinghao());
        childHolder.bianhao1.setText("X " + list.get(groupPosition).getGoodsSonList().get(childPosition).getBianhao());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    class GroupHolder {
        TextView name, xinghao, bianhao,shuliang;
        Button jia,jian;
    }

    class ChildHolder {
        TextView name1, xinghao1,bianhao1;
        ImageView good;
    }
}
