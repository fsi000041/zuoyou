package com.bigzone.zuoyou.login.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.internet.MyRetrofitUtil;
import com.bigzone.zuoyou.internet.RxSchedulersHelper;
import com.bigzone.zuoyou.login.bean.LoginBean;
import com.bigzone.zuoyou.utils.Logger;
import com.bigzone.zuoyou.utils.SharedPreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;

/**
 * Created by haohongwei on 2017/7/17.
 */

public class LoginActivity extends BaseActivity {
    private static String TAG = "LoginActivity";
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.et_code)
    EditText et_code;
    @BindView(R.id.et_name)
    EditText et_name;
    @BindView(R.id.et_pwd)
    EditText et_pwd;

    @Override
    protected int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_login)
    void login() {
        MyRetrofitUtil.getInstance()
                .delBackMoney("zytest", "admin", "21232f297a57a5a743894a0e4a801fc3")
                .compose(RxSchedulersHelper.<LoginBean>io_main())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        String sessiontoken = loginBean.getRpdata().getSessiontoken();
                        SharedPreferenceHelper.setUserport(sessiontoken);
                        Logger.d(TAG,sessiontoken);


                    }
                });

//        changeActivity(MainActvity.class);
//        finish();
    }

}
