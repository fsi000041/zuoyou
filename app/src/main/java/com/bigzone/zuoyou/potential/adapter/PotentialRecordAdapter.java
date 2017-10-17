package com.bigzone.zuoyou.potential.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.reception.bean.RecordEntity;

import java.util.List;

/**
 * Created by haohongwei on 2017/8/14.
 */

public class PotentialRecordAdapter extends BaseAdapter {
    private List<RecordEntity> list;
    private Context context;

    public PotentialRecordAdapter(List<RecordEntity> list, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_record, parent, false);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.man = (TextView) convertView.findViewById(R.id.man);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            holder.state = (TextView) convertView.findViewById(R.id.state);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(list.get(position).getName());
        holder.man.setText(list.get(position).getMan());
        holder.time.setText(list.get(position).getTime());
        if (list.get(position).getStatus() == 0) {
            holder.state.setText("等待上传");
            holder.state.setTextColor(Color.WHITE);
            holder.state.setBackgroundResource(R.drawable.sales_tv_bg_lightblue);
        } else if (list.get(position).getStatus() == 1) {
            holder.state.setText("上传中");
            holder.state.setTextColor(Color.WHITE);
            holder.state.setBackgroundResource(R.drawable.sales_tv_bg_blue);
        } else if (list.get(position).getStatus() == 2) {
            holder.state.setText("上传失败");
            holder.state.setTextColor(Color.WHITE);
            holder.state.setBackgroundResource(R.drawable.sales_tv_bg_red);
        } else if (list.get(position).getStatus() == 3) {
            holder.state.setText("已上传");
            holder.state.setTextColor(Color.BLACK);
            holder.state.setBackgroundResource(R.drawable.sales_tv_bg_yellow);
        } else if (list.get(position).getStatus() == 4) {
            holder.state.setText("已填写");
            holder.state.setTextColor(Color.WHITE);
            holder.state.setBackgroundResource(R.drawable.sales_tv_bg_gray);
        }
        return convertView;
    }

    class ViewHolder {
        TextView name, time, man, state;
    }
}
