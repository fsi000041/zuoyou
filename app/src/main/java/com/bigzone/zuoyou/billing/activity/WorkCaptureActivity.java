/*
package com.bigzone.zuoyou.billing.activity;
import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.utils.ImageUtil;
import com.bigzone.zuoyou.utils.ToastUtils;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;


*/
/**
 * Initial the camera
 * <p>
 * 默认的二维码扫描Activity
 *//*

public class WorkCaptureActivity extends AppCompatActivity implements  ActivityCompat.OnRequestPermissionsResultCallback{

    private int REQUEST_IMAGE = 1;
    private CaptureFragment captureFragment;

    */
/*public LocationClient mlocationClient = null;
    private BDLocationListener myListener;*//*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        if (isNeedCheck) {
            checkPermissions(needPermissions);
        }
        */
/*myListener = new MyLocationListener();
        //声明LocationClient类
        mlocationClient = new LocationClient(this);     //声明LocationClient类
        mlocationClient.registerLocationListener(myListener);    //注册监听函数
        BaiDuSet.initLocation(mlocationClient);
        //开启定位
//        startPermissionsActivity();
        mlocationClient.start();*//*


        captureFragment = new CaptureFragment();
        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_zxing_container, captureFragment).commit();

        onInitListener();

        Log.i("BaiduLocationApiDem", "onCreate: "+111111);
    }

    private void onInitListener() {
       */
/* captureFragment.setOnNoSendClickListener(new CaptureFragment.OnNoSendClickListener() {
            @Override
            public void onNoSendClick() {
                Intent intent = new Intent(WorkCaptureActivity.this, NoSendActivity.class);
                startActivity(intent);
            }
        });*//*

        captureFragment.setOnOKSendClickListener(new CaptureFragment.OnOKSendClickListener() {
            @Override
            public void onOkSendClick() {
                ToastUtils.showShortMsg("发货");
            }
        });
        captureFragment.setOnCamerSendClickListener(new CaptureFragment.OnCamerSendClickListener() {
            @Override
            public void onCamerSendClick() {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image*/
/*");
                startActivityForResult(intent, REQUEST_IMAGE);


            }
        });
    }


    */
/**
     * 二维码解析回调函数
     *//*

    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            if(result.equals("已扫过")){
                captureFragment.setAlreadyRL();
            }  else if (result.equals("扫码成功")){
                captureFragment.setSucessRL();
            }else {
                //二维码不存在
                showLoginDialog();
            }

            Toast.makeText( WorkCaptureActivity.this, result, Toast.LENGTH_SHORT).show();

            //二次扫码
            captureFragment.restartCamera( );
        }

        @Override
        public void onAnalyzeFailed() {
            Toast.makeText(WorkCaptureActivity.this, "扫描二维码失败", Toast.LENGTH_SHORT).show();
        }
    };



    public void showLoginDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(WorkCaptureActivity.this, R.style.dialog);
        final Dialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();

        Window window = dialog.getWindow();
        window.setContentView(R.layout.dialog_login);

        TextView tv_cancel = (TextView) window.findViewById(R.id.tv_cancle);


        */
/**
         * 关闭dialog
         *//*

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
   */
/* *//*
*/
/**
     * 实现实位回调监听
     *//*
*/
/*
    public class MyLocationListener implements BDLocationListener {

        public void onReceiveLocation(BDLocation location) {
            //Receive Location
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());//获得当前时间
            sb.append("\nerror code : ");
            sb.append(location.getLocType());//获得erro code得知定位现状
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());//获得纬度
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());//获得经度
            sb.append("\nradius : ");
            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation) {//通过GPS定位
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());//获得速度
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
                sb.append("\ndirection : ");
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());//获得当前地址
                sb.append(location.getDirection());//获得方位
            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {//通过网络连接定位
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());//获得当前地址
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());//获得经营商？
            }
            Log.i("BaiduLocationApiDem", sb.toString()+"`````"+ location.getLocType());

        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(mlocationClient != null && !mlocationClient.isStarted()){
            mlocationClient.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mlocationClient != null && mlocationClient.isStarted()){
            mlocationClient.stop();
        }
    }*//*

    */
