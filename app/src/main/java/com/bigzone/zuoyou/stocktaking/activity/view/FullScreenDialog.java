package com.bigzone.zuoyou.stocktaking.activity.view;

import android.app.Dialog;
import android.content.Context;

import com.bigzone.zuoyou.R;

/**
 * Created by sszz on 2017/9/18.
 */

public class FullScreenDialog extends Dialog {

    private Context mContext;

    public FullScreenDialog( Context context) {
        super(context, R.style.Dialog_Fullscreen);
    }

    public FullScreenDialog( Context context, int themeResId) {
        super(context,  R.style.Dialog_Fullscreen);
        mContext = context;
    }

    protected FullScreenDialog( Context context, boolean cancelable,  OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
