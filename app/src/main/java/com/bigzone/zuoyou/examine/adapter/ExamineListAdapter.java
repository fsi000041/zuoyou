package com.bigzone.zuoyou.examine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.examine.bean.ExamineEntity;

import java.util.List;

/**
 * Created by haohongwei on 2017/9/6.
 */

public class ExamineListAdapter extends BaseAdapter {
    private Context context;
    private List<ExamineEntity> list;

    public ExamineListAdapter(Context context, List<ExamineEntity> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_examine_list, parent, false);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            holder.project = (TextView) convertView.findViewById(R.id.project);
            holder.num = (TextView) convertView.findViewById(R.id.num);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.date.setText(list.get(position).getDate());
        holder.project.setText(list.get(position).getProject());
        holder.num.setText("审批单号:" + list.get(position).getNum());
        return convertView;
    }

    class ViewHolder {
        TextView date, project, num, money;
    }
}
