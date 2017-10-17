package com.bigzone.zuoyou.utils;

import android.widget.Toast;

import com.bigzone.zuoyou.common.MyApp;


/**
 * Toast提示工具类(避免无限制弹出Toast)
 */
public class ToastUtils {

    private static final String TAG = "ToastUtils";

    private static Toast mToast = null;

    public static void showLongMsg(String text) {
        // Toast.LENGTH_LONG（3.5秒）
        showMsg(text, Toast.LENGTH_LONG);
    }

    public static void showShortMsg(String text) {
        // Toast.LENGTH_SHORT（2秒）
        showMsg(text, Toast.LENGTH_SHORT);
    }

    private static void showMsg(String text, int duriation) {
        if (!StringTools.isEmpty(text)) {
            if (null == mToast) {
                mToast = Toast.makeText(MyApp.APP_CONTEXT, text, duriation);

            } else {
                mToast.setText(text);
                mToast.setDuration(duriation);
            }
            mToast.show();

        } else {
            Logger.w(TAG, "text is empty.");
        }

    }

    /**
     * toast测试用来玩玩
     *
     * @param string
     */
    public static void testMsg(String string) {
        showShortMsg(string);
    }
}
