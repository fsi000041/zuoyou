package com.bigzone.zuoyou.sales.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.sales.activity.ChangeAddressActivity;
import com.bigzone.zuoyou.sales.activity.ChangeDetailActivity;
import com.bigzone.zuoyou.sales.activity.PayMoneyActivity;
import com.bigzone.zuoyou.sales.bean.SalesEntity;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.List;

/**
 * Created by haohongwei on 2017/7/20.
 */

public class SalesListAdapter extends BaseAdapter {
    private Context context;
    private List<SalesEntity.RpdataBean.ListBean> list;

    public SalesListAdapter(Context context, List<SalesEntity.RpdataBean.ListBean> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        SalesEntity.RpdataBean.ListBean entity = list.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_sales_list, null);
            holder.num = (TextView) convertView.findViewById(R.id.num);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.count = (TextView) convertView.findViewById(R.id.count);
            holder.should = (TextView) convertView.findViewById(R.id.should);
            holder.paid = (TextView) convertView.findViewById(R.id.paid);
            holder.address = (TextView) convertView.findViewById(R.id.address);
            holder.tv_status = (TextView) convertView.findViewById(R.id.tv_status);
            holder.btn_left = (Button) convertView.findViewById(R.id.btn_left);
            holder.btn_right = (Button) convertView.findViewById(R.id.btn_right);
            holder.btn_mid = (Button) convertView.findViewById(R.id.btn_mid);
            holder.rl_btn = (RelativeLayout) convertView.findViewById(R.id.rl_btn);
            holder.iv_call = (ImageView) convertView.findViewById(R.id.iv_call);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.num.setText(entity.getBillno());
        holder.date.setText(entity.getBilldate());
        holder.name.setText(entity.getProduct().get(0).getProdname() + "……等");
        holder.should.setText("¥" + entity.getTfinalamount());
        holder.paid.setText("¥" + entity.getPaidamount());
        holder.address.setText(entity.getAddress() + "  " + entity.getTelephone());
        holder.count.setText("共" + entity.getTotalquantity() + "件商品");
        if (entity.getStatus().equals("0")) {
            holder.tv_status.setText("待审核");
            holder.btn_mid.setVisibility(View.VISIBLE);
            holder.tv_status.setTextColor(Color.BLACK);
            holder.tv_status.setBackgroundResource(R.drawable.sales_tv_bg_yellow);
            holder.rl_btn.setVisibility(View.VISIBLE);
            holder.btn_left.setVisibility(View.VISIBLE);
            holder.btn_right.setVisibility(View.VISIBLE);
            holder.paid.setTextColor(Color.BLUE);
            holder.btn_mid.setText("审核");
            holder.btn_right.setText("修改");
            holder.btn_left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortMsg("删除");
                }
            });
            holder.btn_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortMsg("修改");
                    Intent intent = new Intent(context, ChangeDetailActivity.class);
                    context.startActivity(intent);
                }
            });
            holder.btn_mid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortMsg("审核");
                }
            });
        } else if (entity.getStatus().equals("1")) {
            holder.btn_mid.setVisibility(View.VISIBLE);
            holder.tv_status.setText("待付款");
            holder.tv_status.setTextColor(Color.WHITE);
            holder.tv_status.setBackgroundResource(R.drawable.sales_tv_bg_red);
            holder.rl_btn.setVisibility(View.VISIBLE);
            holder.btn_left.setVisibility(View.GONE);
            holder.paid.setTextColor(Color.BLUE);
            holder.btn_right.setVisibility(View.VISIBLE);
            holder.btn_mid.setText("交款");
            holder.btn_right.setText("变更");
            holder.btn_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortMsg("变更");
                    Intent intent = new Intent(context, ChangeAddressActivity.class);
                    context.startActivity(intent);
                }
            });
            holder.btn_mid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortMsg("交款");
                    Intent intent = new Intent(context, PayMoneyActivity.class);
                    context.startActivity(intent);
                }
            });
        } else if (entity.getStatus().equals("2")) {
            holder.btn_mid.setVisibility(View.GONE);
            holder.tv_status.setText("已付款");
            holder.rl_btn.setVisibility(View.VISIBLE);
            holder.tv_status.setTextColor(Color.WHITE);
            holder.tv_status.setBackgroundResource(R.drawable.sales_tv_bg_blue);
            holder.btn_right.setVisibility(View.VISIBLE);
            holder.btn_right.setText("变更");
            holder.btn_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShortMsg("变更");
                    Intent intent = new Intent(context, ChangeAddressActivity.class);
                    context.startActivity(intent);
                }
            });
            holder.paid.setTextColor(Color.GRAY);
        } else if (entity.getStatus().equals("3")) {
            holder.btn_mid.setVisibility(View.GONE);
            holder.tv_status.setText("已结案");
            holder.tv_status.setTextColor(Color.WHITE);
            holder.tv_status.setBackgroundResource(R.drawable.sales_tv_bg_gray);
            holder.rl_btn.setVisibility(View.GONE);
            holder.btn_right.setVisibility(View.GONE);
            holder.paid.setTextColor(Color.GRAY);
        }

        holder.iv_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.whitchPhone(position);
            }
        });
        return convertView;
    }

    class ViewHolder {
        TextView num, date, name, count, should, paid, address, tv_status;
        Button btn_left, btn_right, btn_mid;
        RelativeLayout rl_btn;
        ImageView iv_call;
    }

    /**
     * 支付宝手工输入完成回调
     */
    public static interface OnTelListenet {
        public void whitchPhone(int position);
    }

    public void setOnTelListener(OnTelListenet listener) {
        this.listener = listener;
    }

    private OnTelListenet listener;

}
