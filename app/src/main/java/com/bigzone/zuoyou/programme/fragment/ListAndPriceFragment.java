package com.bigzone.zuoyou.programme.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by haohongwei on 2017/9/25.
 */

public class ListAndPriceFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myinfo, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
