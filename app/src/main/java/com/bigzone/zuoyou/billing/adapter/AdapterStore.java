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
 * Created by Seriex.X on 2017/7/19.
 */

public class AdapterStore extends BaseAdapter {
    private ArrayList<String> arrayList;
    private Context context;

    public AdapterStore(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
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
        convertView = LayoutInflater.from(context).inflate(R.layout.item_store, parent, false);
        TextView tvStore = (TextView) convertView.findViewById(R.id.tv_store);
        tvStore.setText(arrayList.get(position).toString());
        return convertView;
    }
}
