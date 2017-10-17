package com.bigzone.zuoyou.billing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.Logger;
import com.bigzone.zuoyou.utils.SharedPreferenceHelper;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

import static com.bigzone.zuoyou.R.id.tv_select4;

public class SalesOrderActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.tv_select)
    TextView tvSelect;
    @BindView(R.id.rl_mendian)
    RelativeLayout rlMendian;
    @BindView(R.id.tv_select1)
    TextView tvSelect1;
    @BindView(R.id.rl_kuanshi)
    RelativeLayout rlKuanshi;
    @BindView(R.id.tv_select2)
    TextView tvSelect2;
    @BindView(R.id.rl_fenlei)
    RelativeLayout rlFenlei;
    @BindView(R.id.tv_select3)
    TextView tvSelect3;
    @BindView(R.id.rl_fenbu)
    RelativeLayout rlFenbu;
    @BindView(tv_select4)
    TextView tvSelect4;
    @BindView(R.id.rl_guanjian)
    RelativeLayout rlGuanjian;
    public static final int CODE = 1;
    @BindView(R.id.rl_sumbit_leave)
    Button rlSumbitLeave;
    @BindView(R.id.tv_top_right)
    TextView tvTopRight;
    @BindView(R.id.iv_top_right)
    ImageView ivTopRight;
    private static String TAG = "Test";
    @Override
    protected int bindLayout() {
        return R.layout.activity_sales_order;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("销售开单");
        ivTopRight.setImageResource(R.drawable.right_scan);
        ivTopRight.setVisibility(View.VISIBLE);
    }


    @OnClick({R.id.iv_top_right, R.id.iv_back, R.id.rl_mendian, R.id.rl_kuanshi, R.id.rl_fenlei, R.id.rl_fenbu, R.id.rl_guanjian, R.id.rl_sumbit_leave})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_top_right:
                changeActivity(ScanActivity.class);
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_mendian:
                changeActivity(SelectStoresActivity.class);
                break;
            case R.id.rl_kuanshi:
                init();
                break;
            case R.id.rl_fenlei:
                changeActivity(ClassificationActivity.class);
                break;
            case R.id.rl_fenbu:
                changeActivity(FabriNameActivity.class);
                break;
            case R.id.rl_guanjian:
                changeActivityForResult(KeyWordActivity.class, CODE);
                break;
            case R.id.rl_sumbit_leave:
                changeActivity(ProductListActivity.class);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == KeyWordActivity.RESULT_SUCCESS && data != null) {
            Bundle extras = data.getExtras();
            String s = extras.getString("enter");
            tvSelect4.setText("" + s);
        }
    }

    private void init() {
        String userport = SharedPreferenceHelper.getUserport();
        OkGo.get("http://118.190.84.158:9191/zuoyou/v1/api/sal/salesorder/getPay")
                .tag(this)                       // 请求的 tag, 主要用于取消对应的请求
                .cacheKey("cacheKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
                .cacheMode(CacheMode.DEFAULT)
                .params("sessionToken",userport)
                .params("version","1233")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Logger.d("123", s);
                    }
                });
    }
}
