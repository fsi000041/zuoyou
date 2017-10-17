package com.bigzone.zuoyou.Attendance.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.Attendance.Activity.bean.AskForLeaveBean;
import com.bigzone.zuoyou.R;

import java.util.List;

/**
 * Created by sszz on 2017/9/8.
 */

public class AskForLeaveAdapter extends BaseAdapter {
    private Context context;
    private List<AskForLeaveBean> list;

    public AskForLeaveAdapter(Context context, List<AskForLeaveBean> list) {
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
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_ask_for_leave,parent,false);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            holder.num = (TextView) convertView.findViewById(R.id.num);
            holder.state = (TextView) convertView.findViewById(R.id.state);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.date.setText(list.get(position).getDate());
        holder.state.setText(list.get(position).getState());
        holder.num.setText(list.get(position).getNum());

        return convertView;
    }

    class ViewHolder {
        TextView date, state, num;
    }
}
