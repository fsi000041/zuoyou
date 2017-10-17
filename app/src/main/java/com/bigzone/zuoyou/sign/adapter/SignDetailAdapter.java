package com.bigzone.zuoyou.sign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.sales.bean.SalesDetailEntity;
import com.bigzone.zuoyou.sign.bean.GoodsEntity;

import java.util.List;

/**
 * Created by haohongwei on 2017/7/20.
 */

public class SignDetailAdapter extends BaseAdapter {
    private Context context;
    private List<GoodsEntity> list;

    public SignDetailAdapter(Context context, List<GoodsEntity> list) {
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
        GoodsEntity entity = list.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_sign_detail, null);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.count = (TextView) convertView.findViewById(R.id.count);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(entity.getName());
        holder.count.setText("X " + entity.getCount());
        return convertView;
    }

    class ViewHolder {
        TextView name, count;
    }
}
