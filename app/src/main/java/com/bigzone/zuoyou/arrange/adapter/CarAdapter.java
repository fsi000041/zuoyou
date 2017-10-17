package com.bigzone.zuoyou.arrange.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.arrange.bean.CarEntity;

import java.util.List;

/**
 * Created by haohongwei on 2017/9/15.
 */

public class CarAdapter extends BaseAdapter {
    private Context c;
    private List<CarEntity> list;

    public CarAdapter(Context c, List<CarEntity> list) {
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
        convertView = LayoutInflater.from(c).inflate(R.layout.item_car, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView num = (TextView) convertView.findViewById(R.id.num);
        name.setText(list.get(position).getName());
        num.setText(list.get(position).getNum());
        return convertView;
    }
}
