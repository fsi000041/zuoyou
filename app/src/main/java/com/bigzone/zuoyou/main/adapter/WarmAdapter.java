package com.bigzone.zuoyou.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.main.activity.LeaveDetailActivity;
import com.bigzone.zuoyou.main.activity.NoticeActivity;
import com.bigzone.zuoyou.main.bean.WarmEntity;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.List;

/**
 * Created by haohongwei on 2017/8/25.
 */

public class WarmAdapter extends BaseAdapter {
    private Context context;
    private List<WarmEntity> list;

    public WarmAdapter(Context context, List<WarmEntity> list) {
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
        WarmEntity warmEntity = list.get(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_warm, parent, false);
            holder = new ViewHolder();
            holder.tv_status = (TextView) convertView.findViewById(R.id.tv_status);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            holder.tv_read = (TextView) convertView.findViewById(R.id.tv_read);
            holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            holder.btn_agree = (Button) convertView.findViewById(R.id.btn_agree);
            holder.btn_refuse = (Button) convertView.findViewById(R.id.btn_refuse);
            holder.btn_other = (Button) convertView.findViewById(R.id.btn_other);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (warmEntity.getStatus() == 1) {
            holder.tv_status.setText("审批");
            holder.tv_status.setBackgroundResource(R.drawable.sales_tv_bg_blue);
            holder.tv_status.setTextColor(Color.WHITE);
            holder.btn_other.setVisibility(View.GONE);
            holder.btn_agree.setVisibility(View.VISIBLE);
            holder.btn_refuse.setVisibility(View.VISIBLE);
        } else if (warmEntity.getStatus() == 2) {
            holder.tv_status.setText("公告");
            holder.tv_status.setBackgroundResource(R.drawable.sales_tv_bg_yellow);
            holder.tv_status.setTextColor(Color.BLACK);
            holder.btn_other.setVisibility(View.VISIBLE);
            holder.btn_agree.setVisibility(View.GONE);
            holder.btn_refuse.setVisibility(View.GONE);
            holder.btn_other.setText("查看详情");
            holder.btn_other.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NoticeActivity.class);
                    context.startActivity(intent);
                }
            });
        } else if (warmEntity.getStatus() == 3) {
            holder.tv_status.setText("待办");
            holder.tv_status.setBackgroundResource(R.drawable.sales_tv_bg_red);
            holder.tv_status.setTextColor(Color.WHITE);
            holder.btn_other.setVisibility(View.VISIBLE);
            holder.btn_agree.setVisibility(View.GONE);
            holder.btn_refuse.setVisibility(View.GONE);
            holder.btn_other.setText("标记完成");
            holder.btn_other.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showLongMsg("标记完成");
                }
            });
        }
        holder.tv_title.setText(warmEntity.getTitle());
        holder.tv_content.setText(warmEntity.getContent());
        holder.tv_time.setText(warmEntity.getTime());
        if (warmEntity.isRead()) {
            holder.tv_read.setVisibility(View.GONE);
        } else {
            holder.tv_read.setVisibility(View.VISIBLE);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, LeaveDetailActivity.class));
            }
        });
        return convertView;
    }

    private class ViewHolder {
        TextView tv_status, tv_title, tv_content, tv_read, tv_time;
        Button btn_agree, btn_other, btn_refuse;
    }
}
