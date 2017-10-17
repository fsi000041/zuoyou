package com.bigzone.zuoyou.programme.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.main.fragment.WarmListFragment;
import com.bigzone.zuoyou.main.fragment.WorkPointFragment;
import com.bigzone.zuoyou.programme.fragment.ImageShowFragment;
import com.bigzone.zuoyou.programme.fragment.ListAndPriceFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/9/25.
 */

public class ProgrammeListActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_add;
    private ImageShowFragment imageShowFragment;
    private ListAndPriceFragment listAndPriceFragment;
    private Fragment currentFragment = new Fragment();

    @Override
    protected int bindLayout() {
        return R.layout.activity_programme_list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_add.setText("开单");
        tv_add.setVisibility(View.VISIBLE);
        tv_title.setText("方案展示");
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        imageShowFragment = new ImageShowFragment();
        showFragment(imageShowFragment);
        currentFragment = imageShowFragment;
    }

    /**
     * 控制Fragment的方法
     *
     * @param fragment
     */
    private void showFragment(Fragment fragment) {
        if (currentFragment != fragment) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.hide(currentFragment);
            currentFragment = fragment;
            if (!fragment.isAdded()) {
                transaction.add(R.id.frame, fragment).show(fragment).commit();
            } else {
                transaction.show(fragment).commit();
            }
        }
    }

    @OnClick(R.id.rb_doing)
    void showMessage() {
        if (imageShowFragment == null) {
            imageShowFragment = new ImageShowFragment();
        }
        showFragment(imageShowFragment);
    }

    @OnClick(R.id.rb_complete)
    void showWork() {
        if (listAndPriceFragment == null) {
            listAndPriceFragment = new ListAndPriceFragment();
        }
        showFragment(listAndPriceFragment);
    }
}
