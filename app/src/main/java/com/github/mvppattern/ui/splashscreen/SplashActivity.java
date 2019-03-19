package com.github.mvppattern.ui.splashscreen;

import android.content.Intent;
import android.os.Bundle;

import com.github.mvppattern.R;
import com.github.mvppattern.base.BaseActivity;
import com.github.mvppattern.ui.main.MainActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void setUp() {

    }
}
