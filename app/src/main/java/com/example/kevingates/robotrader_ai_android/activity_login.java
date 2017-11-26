package com.example.kevingates.robotrader_ai_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void openMain(View View)
    {
        Intent login = new Intent(activity_login.this, MainActivity.class);
        startActivity(login);
    }
}
