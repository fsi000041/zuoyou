package com.bigzone.zuoyou.Attendance.Activity.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.Attendance.Activity.bean.ApprovalProcessBean;
import com.bigzone.zuoyou.R;

import java.util.List;

/**
 * Created by sszz on 2017/9/11.
 */

public class ApprovalProcessAdapter extends BaseAdapter {
    private Context context;
    private List<ApprovalProcessBean> list;

    public ApprovalProcessAdapter(Context context, List<ApprovalProcessBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       convertView = View.inflate(context,R.layout.item_approval_process,null);
        TextView tv = (TextView) convertView.findViewById(R.id.tv_name);
        tv.setText(list.get(position).getName1());
        return convertView;
    }
}
