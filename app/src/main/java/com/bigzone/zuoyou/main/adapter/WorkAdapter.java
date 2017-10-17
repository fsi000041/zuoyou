package com.bigzone.zuoyou.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.main.bean.WorkEntity;

import java.util.List;

/**
 * Created by 郝宏伟 on 2016-12-01.
 */

public class WorkAdapter extends BaseAdapter {
    private Context context;
    private List<WorkEntity> list;

    public WorkAdapter(Context context, List<WorkEntity> list) {
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
        WorkEntity workEntity = list.get(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_work, parent, false);
            holder = new ViewHolder();
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(workEntity.getName());
        holder.icon.setImageResource(workEntity.getImg());
        return convertView;
    }

    private class ViewHolder {
        TextView name;
        ImageView icon;
    }
}
