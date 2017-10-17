package com.bigzone.zuoyou.billing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Seriex.X on 2017/7/6.
 */

public class ShoppingCartAdapter extends BaseAdapter {
    private ArrayList<String> arrayList;
    private Context context;

    public ShoppingCartAdapter(ArrayList<String> arrayList, Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shopping_cart, parent, false);
            holder = new ViewHolder(convertView);
            holder.tvProductInfo.setText(arrayList.get(position));
            convertView.setTag(holder);
            if ((position/2) == 0) {
                holder.rlCombine.setVisibility(View.VISIBLE);
            }
//            else {
//                holder.rlCombine.setVisibility(View.GONE);
//            }
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.checkbox)
        CheckBox checkBox;
        @BindView(R.id.iv_product_img)
        ImageView imageView;
        @BindView(R.id.tv_product_info)
        TextView tvProductInfo;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_minu)
        TextView tvMinu;
        @BindView(R.id.tv_number_cart)
        TextView tvNumber;
        @BindView(R.id.tv_add)
        TextView tvAdd;
        @BindView(R.id.rl_combine)
        RelativeLayout rlCombine;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
