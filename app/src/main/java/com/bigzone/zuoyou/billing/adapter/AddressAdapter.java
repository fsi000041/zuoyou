package com.bigzone.zuoyou.billing.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.billing.bean.AddressEntity;

import java.util.List;

/**
 * Created by Seriex.X on 2017/7/5.
 */

public class AddressAdapter extends BaseAdapter {
    private Context context;
    private List<AddressEntity> list;

    public AddressAdapter(Context context, List<AddressEntity> arrayList) {
        this.context = context;
        this.list = arrayList;
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        AddressEntity entity = list.get(position);
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_address, viewGroup, false);
            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.name);
            holder.phone = (TextView) view.findViewById(R.id.phone);
            holder.address = (TextView) view.findViewById(R.id.address);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText("收货人:" + entity.getName());
        holder.phone.setText(entity.getPhone());
        if (position == 0) {
            holder.address.setText("[当前]" + "地址:" + entity.getArea() + entity.getAddress());
            SpannableStringBuilder builder = new SpannableStringBuilder(holder.address.getText().toString());
            ForegroundColorSpan blueSpan = new ForegroundColorSpan(Color.BLUE);
            builder.setSpan(blueSpan, 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.address.setText(builder);
        } else {
            holder.address.setText("地址:" + entity.getArea() + entity.getAddress());
        }
        return view;
    }

    class ViewHolder {
        TextView name, phone, address;
    }
}
