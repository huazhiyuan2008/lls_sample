package com.lls.sample.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.lls.sample.R;

public class MyActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        init();
    }

    private void init() {
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(new Intent(MyActivity.this, HttpActivity.class));
                break;

            case R.id.btn2:
                startActivity(new Intent(MyActivity.this, AnimActivity.class));
                break;

            case R.id.btn3:
                startActivity(new Intent(MyActivity.this, ImageActivity.class));
                break;

            case R.id.btn4:
                startActivity(new Intent(MyActivity.this, HttpActivity.class));
                break;
        }
    }
}
