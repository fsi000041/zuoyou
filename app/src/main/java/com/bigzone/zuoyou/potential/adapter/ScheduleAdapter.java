package com.bigzone.zuoyou.potential.adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.potential.bean.ScheduleEntity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by haohongwei on 2017/8/23.
 */

public class ScheduleAdapter extends BaseAdapter {
    private List<ScheduleEntity> list;
    private Context context;

    public ScheduleAdapter(List<ScheduleEntity> list, Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_schedule, parent, false);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.status = (TextView) convertView.findViewById(R.id.status);
            holder.line = (ImageView) convertView.findViewById(R.id.line);
            holder.point = (ImageView) convertView.findViewById(R.id.point);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(list.get(position).getName());
        holder.status.setText(list.get(position).getStatus());
        if (position == 0) {
            holder.line.setImageResource(R.drawable.point_top);
        } else if (position == list.size() - 1) {
            holder.line.setImageResource(R.drawable.point_bottom);
        } else {
            holder.line.setImageResource(R.drawable.point_middle);
        }

        if (list.get(position).getStatus().equals("标记完成")) {
            holder.point.setVisibility(View.VISIBLE);
            holder.name.setTextColor(Color.BLUE);
            holder.status.setBackgroundResource(R.drawable.sales_tv_bg_blue);
            holder.status.setTextColor(Color.WHITE);
        } else {
            holder.point.setVisibility(View.GONE);
            holder.name.setTextColor(Color.GRAY);
            holder.status.setBackgroundResource(R.color.colorWhite);
            holder.status.setTextColor(Color.GRAY);
        }

        holder.status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date curDate = new Date(System.currentTimeMillis());
                String time = formatter.format(curDate);
                if (position != (list.size() - 1)) {
                    list.get(position).setStatus(time + " 完成");
                    list.get((position + 1)).setStatus("标记完成");
                } else {
                    list.get(position).setStatus(time + " 完成");
                }
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    class ViewHolder {
        TextView name, status;
        ImageView line, point;
    }
}
