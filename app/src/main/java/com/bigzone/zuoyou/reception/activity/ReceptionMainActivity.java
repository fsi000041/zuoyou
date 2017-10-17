package com.bigzone.zuoyou.reception.activity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.reception.adapter.RecordAdapter;
import com.bigzone.zuoyou.reception.bean.RecordEntity;
import com.bigzone.zuoyou.reception.service.RecordService;
import com.bigzone.zuoyou.utils.CommonUtil;
import com.bigzone.zuoyou.utils.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/8.
 */

public class ReceptionMainActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, Chronometer.OnChronometerTickListener, AdapterView.OnItemClickListener {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_histroy;
    @BindView(R.id.cm_time)
    Chronometer cm_time;
    @BindView(R.id.cb_start)
    CheckBox cb_start;
    @BindView(R.id.iv_voice)
    ImageView iv_voice;
    @BindView(R.id.listView)
    ListView listView;
    private List<RecordEntity> list = new ArrayList<>();
    private RecordService bindService;
    private RecordAdapter recordAdapter;
    private boolean isBound = false;
    private int miss = 0;
    private static int REQ_CODE_PERMISSION = 1001;
    private long name;
    @BindView(R.id.ll_empty)
    LinearLayout ll_empty;

    @Override
    protected int bindLayout() {
        return R.layout.activity_reception_main;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_histroy.setText("历史接待");
        tv_title.setText("接待");
        tv_histroy.setVisibility(View.VISIBLE);
        cb_start.setOnCheckedChangeListener(this);
        cm_time.setOnChronometerTickListener(this);
        cm_time.setText(FormatMiss(0));
        if (ContextCompat.checkSelfPermission(ReceptionMainActivity.this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ReceptionMainActivity.this, new String[]{Manifest.permission.RECORD_AUDIO}, REQ_CODE_PERMISSION);
        }
        if (ContextCompat.checkSelfPermission(ReceptionMainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ReceptionMainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQ_CODE_PERMISSION);
        }
        File file = new File(CommonUtil.getSDPath() + "/voice");
        if (!file.exists()) {
            file.mkdir();
        }

        recordAdapter = new RecordAdapter(list, this);
        listView.setAdapter(recordAdapter);
        listView.setEmptyView(ll_empty);
        listView.setOnItemClickListener(this);
        initData();
    }

    private void initData() {
        list.add(new RecordEntity(0, "录音0", "2017-08-08 10:00-10:20", "新街口店张小姐"));
        list.add(new RecordEntity(1, "录音1", "2017-08-08 16:00-16:20", "常府街店张小姐"));
        list.add(new RecordEntity(2, "录音2", "2017-08-08 19:00-19:20", "夫子庙店张小姐"));
        list.add(new RecordEntity(3, "录音3", "2017-08-08 20:00-20:30", "张府园店张小姐"));
        list.add(new RecordEntity(4, "录音4", "2017-08-08 22:10-22:24", "新街口店李小姐"));
        recordAdapter.notifyDataSetChanged();
    }


    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            isBound = true;
            RecordService.MyBinder binder = (RecordService.MyBinder) service;
            bindService = binder.getService();
            updateMicStatus();
        }

        //client 和service连接意外丢失时，会调用该方法
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.v("hjz", "onServiceDisconnected  A");
        }
    };


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Intent intent = null;
        if (isChecked) {
            cb_start.setText("结束接待");
            intent = new Intent(ReceptionMainActivity.this, RecordService.class);
            name = System.currentTimeMillis();
            intent.putExtra("name", name + "");
            bindService(intent, conn, BIND_AUTO_CREATE);
            cm_time.start();
        } else {
            cb_start.setText("开始接待");
            if (isBound) {
                isBound = false;
                unbindService(conn);
            }
            miss = 0;
            cm_time.stop();
            Logger.d("name", "name : " + name + ".amr");
//            File file = new File(CommonUtil.getSDPath() + "/voice/" + name + ".amr");
//            修改名字
//            File newF = new File(CommonUtil.getSDPath() + "/voice/" + "修改名字" + ".amr");
//            file.renameTo(newF);
//
//            删除文件
//            file.delete();
        }
    }

    /**
     * 更新话筒状态
     */
    private int SPACE = 100;// 间隔取样时间

    private void updateMicStatus() {
//        tv_time.setText("分贝:" + bindService.getRandomNumber());
        setImageView(bindService.getRandomNumber());
        mHandler.postDelayed(mUpdateMicStatusTimer, SPACE);
    }

    private void setImageView(double randomNumber) {
        if (randomNumber > 75) {
            iv_voice.setImageResource(R.drawable.voice_10);
        } else if (randomNumber > 65) {
            iv_voice.setImageResource(R.drawable.voice_8);
        } else if (randomNumber > 55) {
            iv_voice.setImageResource(R.drawable.voice_6);
        } else if (randomNumber > 45) {
            iv_voice.setImageResource(R.drawable.voice_4);
        } else if (randomNumber > 35) {
            iv_voice.setImageResource(R.drawable.voice_2);
        } else {
            iv_voice.setImageResource(R.drawable.voice_0);
        }
    }

    private final Handler mHandler = new Handler();
    private Runnable mUpdateMicStatusTimer = new Runnable() {
        public void run() {
            updateMicStatus();
        }
    };

    @Override
    public void onChronometerTick(Chronometer chronometer) {
        miss++;
        chronometer.setText(FormatMiss(miss));
    }


    // 将秒转化成小时分钟秒
    public String FormatMiss(int miss) {
        String hh = miss / 3600 > 9 ? miss / 3600 + "" : "0" + miss / 3600;
        String mm = (miss % 3600) / 60 > 9 ? (miss % 3600) / 60 + "" : "0" + (miss % 3600) / 60;
        String ss = (miss % 3600) % 60 > 9 ? (miss % 3600) % 60 + "" : "0" + (miss % 3600) % 60;
        return hh + ":" + mm + ":" + ss;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        changeActivity(ReceptionDetailActivity.class);
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }
}
