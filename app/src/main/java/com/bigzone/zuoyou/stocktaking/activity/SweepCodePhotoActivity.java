package com.bigzone.zuoyou.stocktaking.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.stocktaking.activity.adapter.GoodsAdapter;
import com.bigzone.zuoyou.stocktaking.activity.bean.GoodsBean;
import com.bigzone.zuoyou.utils.ToastUtils;
import com.google.zxing.Result;
import com.google.zxing.client.android.AutoScannerView;
import com.google.zxing.client.android.BaseCaptureActivity;

import java.util.ArrayList;
import java.util.List;




public class SweepCodePhotoActivity extends BaseCaptureActivity implements View.OnClickListener {

    private static final String TAG = SweepCodePhotoActivity.class.getSimpleName();
    private SurfaceView surfaceView;
    private AutoScannerView autoScannerView;
    private RelativeLayout rl_cancal;
    private RelativeLayout rl_join;
    private RelativeLayout rl_huwei;
    private ListView lv;
    private List<GoodsBean> list = new ArrayList<>();
    private GoodsAdapter adapter = new GoodsAdapter(list,this);
    private TextView tv_chose;
    private Window window;
    private Window window1;
    private Dialog dialog;
    private Dialog dialog1;
    private ListView listViewv;
    private View view;
    private Boolean isOpen = true;
    private ImageButton cl_light1;
    private RelativeLayout top;
    private String s;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweep_code);
        initView();
        initViewHuowei();

    }

    @Override
    public void dealDecode(Result rawResult, Bitmap barcode, float scaleFactor) {
        if (rawResult != null) {
            s = rawResult.getText().toString();
            dialogShow();
            ToastUtils.showShortMsg(s);


        }else {
            //重新扫描
            reScan();
        }

    }
    private void initView() {
        surfaceView = (SurfaceView) findViewById(R.id.preview_view);
        autoScannerView = (AutoScannerView) findViewById(R.id.autoscanner_view);
        top = (RelativeLayout) findViewById(R.id.rl_top);
        top.getBackground().setAlpha(100);
        cl_light1 = (ImageButton) findViewById(R.id.bt_light);


    }
    private void initViewHuowei() {
        View view1 = LayoutInflater.from(this).inflate(R.layout.item_photo_huowei,null);
        rl_cancal = (RelativeLayout) view1.findViewById(R.id.rl_cancal);
        rl_join = (RelativeLayout) view1.findViewById(R.id.rl_join);
        lv = (ListView) view1.findViewById(R.id.lv);
        for (int i = 1; i < 50 ; i++) {
            list.add(new GoodsBean("货位号: " + i));
        }
        lv.setAdapter(adapter);
        dialog1 = new Dialog(this, R.style.Dialog_Fullscreen );
        window1 = dialog1.getWindow();
        window1.getDecorView().setPadding(0, 0, 0, 0); //消除边距
        WindowManager.LayoutParams pp = window1.getAttributes();
        pp.width = WindowManager.LayoutParams.MATCH_PARENT;   //设置宽度充满屏幕
        pp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window1.setAttributes(pp);
        window1.setGravity(Gravity.BOTTOM);
        dialog1.setContentView(view1);
        dialog1.setCanceledOnTouchOutside(false);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog1.dismiss();
                dialog.show();
                tv_chose.setText(position+ "");
            }
        });
    }

    private void dialogShow() {
        tv_chose = (TextView) view.findViewById(R.id.tv_chose);
        rl_cancal = (RelativeLayout) view.findViewById(R.id.rl_cancal);
        rl_join = (RelativeLayout) view.findViewById(R.id.rl_join);
        rl_huwei = (RelativeLayout) view.findViewById(R.id.rl_huowei);
        listViewv = (ListView) view.findViewById(R.id.listView);
        rl_cancal.setOnClickListener(this);
        rl_join.setOnClickListener(this);
        cl_light1.setOnClickListener(this);
        rl_huwei.setOnClickListener(this);
        list.add(new GoodsBean("货位号：" + s ));
        listViewv.setAdapter(adapter);
        view = LayoutInflater.from(this).inflate(R.layout.item_dialog_photo,null);
        dialog = new Dialog(this,R.style.Dialog_Fullscreen);
        window = dialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0); //消除边距
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;   //设置宽度充满屏幕
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        window.setGravity(Gravity.BOTTOM);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }



    @Override
    protected void onResume() {
        super.onResume();
        autoScannerView.setCameraManager(cameraManager);
    }

    @Override
    public SurfaceView getSurfaceView() {
        return (surfaceView == null) ? (SurfaceView) findViewById(R.id.preview_view) : surfaceView;
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            reScan();
        }

        return super.onKeyDown(keyCode, event);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_cancal:
                dialog.dismiss();
                //重新开启扫描
                ToastUtils.showShortMsg("请继续扫描");
                reScan();
                break;

            case R.id.rl_join:
                Intent intent = new Intent(this,NewStocktakingActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_light:
                //闪光灯判断
                if (!isOpen){
                    cameraManager.openLight();
                    cl_light1.setBackgroundResource(R.drawable.light_open);
                    isOpen = true;
                }else {
                    cameraManager.offLight();
                    cl_light1.setBackgroundResource(R.drawable.light_off);
                    isOpen = false;
                }
                    break;

            case R.id.rl_huowei:
                ToastUtils.showShortMsg("点击了");
                dialog.dismiss();
                dialog1.show();
        }
    }
}
