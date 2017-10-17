package com.bigzone.zuoyou.Attendance.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.bigzone.zuoyou.Attendance.Activity.ClockSignctivity;
import com.bigzone.zuoyou.Attendance.Activity.bean.OutSideBean;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.List;

/**
 * Created by sszz on 2017/9/12.
 */

public class OutSideAdapter extends BaseAdapter {
    private Context context;
    private List<OutSideBean> list;

    public OutSideAdapter(Context context, List<OutSideBean> list) {
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
        ViewHold hold = null;
        if (convertView == null){
            hold = new ViewHold();
            convertView  = LayoutInflater.from(context).inflate(R.layout.item_work_out_side,parent,false);
            hold.sign = (Button) convertView.findViewById(R.id.bt_sign);
            hold.time =(TextView) convertView.findViewById(R.id.time);
            hold.address = (TextView) convertView.findViewById(R.id.address);
            hold.things = (TextView) convertView.findViewById(R.id.things);
            convertView.setTag(hold);
        }else {
            hold = (ViewHold) convertView.getTag();
        }
        hold.address.setText(list.get(position).getAddress());
        hold.things.setText(list.get(position).getThings());
        hold.time.setText(list.get(position).getTime());
        hold.sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShortMsg("123231");
                Intent intent = new Intent(context, ClockSignctivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        return convertView;
    }



    class ViewHold{
        TextView time,address,things;
        Button sign;
    }
}
