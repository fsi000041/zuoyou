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
 * Created by Seriex.X on 2017/7/5.
 */

public class PoductClassAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> arrayList;

    public PoductClassAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_product_class, viewGroup, false);
        TextView tv=(TextView)view.findViewById(R.id.tv_product_class);
//        tv.setText("");
        return view;
    }
}
