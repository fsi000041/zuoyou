package com.bigzone.zuoyou.examine.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.Attendance.Activity.Adapter.BVAdapter;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.ToastUtils;
import com.tandong.bottomview.view.BottomView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;




/**
 * Created by haohongwei on 2017/9/6.
 */

public class ExamineAddActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.iv_top_right)
    ImageView ivTopRight;
    @BindView(R.id.iv_top_left)
    ImageView ivTopLeft;
    @BindView(R.id.tv_top_right)
    TextView tvTopRight;
    @BindView(R.id.tv_top_left)
    TextView tvTopLeft;
    @BindView(R.id.shuoming)
    RelativeLayout shuoming;
    @BindView(R.id.beizhu)
    RelativeLayout beizhu;
    @BindView(R.id.time)
    RelativeLayout time;
    @BindView(R.id.feiyong)
    RelativeLayout feiyong;
    @BindView(R.id.feiyongtianjia)
    RelativeLayout feiyongtianjia;
    @BindView(R.id.fujian)
    RelativeLayout fujian;
    @BindView(R.id.fujiantianjia)
    RelativeLayout fujiantianjia;
    @BindView(R.id.add)
    RelativeLayout add;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private BottomView bottomView;
    private ListView listView;
    private BVAdapter bvAdapter;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected int bindLayout() {
        return R.layout.activity_examine_add;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("新审批");
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add("文字说明");
        list.add("日期时间");
        list.add("人员选择");
        list.add("整数数字");
        list.add("费用");
        list.add("附件");
        list.add("取消");
    }


    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnClick(R.id.add)
    void showBottom() {
        bottomView = new BottomView(ExamineAddActivity.this,
                R.style.BottomViewTheme_Defalut, R.layout.bottom_view);

        bottomView.setAnimation(R.style.BottomToTopAnim);

        bottomView.showBottomView(false);

        listView = (ListView) bottomView.getView().findViewById(R.id.lv_list);
        bvAdapter = new BVAdapter(ExamineAddActivity.this, list);
        listView.setAdapter(bvAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list.get(position).equals("文字说明")) {
//                    shuoming.setVisibility(View.VISIBLE);
//                    bottomView.dismissBottomView();
//                    ToastUtils.showShortMsg("文字说明");
                    showMissingPermissionDialog();

                } else if (list.get(position).equals("日期时间")) {
                    ToastUtils.showShortMsg("日期时间");
                    time.setVisibility(View.VISIBLE);
                    bottomView.dismissBottomView();
                } else if (list.get(position).equals("人员选择")) {
                    ToastUtils.showShortMsg("人员选择");

                } else if (list.get(position).equals("整数数字")) {
                    ToastUtils.showShortMsg("整数数字");
                } else if (list.get(position).equals("费用")) {
                    ToastUtils.showShortMsg("费用");
                    feiyong.setVisibility(View.VISIBLE);
                    feiyongtianjia.setVisibility(View.VISIBLE);
                    bottomView.dismissBottomView();
                } else if (list.get(position).equals("附件")) {
                    ToastUtils.showShortMsg("附件");
                    fujian.setVisibility(View.VISIBLE);
                    fujiantianjia.setVisibility(View.VISIBLE);
                    bottomView.dismissBottomView();
                } else if (list.get(position).equals("取消")) {
                    bottomView.dismissBottomView();
                }
            }
        });
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private void showMissingPermissionDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(ExamineAddActivity.this, R.style.dialog);
        final Dialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
        Window window = dialog.getWindow();
        window.setContentView(R.layout.dialog_set);
        TextView tv_cancel = (TextView) window.findViewById(R.id.tv_cancle);
        TextView tvSet = (TextView) window.findViewById(R.id.tv_login);

        /**
         * 关闭dialog
         */

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

}
