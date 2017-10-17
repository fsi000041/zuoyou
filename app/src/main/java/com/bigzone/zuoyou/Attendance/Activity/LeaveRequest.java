package com.bigzone.zuoyou.Attendance.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.Attendance.Activity.Adapter.GoodsCategory;
import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.PhotoUtils;
import com.bigzone.zuoyou.utils.ToastUtils;
import com.bigzone.zuoyou.view.CircleImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DateTimePicker;
import cn.qqtheme.framework.picker.SinglePicker;

public class LeaveRequest extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
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
    @BindView(R.id.tv_apply_for)
    TextView tvApplyFor;
    @BindView(R.id.tv_apply_for_time)
    TextView tvApplyForTime;
    @BindView(R.id.tv_department)
    TextView tvDepartment;
    @BindView(R.id.rl_add_attachment)
    RelativeLayout rlAddAttachment;
    @BindView(R.id.rl_sumbit_leave)
    Button rlSumbitLeave;
    @BindView(R.id.xcr_iv)
    CircleImageView xrcIv;
    @BindView(R.id.rl_liucheng)
    RelativeLayout rlLiuCheng;

    @BindView(R.id.iv_arrow)
    ImageView ivArrow;
    @BindView(R.id.tv_leave)
    TextView tvLeave;
    @BindView(R.id.rl_leave)
    RelativeLayout rlLeave;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.rl_start_time)
    RelativeLayout rlStartTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.rl_end_time)
    RelativeLayout rlEndTime;
    private File tempFile;
    private static final int PHOTO_REQUEST_CUT = 3;// 结果
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private static final String PHOTO_FILE_NAME = "temp_photo.jpg";
    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri imageUri;
    private Uri cropImageUri;
    private String leixing;
    private String startTime;
    private String endtTime;

    @Override
    protected int bindLayout() {
        return R.layout.activity_leave_request;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("请假申请");
       /* tvTopRight.setText("新增");
        tvTopRight.setVisibility(View.VISIBLE);*/

    }

    //单项假期类型选择器
    public void onSinglePicker() {
        List<GoodsCategory> data = new ArrayList<>();
        data.add(new GoodsCategory(1, "事价"));
        data.add(new GoodsCategory(2, "丧家  "));
        data.add(new GoodsCategory(3, "休假"));
        data.add(new GoodsCategory(4, "病假"));
        SinglePicker<GoodsCategory> picker = new SinglePicker<>(this, data);
        picker.setCanceledOnTouchOutside(false);
        picker.setSelectedIndex(0);
        picker.setDividerVisible(false);
        picker.setTextColor(Color.BLACK);

        // picker.setCycleDisable(false);
        picker.setOnItemPickListener(new SinglePicker.OnItemPickListener<GoodsCategory>() {
            @Override
            public void onItemPicked(int index, GoodsCategory item) {
                leixing = item.getName().toString();
                tvLeave.setText(leixing);
                ToastUtils.showShortMsg("index=" + index + ", id=" + item.getId() + ", name=" + item.getName());
            }
        });
        picker.show();
    }

    //开始时间选择器
    public void onStartYearMonthDayTimePicker() {
        DateTimePicker picker = new DateTimePicker(this, DateTimePicker.HOUR_24);
        picker.setDateRangeStart(2017, 1, 1);
        picker.setDateRangeEnd(2025, 11, 11);
        picker.setTimeRangeStart(9, 0);
        picker.setTimeRangeEnd(20, 30);
        picker.setTopLineColor(0x99FF0000);
        picker.setLabelTextColor(0xFFFF0000);
        picker.setDividerColor(0xFFFF0000);
        picker.setDividerVisible(false);
        picker.setTextColor(Color.BLACK);
        picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
            @Override
            public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                startTime = year + "-" + month + "-" + day + " " + hour + ":" + minute;
                ToastUtils.showShortMsg(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                tvStartTime.setText(startTime);
            }
        });
        picker.show();
    }

    //结束时间选择器
    public void onEndYearMonthDayTimePicker() {
        DateTimePicker picker = new DateTimePicker(this, DateTimePicker.HOUR_24);
        picker.setDateRangeStart(2017, 1, 1);
        picker.setDateRangeEnd(2025, 11, 11);
        picker.setTimeRangeStart(9, 0);
        picker.setTimeRangeEnd(20, 30);
        picker.setTopLineColor(0x99FF0000);
        picker.setLabelTextColor(0xFFFF0000);
        picker.setDividerColor(0xFFFF0000);
        picker.setTextColor(Color.BLACK);
        picker.setDividerVisible(false);
        picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
            @Override
            public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                endtTime = year + "-" + month + "-" + day + " " + hour + ":" + minute;
                ToastUtils.showShortMsg(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                tvEndTime.setText(endtTime);
            }
        });
        picker.show();
    }

    @OnClick({R.id.iv_back, R.id.rl_liucheng, R.id.rl_add_attachment, R.id.tv_leave,R.id.rl_end_time, R.id.rl_leave,R.id.rl_start_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_liucheng:
                changeActivity(ApprovalProcessActivity.class);
                break;
            case R.id.rl_add_attachment:
                submitIcon();
                break;
            case R.id.rl_leave:
                onSinglePicker();
                break;
            case R.id.rl_start_time:
                onStartYearMonthDayTimePicker();
                break;
            case R.id.rl_end_time:
                onEndYearMonthDayTimePicker();
        }

    }


    /*
    * 判断sdcard是否被挂载
    */
    private boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    private int output_X = 480;
    private int output_Y = 480;

    //修改图像
    private void submitIcon() {
        //点击弹出选择拍照或者从相册选
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] Items = {"从相册选取", "拍照"};
        builder.setItems(Items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case CHOOSE_PICTURE: // 选择本地照片
                        autoObtainStoragePermission();
                        break;
                    case TAKE_PICTURE: // 拍照
                        autoObtainCameraPermission();

                }
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    //自动获取相机权限

    /**
     * 自动获取相机权限
     */
    private void autoObtainCameraPermission() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ToastUtils.showShortMsg("您已经拒绝过一次");
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_PERMISSIONS_REQUEST_CODE);
        } else {//有权限直接调用系统相机拍照
            if (hasSdcard()) {
                imageUri = Uri.fromFile(fileUri);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                    imageUri = FileProvider.getUriForFile(LeaveRequest.this, "com.bigzone.zuoyou.fileprovider", fileUri);//通过FileProvider创建一个content类型的Uri
                PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
            } else {
                ToastUtils.showShortMsg("设备没有SD卡！");
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case CAMERA_PERMISSIONS_REQUEST_CODE: {//调用系统相机申请拍照权限回调
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (hasSdcard()) {
                        Uri imageUri = Uri.fromFile(fileUri);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                            imageUri = FileProvider.getUriForFile(this, "com.bigzone.zuoyou.fileProvider", fileUri);//通过FileProvider创建一个content类型的Uri
                        PhotoUtils.takePicture(this, imageUri, TAKE_PICTURE);
                    } else {
                        ToastUtils.showShortMsg("设备没有SD卡！");
                    }
                } else {

                    ToastUtils.showShortMsg("请允许打开相机！！");
                }
                break;


            }
            case STORAGE_PERMISSIONS_REQUEST_CODE://调用系统相册申请Sdcard权限回调
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    PhotoUtils.openPic(this, CHOOSE_PICTURE);
                } else {
                    ToastUtils.showShortMsg("请允许打操作SDCard！！");
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CODE_CAMERA_REQUEST://拍照完成回调
                    cropImageUri = Uri.fromFile(fileCropUri);
                    PhotoUtils.cropImageUri(this, imageUri, cropImageUri, 1, 1, output_X, output_Y, CODE_RESULT_REQUEST);
                    break;
                case CODE_GALLERY_REQUEST://访问相册完成回调
                    if (hasSdcard()) {
                        cropImageUri = Uri.fromFile(fileCropUri);
                        Uri newUri = Uri.parse(PhotoUtils.getPath(this, data.getData()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                            newUri = FileProvider.getUriForFile(this, "com.bigzone.zuoyou.fileprovider", new File(newUri.getPath()));
                        PhotoUtils.cropImageUri(this, newUri, cropImageUri, 1, 1, output_X, output_Y, CODE_RESULT_REQUEST);
                    } else {
                        ToastUtils.showShortMsg("设备没有SD卡！");
                    }
                    break;
                case CODE_RESULT_REQUEST:
                    Bitmap bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, this);
                    if (bitmap != null) {
                        showImages(bitmap);
                    }
                    break;
            }
        }
    }

    private void autoObtainStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
        } else {
            PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
        }

    }

    private void showImages(Bitmap bitmap) {
        xrcIv.setImageBitmap(bitmap);
    }


}
