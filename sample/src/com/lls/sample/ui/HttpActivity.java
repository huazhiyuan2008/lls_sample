package com.lls.sample.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.lls.library.http.HttpUtil;
import com.lls.library.util.SharedPreferencesHelper;
import com.lls.sample.R;
import com.lls.sample.base.BaseActivity;
import org.json.JSONObject;

/**
 * Created by jameson.hua on 2015/3/30.
 */
public class HttpActivity extends BaseActivity {
    private TextView mResultView;
    private static final String KEY_WEATHER = "key_weather";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        init();
    }

    private void init() {
        mResultView = (TextView) findViewById(R.id.result);
        String data = SharedPreferencesHelper.getInstance(getApplicationContext()).getString(KEY_WEATHER);
        renderUI(data);
        loadData();
    }

    private void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=101010100&imei=529e2dd3d767bdd3595eec30dd481050&device=pisces&miuiVersion=JXCCNBD20.0&modDevice=&source=miuiWeatherApp";
                String data = HttpUtil.getMethod(url);
                if (data != null) {
                    SharedPreferencesHelper.getInstance(getApplicationContext()).putString(KEY_WEATHER, data);
                    renderUI(data);
                }
            }
        }).start();
    }

    private void renderUI(final String data) {
        if (TextUtils.isEmpty(data)) {
            return;
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                try {
                    JSONObject obj = new JSONObject(data);
                    mResultView.setText(obj.getJSONObject("forecast").getString("city")
                            + ", " + obj.getJSONObject("realtime").getString("weather"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
