package com.bigzone.zuoyou.billing.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.utils.PhotoUtils;
import com.bigzone.zuoyou.utils.ToastUtils;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.android.AutoScannerView;
import com.google.zxing.client.android.BaseCaptureActivity;
import com.google.zxing.common.HybridBinarizer;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.darsh.multipleimageselect.helpers.Constants.REQUEST_CODE;

/**
 * Created by sszz on 2017/9/27.
 */

public class ScanActivity extends BaseCaptureActivity {

    private static final int SELECT_PHOTOS = 000001;
    @BindView(R.id.bt_light)
    ImageButton btLight;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.iv_top_right)
    ImageView ivTopRight;
    @BindView(R.id.preview_view)
    SurfaceView previewView;
    @BindView(R.id.autoscanner_view)
    AutoScannerView autoscannerView;
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.tv_xiangce)
    TextView tvXiangce;
    private boolean isOpen = true;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        autoscannerView.setCameraManager(cameraManager);
    }

    @Override
    public SurfaceView getSurfaceView() {
        return (previewView == null) ? (SurfaceView) findViewById(R.id.preview_view) : previewView;
    }

    @Override
    public void dealDecode(Result rawResult, Bitmap barcode, float scaleFactor) {
        ToastUtils.showShortMsg(rawResult.getText().toString());
        if (rawResult != null) {
            startActivity(new Intent(this, ProductDetailActivity.class));
        } else {
            reScan();
        }
    }

    @OnClick({R.id.bt_light, R.id.iv_back, R.id.iv_top_right, R.id.tv_back,R.id.tv_xiangce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_light:
                if (!isOpen) {
                    cameraManager.openLight();
                    btLight.setBackgroundResource(R.drawable.light_open);
                    isOpen = true;
                } else {
                    cameraManager.offLight();
                    btLight.setBackgroundResource(R.drawable.light_off);
                    isOpen = false;
                }
                break;
            case R.id.iv_back:
                break;
            case R.id.iv_top_right:
                break;
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_xiangce:
                photo();
        }
    }

    private void photo() {
        // 激活系统图库，选择一张图片
        Intent innerIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        Intent wrapperIntent = Intent.createChooser(innerIntent, "选择二维码图片");
        startActivityForResult(wrapperIntent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri sourceUri = null;
        if(data != null) {
            switch (requestCode) {
                case REQUEST_CODE:

                    // 首先获取到此图片的Uri
                    sourceUri = data.getData();

                    try {
                        // 下面这句话可以通过URi获取到文件的bitmap
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), sourceUri);

                        // 在这里我用到的 getSmallerBitmap 非常重要，下面就要说到
                        bitmap = PhotoUtils.getSmallerBitmap(bitmap);

                        // 获取bitmap的宽高，像素矩阵
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        int[] pixels = new int[width * height];
                        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

                        // 最新的库中，RGBLuminanceSource 的构造器参数不只是bitmap了
                        RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);
                        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));
                        Reader reader = new MultiFormatReader();
                        Result result = null;


                        // 尝试解析此bitmap，！！注意！！ 这个部分一定写到外层的try之中，因为只有在bitmap获取到之后才能解析。写外部可能会有异步的问题。（开始解析时bitmap为空）
                        try {
                            result = reader.decode(binaryBitmap);
                            Intent intent = new Intent(ScanActivity.this, ProductDetailActivity.class);
                            intent.putExtra("qrcode", result.getText());
                            startActivity(intent);
                            finish();
                        } catch (NotFoundException e) {
                            //Log.i(TAG, "onActivityResult: notFind");
                            e.printStackTrace();
                        } catch (ChecksumException e) {
                            e.printStackTrace();
                        } catch (FormatException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

        }else {
            finish();
        }

    }
}
