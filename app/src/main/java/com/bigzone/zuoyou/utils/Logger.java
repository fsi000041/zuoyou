package com.bigzone.zuoyou.utils;

import android.support.coreui.BuildConfig;
import android.util.Log;

public class Logger {

    private final static boolean isOpenDebug = true;

    public static void i(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (!BuildConfig.DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }

}
