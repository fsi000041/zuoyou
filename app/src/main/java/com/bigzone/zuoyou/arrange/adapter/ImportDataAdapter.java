package com.bigzone.zuoyou.arrange.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.arrange.bean.ImportDataEntity;

import java.util.List;

/**
 * Created by haohongwei on 2017/9/18.
 */

public class ImportDataAdapter extends BaseAdapter {
    private Context c;
    private List<ImportDataEntity> list;

    public ImportDataAdapter(Context c, List<ImportDataEntity> list) {
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
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(c).inflate(R.layout.item_import_data, parent, false);
            holder.num = (TextView) convertView.findViewById(R.id.num);
            holder.info = (TextView) convertView.findViewById(R.id.info);
            holder.address = (TextView) convertView.findViewById(R.id.address);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            holder.isImport = (CheckBox) convertView.findViewById(R.id.isImport);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.num.setText("来源单号:" + list.get(position).getNum());
        holder.info.setText("顾客信息:" + list.get(position).getInfo());
        holder.address.setText("送货区域:" + list.get(position).getAddress());
        holder.date.setText("送货日期:" + list.get(position).getDate());
        if (list.get(position).isImport()) {
            holder.isImport.setText("已导入");
            holder.isImport.setBackgroundResource(R.drawable.sales_tv_bg_gray);
        } else {
            holder.isImport.setText("导入");
            holder.isImport.setBackgroundResource(R.drawable.sales_tv_bg_blue);
        }
        return convertView;
    }

    class ViewHolder {
        TextView num, info, address, date;
        CheckBox isImport;
    }
}
