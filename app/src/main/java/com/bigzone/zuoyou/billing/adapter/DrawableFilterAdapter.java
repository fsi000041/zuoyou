package com.bigzone.zuoyou.billing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bigzone.zuoyou.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Seriex.X on 2017/7/21.
 */

public class DrawableFilterAdapter extends BaseAdapter {
    private ArrayList<Map<String, String>> arrayList;
    private Context context;

    public DrawableFilterAdapter(Context context, ArrayList<Map<String, String>> arrayList) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.item_drawable_filter, parent, false);
        return convertView;
    }
}
