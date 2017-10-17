package com.bigzone.zuoyou.billing.activity;

import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sszz on 2017/9/25.
 */

public class KeyWordActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.tv_top_right)
    TextView tvTopRight;
    @BindView(R.id.ed_enter)
    EditText edEnter;
    public static final int RESULT_SUCCESS = 0;
    @Override
    protected int bindLayout() {
        return R.layout.activity_key_word;

    }
    @Override
    protected void initView() {
        ButterKnife.bind(this);
        showKeyboard();
        tvTitle.setText("销售开单");
        tvTopRight.setText("确定");
        tvTopRight.setVisibility(View.VISIBLE);
        initData();

    }

    private void showKeyboard(){
      /*  edEnter.requestFocus();
        edEnter.setFocusable(true);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(edEnter, 0);*/
        ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).showSoftInput(edEnter, 0);

    }

    private void initData() {
        String enter = edEnter.getText().toString();
        Intent intent = new Intent();
        if (!enter.isEmpty()){
            intent.putExtra("enter",enter);
            setResult(RESULT_SUCCESS,intent);
        }

    }


    @OnClick({R.id.iv_back, R.id.tv_top_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_top_right:
                initData();
                finish();
                break;
        }
    }

}
