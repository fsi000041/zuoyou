package com.bigzone.zuoyou.billing.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.common.MyApp;
import com.bigzone.zuoyou.utils.DialogUtil;
import com.bigzone.zuoyou.utils.PickDate;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bigzone.zuoyou.common.Constants.EDIT_DISCOUNT;
import static com.bigzone.zuoyou.common.Constants.SELECT_ADDRESS;
import static com.bigzone.zuoyou.common.Constants.SELECT_GUIDER;

public class SettleActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;


    @BindView(R.id.tv_addr_phone)
    TextView tvAddrPhone;

    //地址块
    @BindView(R.id.tv_addr_nopeople)
    TextView tvAddrNopeople;
    @BindView(R.id.rl_addr_have_receiver)
    RelativeLayout rlAddrHaveReveiver;//有地址时显示，没有地址时不显示出来

    @BindView(R.id.tv_addr_receiver)
    TextView tvAddrReceiver;
    @BindView(R.id.tv_addr)
    TextView tvAddr;

    //订单详情
    @BindView(R.id.iv_order_img)
    ImageView ivOrderImg;
    @BindView(R.id.tv_order_detail)
    TextView tvOrderDetail;
    //费用快
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;//商品总额
    @BindView(R.id.tv_total_price_true)
    TextView getTvTotalPriceTrue;//营收总额
    @BindView(R.id.tv_discount)
    TextView tvDiscount;


    @BindView(R.id.tv_guider)
    TextView tvGuider;
    //
    @BindView(R.id.tv_method_get)
    TextView tvMethodGet;
    @BindView(R.id.tv_date)
    TextView tvDate;


    private ArrayList<String> arrayListMethodGet = new ArrayList<String>();
    private ArrayList<String> arrayListGuider = new ArrayList<>();

    @Override
    protected int bindLayout() {
        return R.layout.activity_settle;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        MyApp.addActivity(this);
        tv_title.setText("结算");

        rlAddrHaveReveiver.setVisibility(View.GONE);
        for (int i = 0; i < 5; i++) {
            arrayListMethodGet.add("请选择" + (i + 1) + "号男嘉宾");
        }
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnClick(R.id.rl_select_address)
    void selectAddr() {
        changeActivityForResult(AddressSelectActivity.class, SELECT_ADDRESS);
    }

    @OnClick(R.id.rl_guider)
    void selectGuider() {
        final String[] names = arrayListMethodGet.toArray(new String[arrayListMethodGet.size()]);
        DialogUtil.setSingleItemDialog(this, "请选择导购员", names, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvGuider.setText(names[which]);
                dialog.dismiss();
            }
        });
    }

    @OnClick(R.id.tv_settle)
    void settle() {
        ToastUtils.showShortMsg("提交了订单");
        MyApp.clearActivity();
        changeActivity(SalesSuccessActivity.class);
    }

    @OnClick(R.id.rl_discount)
    void feeEdit() {
        changeActivityForResult(FeeSettleActivity.class, EDIT_DISCOUNT);
    }

    @OnClick(R.id.rl_method_get)
    void getMethod() {
        final String[] names = arrayListMethodGet.toArray(new String[arrayListMethodGet.size()]);
        DialogUtil.setSingleItemDialog(this, "请选择提货方式", names, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvMethodGet.setText(names[which]);
                dialog.dismiss();
            }
        });
    }

    @OnClick(R.id.rl_date)
    void getDate() {
        PickDate.chooseDate(this, tvDate);
        ToastUtils.showShortMsg("选择日期");
    }

    @OnClick(R.id.rl_order_detail)
    void orderDetail() {
        ToastUtils.showShortMsg("查看商品详情");
        changeActivity(ProductListActivity.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_ADDRESS) {
                rlAddrHaveReveiver.setVisibility(View.VISIBLE);
                tvAddrNopeople.setVisibility(View.INVISIBLE);
                tvAddr.setText(data.getStringExtra("address"));
                ToastUtils.showShortMsg("选择地址成功");
            }
            if (requestCode == SELECT_GUIDER) {
                tvGuider.setText(data.getStringExtra("guider"));
            }
            if (requestCode == EDIT_DISCOUNT) {
                ToastUtils.showShortMsg("修改费用成功");
//                tvDiscount.setText("");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            MyApp.remove();
        }
        return super.onKeyDown(keyCode, event);
    }
}
