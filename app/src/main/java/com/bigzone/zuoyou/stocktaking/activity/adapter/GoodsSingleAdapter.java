package com.bigzone.zuoyou.stocktaking.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.R;

/**
 * Created by sszz on 2017/9/18.
 */

public class GoodsSingleAdapter extends BaseAdapter{
    /*private List<GoodsSingleBean> list;*/
    private Context context;
    private String result;

    public GoodsSingleAdapter(/*List<GoodsSingleBean> list,*/ Context context/*, String result*/) {
      /*  this.list = list;*/
        this.context = context;
      /*  this.result = result;*/
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_goods_father, parent, false);
        TextView xinghao = (TextView) view.findViewById(R.id.tv_xinghao);
        TextView bianhao = (TextView) view.findViewById(R.id.tv_bianhao);
        TextView name = (TextView) view.findViewById(R.id.tv_name);
        name.setText("111");
        bianhao.setText("2323");
        xinghao.setText("333");
        return convertView;
    }
}
