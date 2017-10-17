package com.bigzone.zuoyou.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.bigzone.zuoyou.common.MyApp;


public class SharedPreferenceHelper {
    private static final String TAG = "SharedPreferenceHelper";
    private static final String SP_NAME = "App_Config";
    private static SharedPreferences sp = MyApp.APP_CONTEXT
            .getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    private static Editor editor = sp.edit();
    /**
     * 查询用户账号
     */
    private static final String USERNUM = "usernum";
    /**
     * 查询用户密码
     */
    private static final String USERPWD = "userpwd";
    /**
     * 查询用户IP
     */
    private static final String USERIP = "user_ip";
    /**
     * 查询用户PORT
     */
    private static final String USERPORT = "user_port";
    /**
     * 查询用户服务名
     */
    private static final String USERSERVER = "user_server";
    /**
     * 是否记录账号密码
     */
    private static final String REMEMBER = "remember";
    /**
     * 是否启动引导页
     */
    private static final String IS_FIRST_START_APP = "isFirstStartApp";

    /**
     * 存储用户服务名
     */
    public static void setUserserver(String value) {
        commit(USERSERVER, value);
    }

    /**
     * 查询用户IP
     */
    public static String getUserserver() {
        return getStringValue(USERSERVER);
    }

    /**
     * 存储用户IP
     */
    public static void setUserport(String value) {
        commit(USERPORT, value);
    }

    /**
     * 查询用户IP
     */
    public static String getUserport() {
        return getStringValue(USERPORT);
    }

    /**
     * 存储用户IP
     */
    public static void setUserip(String value) {
        commit(USERIP, value);
    }

    /**
     * 查询用户IP
     */
    public static String getUserip() {
        return getStringValue(USERIP);
    }

    /**
     * 是否记录账号密码
     */
    public static void setRemember(boolean value) {
        commit(REMEMBER, value);
    }

    /**
     * 是否记录账号密码
     */
    public static boolean getRemember() {
        return getBooleanValue(REMEMBER);
    }

    /**
     * 存储用户账号
     */
    public static void setUsernum(String value) {
        commit(USERNUM, value);
    }

    /**
     * 查询用户账号
     */
    public static String getUsernum() {
        return getStringValue(USERNUM);
    }

    /**
     * 存储用户密码
     */
    public static void setUserpwd(String value) {
        commit(USERPWD, value);
    }

    /**
     * 查询用户密码
     */
    public static String getUserpwd() {
        return getStringValue(USERPWD);
    }

    private static void commit(String key, String value) {
        editor.putString(key, value);
        editor.commit();
        Logger.d(TAG, "commit : " + key + " value : " + value);
    }

    private static void commit(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
        Logger.d(TAG, "commit : " + key + " value : " + value);
    }

    private static String getStringValue(String key) {
        String enabled = sp.getString(key, null);
        Logger.d(TAG, "key : " + key + " enabled : " + enabled);
        return enabled;
    }

    private static boolean getBooleanValue(String key) {
        boolean enabled = sp.getBoolean(key, false);
        Logger.d(TAG, "key : " + key + " enabled : " + enabled);
        return enabled;
    }

    /**
     * 是否启动引导页
     */
    public static void setIsFirstStartApp(boolean value) {
        commit(IS_FIRST_START_APP, value);
    }

    /**
     * 是否启动引导页
     */
    public static boolean getIsFirstStartApp() {
        return getBooleanValue(IS_FIRST_START_APP, true);
    }

    private static boolean getBooleanValue(String key, boolean defaltValue) {
        boolean enabled = sp.getBoolean(key, defaltValue);
        Logger.d(TAG, "key : " + key + " enabled : " + enabled);
        return enabled;
    }
}
