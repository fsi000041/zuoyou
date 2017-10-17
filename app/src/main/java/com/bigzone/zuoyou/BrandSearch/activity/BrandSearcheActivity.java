package com.bigzone.zuoyou.BrandSearch.activity;

import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.SharedPreferenceHelper;

/**
 * Created by sszz on 2017/10/13.
 */

public class BrandSearcheActivity extends BaseActivity {
    private WebView wb_goods;
    private String url11;
    private String url2;

    @Override
    protected int bindLayout() {
        return R.layout.activity_goods_search;
    }

    @Override
    protected void initView() {
        String userip = SharedPreferenceHelper.getUserip();
        String url = "http://118.190.84.158:9191/zuoyou/client/index.html#/app/brand/list \n";
        url11 = url+userip;
        url2 = "http://118.190.84.158:9191/zuoyou/client/index.html#/app/product/list?dealerid=zytest&dealername=%E5%B9%BF%E4%B8%9C%E7%9C%81%E6%B7%B1%E5%9C%B3%E5%B8%82%E5%B7%A6%E5%8F%B3%E5%AE%B6%E4%B9%88%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&lasttime=1507792375217&limitstore=0&loginstorecode=005&loginstorename=%E4%BC%98%E5%AE%B6%E5%AE%B6%E5%85%B7&loginstoreaddress=&loginstorememo=&longintime=1507792375217&password=&phone=15367043240&sessiontoken=9AAC00CAEB799CDD1A6BC089E322A210&status=Y&staffname=%E5%BC%A0%E9%BB%98&staffno=0101&storecode=005&storename=%E4%BC%98%E5%AE%B6%E5%AE%B6%E5%85%B7&sysPath=%2Fv1%2Fapi&updatetime=2017-09-18%2016:51:39&updateuseracc=csadmin&updateusername=csadmin&useracc=admin&usercode=1&username=%E5%BC%A0%E9%BB%98&usertype=1";
        wb_goods = (WebView) findViewById(R.id.wv_goods);
        initWebSetting();
    }

    private void initWebSetting() {
        WebSettings settings = wb_goods.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        //支持javascript
        settings.setJavaScriptEnabled(true);
        // 设置可以支持缩放
        settings.setSupportZoom(true);
        // 设置出现缩放工具
        settings.setBuiltInZoomControls(true);
        //扩大比例的缩放
        settings.setUseWideViewPort(true);
        //自适应屏幕
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
        wb_goods.loadUrl(url11);


        wb_goods.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }
        });
    }
}
