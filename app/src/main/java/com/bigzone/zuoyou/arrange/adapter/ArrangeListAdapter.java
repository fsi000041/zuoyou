package com.bigzone.zuoyou.arrange.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.arrange.bean.ArrangeEntity;

import java.util.List;

/**
 * Created by haohongwei on 2017/9/12.
 */

public class ArrangeListAdapter extends BaseAdapter {
    private Context c;
    private List<ArrangeEntity> list;

    public ArrangeListAdapter(Context c, List<ArrangeEntity> list) {
        this.c = c;
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
            convertView = LayoutInflater.from(c).inflate(R.layout.item_arrange_list, parent, false);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.num = (TextView) convertView.findViewById(R.id.num);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText("司机:" + list.get(position).getName());
        holder.time.setText("送货时间:" + list.get(position).getTime());
        holder.num.setText("排车单号:" + list.get(position).getNum());
        return convertView;
    }

    class ViewHolder {
        TextView status, name, num, time;
    }
}
