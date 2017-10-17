package com.bigzone.zuoyou.main.activity;

import android.webkit.WebView;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/6.
 */

public class NoticeActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.webView)
    WebView mWebView;

    @Override
    protected int bindLayout() {
        return R.layout.activity_notice;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);



        tv_title.setText("公告");
        initWebView();
    }


    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    /**
     * 加载网页数据
     */
    private void initWebView() {
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setAppCacheMaxSize(1024 * 1024 * 8);
        String appCachePath = getApplicationContext().getCacheDir().getAbsolutePath();
        mWebView.getSettings().setAppCachePath(appCachePath);
        mWebView.getSettings().setAllowFileAccess(true);
        mWebView.getSettings().setAppCacheEnabled(true);
    }
}
