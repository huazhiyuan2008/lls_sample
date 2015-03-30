package com.lls.sample.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.lls.library.util.UIUtil;
import com.lls.sample.R;
import com.lls.sample.base.BaseActivity;

/**
 * Created by jameson.hua on 2015/3/30.
 */
public class ImageActivity extends BaseActivity {

    private ImageView mImageView1;
    private ImageView mImageView2;
    private ImageView mImageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        init();
    }

    private void init() {
        mImageView1 = (ImageView) findViewById(R.id.image1);
        mImageView2 = (ImageView) findViewById(R.id.image2);
        mImageView3 = (ImageView) findViewById(R.id.image3);

        mImageView1.setImageResource(R.drawable.pic1);
        mImageView2.setImageResource(R.drawable.pic2);
        mImageView3.setImageResource(R.drawable.pic3);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                int maxHeight = UIUtil.dip2px(ImageActivity.this, 2300);

                int height = (int) ((float) mImageView2.getWidth() / mImageView2.getDrawable().getMinimumWidth() * mImageView2.getDrawable().getMinimumHeight());
                if (height > maxHeight) {
                    height = maxHeight;
                }

                ViewGroup.LayoutParams params = mImageView2.getLayoutParams();
                params.width = LinearLayout.LayoutParams.MATCH_PARENT;
                params.height = height;

                mImageView2.setLayoutParams(params);
            }
        }, 200);
    }
}
