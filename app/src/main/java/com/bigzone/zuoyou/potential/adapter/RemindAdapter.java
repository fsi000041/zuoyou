package com.bigzone.zuoyou.potential.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.potential.bean.RemindEntity;
import com.bigzone.zuoyou.potential.bean.WishEntity;

import java.util.List;

/**
 * Created by haohongwei on 2017/8/14.
 */

public class RemindAdapter extends BaseAdapter {
    private List<RemindEntity> list;
    private Context context;

    public RemindAdapter(List<RemindEntity> list, Context context) {
        this.list = list;
        this.context = context;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_remind, parent, false);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            holder.status = (CheckBox) convertView.findViewById(R.id.status);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(list.get(position).getName());
        holder.content.setText(list.get(position).getContent());
        holder.time.setText(list.get(position).getTime());
        holder.status.setChecked(list.get(position).isStatus());
        return convertView;
    }

    class ViewHolder {
        TextView content, time, name;
        CheckBox status;
    }
}
