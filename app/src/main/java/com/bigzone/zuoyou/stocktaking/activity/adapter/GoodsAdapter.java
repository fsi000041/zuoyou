package com.bigzone.zuoyou.stocktaking.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.stocktaking.activity.bean.GoodsBean;

import java.util.List;

/**
 * Created by sszz on 2017/9/18.
 */

public class GoodsAdapter extends BaseAdapter {
    private List<GoodsBean> list;
    private Context context;

    public GoodsAdapter(List<GoodsBean> list, Context context) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_goods, parent, false);
        TextView tv_huoweihap = (TextView) inflate.findViewById(R.id.tv_huoweihao);
        tv_huoweihap.setText(list.get(position).getNum());
        return inflate;
    }

}
