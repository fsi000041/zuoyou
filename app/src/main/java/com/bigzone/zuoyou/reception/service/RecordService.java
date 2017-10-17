package com.bigzone.zuoyou.reception.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import com.bigzone.zuoyou.utils.CommonUtil;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by haohongwei on 2017/8/4.
 */

public class RecordService extends Service {
    private static String TAG = "RecordService";
    private MediaRecorder recorder;
    private String path;
    public double db = 0;

    public class MyBinder extends Binder {

        public RecordService getService() {
            return RecordService.this;
        }
    }

    //通过binder实现了 调用者（client）与 service之间的通信
    private MyBinder binder = new MyBinder();

    private final Random generator = new Random();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        startRecord(intent.getStringExtra("name"));
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        stopRecord();
        return false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //在Service中暴露出去的方法，供client调用  
    public double getRandomNumber() {
        return db;
    }


    private void stopRecord() {
        if (recorder != null) {
            recorder.stop();
            recorder.release();
            recorder = null;
        }
    }

    private void startRecord(String name) {
        path = CommonUtil.getSDPath() + "/voice/" + name + ".amr";
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(path);
        try {
            recorder.prepare();
            recorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateMicStatus();
    }


    /**
     * 更新话筒状态
     */
    private int BASE = 1;
    private int SPACE = 100;// 间隔取样时间

    private void updateMicStatus() {
        if (recorder != null) {
            double ratio = (double) recorder.getMaxAmplitude() / BASE;
            db = 0;// 分贝
            if (ratio > 1)
                db = 20 * Math.log10(ratio);
            mHandler.postDelayed(mUpdateMicStatusTimer, SPACE);
        }
    }

    private final Handler mHandler = new Handler();
    private Runnable mUpdateMicStatusTimer = new Runnable() {
        public void run() {
            updateMicStatus();
        }
    };

}  



