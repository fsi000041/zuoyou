package com.bigzone.zuoyou.main.activity;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.widget.RadioButton;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.main.fragment.MyInforFragment;
import com.bigzone.zuoyou.main.fragment.WarmListFragment;
import com.bigzone.zuoyou.main.fragment.WorkPointFragment;
import com.bigzone.zuoyou.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/7/17.
 */

public class MainActvity extends BaseActivity {
    private long exitTime = 0;
    private MyInforFragment myInforFragment;
    private WarmListFragment warmListFragment;
    private WorkPointFragment workPointFragment;
    private Fragment currentFragment = new Fragment();
    @BindView(R.id.rb_work)
    RadioButton rb_work;
    @BindView(R.id.rb_mine)
    RadioButton rb_mine;
    @BindView(R.id.rb_message)
    RadioButton rb_message;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        Drawable drwork = getResources().getDrawable(R.drawable.work_bg);
        drwork.setBounds(0, 0, 77, 70);
        rb_work.setCompoundDrawables(null, drwork, null, null);
        Drawable drmine = getResources().getDrawable(R.drawable.mine_bg);
        drmine.setBounds(0, 0, 77, 70);
        rb_mine.setCompoundDrawables(null, drmine, null, null);
        Drawable drwarm = getResources().getDrawable(R.drawable.warm_bg);
        drwarm.setBounds(0, 0, 77, 70);
        rb_message.setCompoundDrawables(null, drwarm, null, null);
        setDefaultFragment();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.CAMERA}, 3);
        }
    }

    private void setDefaultFragment() {
        workPointFragment = new WorkPointFragment();
        showFragment(workPointFragment);
        currentFragment = workPointFragment;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 1000) {
                ToastUtils.showShortMsg("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
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

    @OnClick(R.id.rb_message)
    void showMessage() {
        if (warmListFragment == null) {
            warmListFragment = new WarmListFragment();
        }
        showFragment(warmListFragment);
    }

    @OnClick(R.id.rb_work)
    void showWork() {
        if (workPointFragment == null) {
            workPointFragment = new WorkPointFragment();
        }
        showFragment(workPointFragment);
    }

    @OnClick(R.id.rb_mine)
    void showMine() {
        if (myInforFragment == null) {
            myInforFragment = new MyInforFragment();
        }
        showFragment(myInforFragment);
    }

}
