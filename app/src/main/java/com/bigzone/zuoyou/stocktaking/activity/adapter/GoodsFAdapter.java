package com.bigzone.zuoyou.stocktaking.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.stocktaking.activity.bean.GoodsFatherBean;

import java.util.List;

/**
 * Created by sszz on 2017/9/15.
 */

public class GoodsFAdapter extends BaseExpandableListAdapter{
    private Context context;
    private List<GoodsFatherBean> groupList;


    public GoodsFAdapter(Context context, List<GoodsFatherBean> groupList) {
        this.context = context;
        this.groupList = groupList;
    }



    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupList.get(groupPosition).getGoodsSonList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupList.get(groupPosition).getGoodsSonList().get(childPosition);
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
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder = null;
        if (convertView == null){
            groupHolder = new GroupHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_goods_father,parent,false);
            groupHolder.groupName = (TextView) convertView.findViewById(R.id.name);
            groupHolder.groupBianhao = (TextView) convertView.findViewById(R.id.tv_bianhao);
            groupHolder.groupXinghao = (TextView) convertView.findViewById(R.id.tv_xinghao);

            convertView.setTag(groupHolder);
        }else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        groupHolder.groupName.setText("12321"+groupList.get(groupPosition).getName());
        groupHolder.groupXinghao.setText(groupList.get(groupPosition).getXinghao());
        groupHolder.groupBianhao.setText(groupList.get(groupPosition).getBianhao());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder = null;
        if (convertView == null){
            childHolder = new ChildHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_goods_child,parent,false);
            childHolder.mingzi = (TextView) convertView.findViewById(R.id.name);
            childHolder.xinghao = (TextView) convertView.findViewById(R.id.tv_bianhao);
            childHolder.bianhao = (TextView) convertView.findViewById(R.id.tv_xinghao);
            convertView.setTag(childHolder);
        }else {
            childHolder = (ChildHolder) convertView.getTag();
        }
        childHolder.mingzi.setText(groupList.get(groupPosition).getGoodsSonList().get(childPosition).getName());
        childHolder.xinghao.setText(groupList.get(groupPosition).getGoodsSonList().get(childPosition).getXinghao());
        childHolder.bianhao.setText(groupList.get(groupPosition).getGoodsSonList().get(childPosition).getBianhao());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    class GroupHolder{
        public TextView groupName,groupXinghao,groupBianhao;
        public ImageView arrow;
    }

    class ChildHolder{
        public TextView mingzi,xinghao,bianhao;
        public ImageView divider;
    }
}


