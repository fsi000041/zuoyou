package com.bigzone.zuoyou.main.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.common.Constants;
import com.bigzone.zuoyou.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bigzone.zuoyou.common.Constants.CALL_PERMISSION;

/**
 * Created by haohongwei on 2017/7/18.
 */

public class AboutActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.iv_icon)
    ImageView ivIcon;

    @Override
    protected int bindLayout() {
        return R.layout.activity_about;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("关于");
    }


    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnClick(R.id.tv_telephone)
    void callPhone() {
        //TODO 电话号码先定个不出钱的电话，后面改
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10086"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(
                        new String[]{Manifest.permission.CALL_PHONE},
                        CALL_PERMISSION);
            }
            return;
        }
        startActivity(intent);
    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == Constants.CALL_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                ToastUtils.showShortMsg("权限获取成功");
            } else {
                ToastUtils.showShortMsg("请在设置里面给予权限");
            }
        }

    }
}
