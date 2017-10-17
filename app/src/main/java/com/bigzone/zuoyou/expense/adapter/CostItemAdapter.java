package com.bigzone.zuoyou.expense.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.expense.bean.CostItemEntity;
import com.bigzone.zuoyou.expense.bean.ExpenseEntity;

import java.util.List;

/**
 * Created by haohongwei on 2017/9/6.
 */

public class CostItemAdapter extends BaseAdapter {
    private Context context;
    private List<CostItemEntity> list;

    public CostItemAdapter(Context context, List<CostItemEntity> list) {
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
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cost_item, parent, false);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.note = (TextView) convertView.findViewById(R.id.note);
            holder.money = (TextView) convertView.findViewById(R.id.money);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(list.get(position).getName());
        holder.note.setText(list.get(position).getNote());
        holder.money.setText(list.get(position).getMoney());
        return convertView;
    }

    class ViewHolder {
        TextView name, note, money;
    }
}
