package com.bigzone.zuoyou.stocktaking.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.stocktaking.activity.bean.AtocktakingRecordBean;

import java.util.List;

/**
 * Created by sszz on 2017/9/19.
 */

public class AtocktakingRecordAdapter extends BaseAdapter {
    private List<AtocktakingRecordBean> list;
    private Context context;

    public AtocktakingRecordAdapter(List<AtocktakingRecordBean> list, Context context) {
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
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_atocktaking_record,parent,false);
            holder.num = (TextView) convertView.findViewById(R.id.tv_num);
            holder.record = (TextView) convertView.findViewById(R.id.tv_record);
            holder.rl = (RelativeLayout) convertView.findViewById(R.id.rl);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
            holder.num.setText(list.get(position).getNum()+"");
            holder.record.setText(list.get(position).getRecord()+"");

        }
        return convertView;
    }

    public class Holder{
        TextView num,record;
        RelativeLayout rl;
    }
}
