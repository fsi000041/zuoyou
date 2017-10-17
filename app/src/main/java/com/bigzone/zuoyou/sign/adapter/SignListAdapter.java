package com.bigzone.zuoyou.sign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.sign.bean.SignEntity;

import java.util.List;

/**
 * Created by haohongwei on 2017/9/26.
 */

public class SignListAdapter extends BaseAdapter {
    private Context c;
    private List<SignEntity> list;

    public SignListAdapter(Context c, List<SignEntity> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(c).inflate(R.layout.item_sign_list, parent, false);
            holder.num = (TextView) convertView.findViewById(R.id.num);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            holder.address = (TextView) convertView.findViewById(R.id.address);
            holder.rl_bottom = (RelativeLayout) convertView.findViewById(R.id.rl_btn);
            holder.btn_mid = (Button) convertView.findViewById(R.id.btn_mid);
            holder.btn_right = (Button) convertView.findViewById(R.id.btn_right);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.num.setText("订单编号:" + list.get(position).getNum());
        holder.address.setText(list.get(position).getAddress());
        holder.date.setText(list.get(position).getDate());
        if (list.get(position).isSign()) {
            holder.rl_bottom.setVisibility(View.GONE);
        } else {
            holder.rl_bottom.setVisibility(View.VISIBLE);
        }

        holder.btn_mid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.takePhoto(position);
            }
        });

        holder.btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.takeSign(position);
            }
        });
        return convertView;
    }

    class ViewHolder {
        TextView num, date, address;
        RelativeLayout rl_bottom;
        Button btn_mid, btn_right;
    }

    public interface onBtnClickListener {
        void takePhoto(int position);

        void takeSign(int position);
    }

    private onBtnClickListener listener;


    public void setOnBtnClickListener(onBtnClickListener listener) {
        this.listener = listener;
    }

}
