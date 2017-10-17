package com.bigzone.zuoyou.billing.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.billing.activity.ProductDetailActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Seriex.X on 2017/7/6.
 */

public class ProductListAdapter extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private ArrayList<String> arrayList;
    private  int num;
    private MyClickListener mListener;

    @Override
    public void onClick(View v) {
        mListener.clickListener(v);
    }

    //自定义接口，用于回调
    public interface MyClickListener{
        public void clickListener(View v);
    }

    public ProductListAdapter(Context context, ArrayList<String> arrayList, MyClickListener mListener) {
        this.context = context;
        this.arrayList = arrayList;
        this.mListener = mListener;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_procuct_list, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
//        holder.ivProductImg.setImageDrawable();
        holder.ivCartAdd.setOnClickListener(this);
        holder.rlItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tittle = "App-666 (1+1+3) 布套沙发 卡其色亚麻布套";
                Intent intent = new Intent(context,ProductDetailActivity.class);
                intent.putExtra("tittle",tittle);
                context.startActivity(intent);
            }
        });
/*        holder.tvPrice.setText();
/       holder.tvProductInfo.setText("");*/
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_product_info)
        TextView tvProductInfo;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.iv_product_img)
        ImageView ivProductImg;
        @BindView(R.id.iv_cart_add)
        ImageView ivCartAdd;
        @BindView(R.id.rl_item)
        RelativeLayout rlItem;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
