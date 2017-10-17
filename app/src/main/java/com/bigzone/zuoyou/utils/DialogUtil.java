package com.bigzone.zuoyou.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Seriex.X on 2017/7/7.
 */

public class DialogUtil {
    /**
     * 单选弹窗
     *
     * @param context
     * @param names
     * @param
     */
    public static void setSingleItemDialog(Context context, String title, String[] names,
                                           DialogInterface.OnClickListener listener) {
//       names = {"1", "2", "3", "4", "5"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        builder.setTitle(title);
        builder.setItems(names, listener).create().show();
//        builder.setPositiveButton("确定", btnListener);
//                .setNegativeButton("取消", null).create().show();
    }

    /**
     * 多选弹窗
     *
     * @param context
     * @param title
     * @param names
     * @param ensureListener 确定回调
     * @param multiListener  单项回调
     */

    public static void setMultiItemDialog(Context context, String title, String[] names, DialogInterface
            .OnClickListener ensureListener, DialogInterface.OnMultiChoiceClickListener
                                                  multiListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context,
                AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        builder.setTitle(title)
                //null默认不选中
                .setMultiChoiceItems(names, null, multiListener)
                .setPositiveButton("确定", ensureListener)
                .setNegativeButton("取消", null).create().show();
    }

    /**
     * 未保存退出确认
     *
     * @param context
     * @param title
     * @param listener
     */
    public static void isSureDialog(Context context, String title, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog
                .THEME_DEVICE_DEFAULT_LIGHT);
        builder.setTitle(title)
                .setPositiveButton("确定", listener)
                .setNegativeButton("取消", null).create()
                .show();
    }
}
