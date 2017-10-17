package com.bigzone.zuoyou.Attendance.Activity.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigzone.zuoyou.R;

import java.util.ArrayList;

/**
 * BottomView
 * 
 * @author TanDong
 * 
 */
public class BVAdapter extends BaseAdapter {
	private Context c;
	private ArrayList<String> list;

	public BVAdapter(Context context, ArrayList<String> list) {
		this.c = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		convertView = View.inflate(c, R.layout.bottom_item, null);
		TextView tv = (TextView) convertView.findViewById(R.id.tv_name);
		tv.setText(list.get(position));
		return convertView;
	}

}
