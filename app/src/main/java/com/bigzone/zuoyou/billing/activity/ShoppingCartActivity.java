package com.bigzone.zuoyou.billing.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.billing.adapter.ShoppingCartAdapter;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.common.MyApp;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemLongClick;

import static com.bigzone.zuoyou.common.Constants.EDIT_PARA;

public class ShoppingCartActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_quantity_total)
    TextView tvQTotal;
    @BindView(R.id.tv_price_total)
    TextView tvPTotal;
    @BindView(R.id.lv_cart)
    ListView lvCart;
    @BindView(R.id.tv_top_right)
    TextView tvClear;
    @BindView(R.id.ll_empty)
    LinearLayout llEmpty;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ShoppingCartAdapter adapter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_shopping_cart;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        MyApp.addActivity(this);
        tv_title.setText("购物车");
        tvClear.setText("清空购物车");
        tvClear.setVisibility(View.VISIBLE);
        for (int i = 0; i < 10; i++) {
            arrayList.add("商品嘿嘿嘿" + (i + 1));
        }
        adapter = new ShoppingCartAdapter(arrayList, this);
        lvCart.setAdapter(adapter);
        lvCart.setEmptyView(llEmpty);
        // TODO: 2017/7/6  网络请求

//        tvQTotal.setText("");
//        tvPTotal.setText("");
    }


    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnClick(R.id.tv_settle)
    void settle() {
        changeActivity(SettleActivity.class);
    }

    @OnClick(R.id.tv_top_right)
    void clear() {
        // TODO: 2017/7/21 真的清楚购物车等接口出来
        arrayList.clear();
        adapter.notifyDataSetChanged();
    }

    @OnItemLongClick(R.id.lv_cart)
    boolean deleteedit(int position) {
        final int position1 = position;
        AlertDialog.Builder builder
                = new AlertDialog.Builder(ShoppingCartActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        //    设置一个下拉的列表选择项
        final String[] chose = new String[2];
        chose[1] = "删除";
        chose[0] = "编辑";
        builder.setItems(chose, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ShoppingCartActivity.this, chose[which], Toast.LENGTH_SHORT).show();
                switch (which) {
                    case 1:
                        arrayList.remove(position1);
                        adapter.notifyDataSetChanged();
                        break;
                    case 0:
                        changeActivityForResult(EditParaActivity.class, EDIT_PARA);
                        break;
                }

            }
        }).show();
        return false;
    }

    @OnClick(R.id.btn_add)
//    购物车没有商品新增
    void addProduct() {
        ToastUtils.testMsg("去购买");
        //没有商品直接去主界面购买
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            MyApp.remove();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == EDIT_PARA) {
            ToastUtils.testMsg("修改参数成功");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
