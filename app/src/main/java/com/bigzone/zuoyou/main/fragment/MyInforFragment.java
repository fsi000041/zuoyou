package com.bigzone.zuoyou.main.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseFragment;
import com.bigzone.zuoyou.login.activity.LoginActivity;
import com.bigzone.zuoyou.main.activity.AboutActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/7/17.
 */

public class MyInforFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myinfo, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.rl_about)
    void changeAbout() {
        changeActivity(AboutActivity.class);
    }

    @OnClick(R.id.rl_update)
    void changeAddress() {
    }

    @OnClick(R.id.rl_unload)
    void unLoad() {
        new AlertDialog.Builder(getActivity(), android.R.style.Theme_DeviceDefault_Light_Dialog_Alert).setTitle("确定要退出登录吗？")
                .setNegativeButton("取消", null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                changeActivity(LoginActivity.class);
                getActivity().finish();
            }
        }).create().show();

    }

}