/**
     * 需要进行检测的权限数组
     *//*

    protected String[] needPermissions = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE
    };

    private static final int PERMISSON_REQUESTCODE = 0;
    private static final int SETTING_REQUESTCODE = 1;

    */
/**
     * 判断是否需要检测，防止不停的弹框
     *//*

    private boolean isNeedCheck = true;
    @Override
    protected void onResume() {
        super.onResume();
        if (isNeedCheck) {
            checkPermissions(needPermissions);
        }
    }
    */
/**
     * @param permissions
     * @since 2.5.0
     *//*

    private void checkPermissions(String... permissions) {
        List<String> needRequestPermissonList = findDeniedPermissions(permissions);
        if (null != needRequestPermissonList
                && needRequestPermissonList.size() > 0) {
            ActivityCompat.requestPermissions(this,
                    needRequestPermissonList.toArray(
                            new String[needRequestPermissonList.size()]),
                    PERMISSON_REQUESTCODE);
        }
    }
    */
/**
     * 获取权限集中需要申请权限的列表
     *
     * @param permissions
     * @return
     * @since 2.5.0
     *//*

    private List<String> findDeniedPermissions(String[] permissions) {
        List<String> needRequestPermissonList = new ArrayList<String>();
        for (String perm : permissions) {
            if (ContextCompat.checkSelfPermission(this,
                    perm) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.shouldShowRequestPermissionRationale(
                    this, perm)) {
                needRequestPermissonList.add(perm);
            }
        }
        return needRequestPermissonList;
    }

    */
/**
     * 检测是否说有的权限都已经授权
     *
     * @param grantResults
     * @return
     * @since 2.5.0
     *//*

    private boolean verifyPermissions(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] paramArrayOfInt) {
        if (requestCode == PERMISSON_REQUESTCODE) {
            if (!verifyPermissions(paramArrayOfInt)) {
               */
/* showMissingPermissionDialog();*//*

                isNeedCheck = false;
            }
        }
    }

    */
/**
     * 显示提示信息
     *
     * @since 2.5.0
     *//*

  */
/*  private void showMissingPermissionDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle(R.string.notifyTitle);
//        builder.setMessage(R.string.notifyMsg);
//
//        // 拒绝, 退出应用
//        builder.setNegativeButton(R.string.cancel,
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
//                    }
//                });
//
//        builder.setPositiveButton(R.string.setting,
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        startAppSettings();
//                    }
//                });
/*/
/*//*
*/
/**//*
*/
/*
//        builder.setCancelable(false);
//
//        builder.show();
        AlertDialog.Builder builder = new AlertDialog.Builder(WorkCaptureActivity.this, R.style.dialog);
        final Dialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
        Window window = dialog.getWindow();
        window.setContentView(R.layout.dialog_set);
        TextView tv_cancel = (TextView) window.findViewById(R.id.tv_cancle);
        TextView tvSet = (TextView) window.findViewById(R.id.tv_login);

        tvSet.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                // 转到手机设置界面，用户设置GPS
//                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                startActivityForResult(intent, 0); // 设置完成后返回到原来的界面
                startAppSettings();
            }
        });
        *//*
*/
/**
         * 关闭dialog
         *//*
*/
/*

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }*//*


    */
/**
     * 启动应用的设置
     *
     * @since 2.5.0
     *//*

    private void startAppSettings() {
        Intent intent = new Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, SETTING_REQUESTCODE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //从相册选取二维码图片
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SETTING_REQUESTCODE) {
            checkPermissions(needPermissions);
        }
        if (requestCode == REQUEST_IMAGE) {
            if (data != null) {
                Uri uri = data.getData();
                try {
                    CodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(this, uri), new CodeUtils.AnalyzeCallback() {
                        @Override
                        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                            //Toast.makeText(MainActivity.this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                            ToastUtils.showShortMsg(result);

                        }

                        @Override
                        public void onAnalyzeFailed() {
                            //Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
*/
