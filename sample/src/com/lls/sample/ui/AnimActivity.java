package com.lls.sample.ui;

import android.os.Bundle;
import com.lls.sample.R;
import com.lls.sample.base.BaseActivity;
import com.lls.sample.widget.CircleView;

/**
 * Created by jameson.hua on 2015/3/30.
 */
public class AnimActivity extends BaseActivity {

    private  CircleView mCircleView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        
        init();
    }

    private void init() {
        mCircleView = (CircleView) findViewById(R.id.circle_view);
        mCircleView.startPlay();
    }
}
