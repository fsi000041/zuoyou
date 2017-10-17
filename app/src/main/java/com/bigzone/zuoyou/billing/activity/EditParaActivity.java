package com.bigzone.zuoyou.billing.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.DialogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

import static com.bigzone.zuoyou.utils.ToastUtils.testMsg;


public class EditParaActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_material)
    TextView tvMaterial;
    @BindView(R.id.tv_total_material)
    TextView tvTotalMaterial;
    @BindView(R.id.tv_color_foot)
    TextView tvColorFoot;
    @BindView(R.id.tv_tax)
    TextView tvTax;
    @BindView(R.id.tv_rfe)
    TextView tvRfe;
    @BindView(R.id.rl_rfe)
    RelativeLayout rlRfe;

    private ArrayList<String> arrayListMaterial = new ArrayList<>();
    private ArrayList<String> arrayListTotalMaterial = new ArrayList<>();
    private ArrayList<String> arrayListColorFoot = new ArrayList<>();
    private ArrayList<String> arrayListTax = new ArrayList<>();

    @Override
    protected int bindLayout() {
        return R.layout.activity_edit_para;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tvTitle.setText("修改参数");
        for (int i = 0; i < 5; i++) {
            arrayListMaterial.add("选择嘿嘿嘿" + (i + 1));
        }
    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @OnClick(R.id.rl_material)
        //选择沙发材质
    void selectMaterial() {
        testMsg("选择材质");
        final String[] names = arrayListMaterial.toArray(new String[arrayListMaterial.size()]);
        DialogUtil.setSingleItemDialog(this, "选择材质", names, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvMaterial.setText(names[which]);
                dialog.dismiss();
            }
        });
    }

    @OnClick(R.id.rl_total_material)
        //选择整体面料
    void selectTotalMaterial() {
        testMsg("选择整体面料");
        final String[] names = arrayListMaterial.toArray(new String[arrayListMaterial.size()]);
        DialogUtil.setSingleItemDialog(this, "选择整体面料", names, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvTotalMaterial.setText(names[which]);
                dialog.dismiss();
            }
        });
    }

    @OnClick(R.id.rl_color_foot)
        //选择沙发脚颜色
    void selectColorFoot() {
        testMsg("选择沙发脚颜色");
        final String[] names = arrayListMaterial.toArray(new String[arrayListMaterial.size()]);
        DialogUtil.setSingleItemDialog(this, "选择沙发脚颜色", names, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvColorFoot.setText(names[which]);
                dialog.dismiss();
            }
        });
    }

    @OnClick(R.id.rl_tax)
        //选择税种
    void selectTax() {
        testMsg("选择税种");
        final String[] names = arrayListMaterial.toArray(new String[arrayListMaterial.size()]);
        DialogUtil.setSingleItemDialog(this, "选择税种", names, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvTax.setText(names[which]);
                dialog.dismiss();
            }
        });
    }

    @OnClick(R.id.rl_rfe)
    void selectRfe() {
        testMsg("选择补件");
        final String[] names = arrayListMaterial.toArray(new String[arrayListMaterial.size()]);
        DialogUtil.setSingleItemDialog(this, "选择补件", names, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvRfe.setText(names[which]);
                dialog.dismiss();
            }
        });
    }

    @OnClick(R.id.tv_ensure)
    void ensure() {
        new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert)
                .setTitle("确认修改？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditParaActivity.this.setResult(RESULT_OK);
                        finish();
                        // TODO: 2017/7/21  保存更改网络请求
                    }
                })
                .setNegativeButton("取消", null).show();

    }

    @OnCheckedChanged(R.id.checkbox)
    void isSelectRfe(boolean checked) {
        if (checked) {
            testMsg("选择补件");
            rlRfe.setVisibility(View.VISIBLE);
        } else {
            testMsg("不要补件");
            rlRfe.setVisibility(View.GONE);
        }

    }
}
