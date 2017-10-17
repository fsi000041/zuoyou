package com.bigzone.zuoyou.sales.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.sales.activity.PayMoneyActivity;
import com.bigzone.zuoyou.sales.bean.SalesDetailEntity;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.Enumeration;
import java.util.List;

/**
 * Created by haohongwei on 2017/7/20.
 */

public class SalesDetailAdapter extends BaseAdapter {
    private Context context;
    private List<SalesDetailEntity.OrderBean.ProductBean> list;

    public SalesDetailAdapter(Context context, List<SalesDetailEntity.OrderBean.ProductBean> list) {
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
        SalesDetailEntity.OrderBean.ProductBean entity = list.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_sales_detail, null);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.count = (TextView) convertView.findViewById(R.id.count);
            holder.money = (TextView) convertView.findViewById(R.id.money);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(entity.getProdname());
        holder.money.setText("¥" + entity.getUnitprice());
        holder.count.setText("X " + entity.getQuantity());
        return convertView;
    }

    class ViewHolder {
        TextView name, count, money;
    }
}
