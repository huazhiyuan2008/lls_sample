package com.lls.sample.ui;

import android.os.Bundle;
import com.lls.sample.R;
import com.lls.sample.base.BaseActivity;
import com.lls.sample.widget.CircleViewLayout;

/**
 * Created by jameson.hua on 2015/3/30.
 */
public class AnimActivity2 extends BaseActivity {

    private CircleViewLayout mCircleViewLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim2);

        init();
    }

    private void init() {
        mCircleViewLayout = (CircleViewLayout) findViewById(R.id.circle_view);
        mCircleViewLayout.startPlay();
    }
}
