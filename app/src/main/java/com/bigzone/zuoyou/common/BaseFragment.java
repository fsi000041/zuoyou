package com.bigzone.zuoyou.common;

import android.app.Fragment;
import android.content.Intent;

/**
 * Created by 郝宏伟 on 2016-12-02.
 */

public class BaseFragment extends Fragment {

    /**
     * 跳转界面
     */
    public void changeActivity(Class<?> clz) {
        Intent intent = new Intent(getActivity(), clz);
        startActivity(intent);
    }

    /**
     * 跳转界面(有结果返回)
     */
    public void changeActivityForResult(Class<?> clz, int code) {
        Intent intent = new Intent(getActivity(), clz);
        startActivityForResult(intent, code);
    }
}
