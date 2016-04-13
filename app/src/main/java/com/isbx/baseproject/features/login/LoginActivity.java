package com.isbx.baseproject.features.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.isbx.baseproject.R;
import com.isbx.baseproject.util.ActivityUtils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), new LoginFragment(), R.id.fragmentContainer);
    }
}
