package com.bigzone.zuoyou.Attendance.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.Attendance.Activity.bean.WorkOverTimeBean;
import com.bigzone.zuoyou.R;

import java.util.List;

/**
 * Created by sszz on 2017/9/11.
 */

public class WorkOverTimeAdapter extends BaseAdapter {
    private Context context;
    private List<WorkOverTimeBean> list;

    public WorkOverTimeAdapter(Context context, List<WorkOverTimeBean> list) {
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
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_work_over_time,parent,false);
            viewHolder.danhao = (TextView) convertView.findViewById(R.id.danhao);
            viewHolder.jiaban = (TextView) convertView.findViewById(R.id.jiaban);
            viewHolder.state = (TextView) convertView.findViewById(R.id.state);
            convertView.setTag(viewHolder);
        }else {
           viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.jiaban.setText(list.get(position).getJiaban());
        viewHolder.state.setText(list.get(position).getState());
        viewHolder.danhao.setText(list.get(position).getDanhao());

        return convertView;
    }
    class ViewHolder{
        TextView jiaban,danhao,state;
    }
}
