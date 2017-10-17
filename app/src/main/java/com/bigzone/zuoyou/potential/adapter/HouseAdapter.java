package com.bigzone.zuoyou.potential.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.potential.bean.HouseEntity;
import com.bigzone.zuoyou.potential.bean.WishEntity;

import java.util.List;

/**
 * Created by haohongwei on 2017/8/14.
 */

public class HouseAdapter extends BaseAdapter {
    private List<HouseEntity> list;
    private Context context;

    public HouseAdapter(List<HouseEntity> list, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_house, parent, false);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.mode = (TextView) convertView.findViewById(R.id.mode);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(list.get(position).getName());
        holder.mode.setText(list.get(position).getMode());
        holder.time.setText(list.get(position).getTime());
        return convertView;
    }

    class ViewHolder {
        TextView name, time, mode;
    }
}
