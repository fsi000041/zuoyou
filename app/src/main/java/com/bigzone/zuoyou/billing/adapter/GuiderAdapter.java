package com.bigzone.zuoyou.billing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.R;

import java.util.ArrayList;

/**
 * Created by Seriex.X on 2017/7/20.
 */

public class GuiderAdapter extends BaseAdapter {
    private ArrayList<String> arrayList;
    private Context context;

    public GuiderAdapter(ArrayList<String> arrayList, Context context) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_guider, parent, false);
        TextView tvGuider = (TextView) convertView.findViewById(R.id.tv_guider);
        tvGuider.setText(arrayList.get(position));
        return convertView;
    }
}
