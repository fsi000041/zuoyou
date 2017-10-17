package com.bigzone.zuoyou.reception.activity;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.reception.view.Player;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by haohongwei on 2017/8/9.
 */

public class ReceptionDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_top_right)
    TextView tv_save;
    private Player player;
    @BindView(R.id.skbProgress)
    SeekBar skbProgress;
    private String url = "http://sc1.111ttt.com/2016/5/12/10/205101338233.mp3";
    private int a = 0;

    @Override
    protected int bindLayout() {
        return R.layout.activity_reception_detail;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        tv_title.setText("接待详情");
        tv_save.setText("保存");
        tv_save.setVisibility(View.VISIBLE);
        skbProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
        player = new Player(skbProgress);
    }

    @OnCheckedChanged(R.id.cb_record)
    void checkChange(boolean isOpen) {
        if (isOpen && a == 0) {
            player.playUrl(url);
            a++;
        } else if (isOpen && a != 0) {
            player.play();
        } else {
            player.pause();
        }
    }

    class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener {
        int progress;

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            this.progress = progress * player.mediaPlayer.getDuration()
                    / seekBar.getMax();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            player.mediaPlayer.seekTo(progress);
        }
    }

    @Override
    protected void onDestroy() {
        if (player != null) {
            player.stop();
        }
        super.onDestroy();
    }

    @OnClick(R.id.rl_link)
    void changeLinkList() {
        changeActivity(LinkListActivity.class);
    }

    @OnClick(R.id.iv_back)
    void back(){
        finish();
    }
}
