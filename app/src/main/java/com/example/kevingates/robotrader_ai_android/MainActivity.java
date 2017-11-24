package com.example.kevingates.robotrader_ai_android;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.*;
import android.widget.Button;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import 	java.util.*;
import android.util.*;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void marketCrypto(View View)
    {
        Intent myIntent = new Intent(MainActivity.this, marketCrypto.class);
        startActivity(myIntent);
    }

    public void openActivity(View View)
    {
        Intent myIntent = new Intent(MainActivity.this, ListViewExampleActivity.class);
        startActivity(myIntent);
        Log.v("message", "opened");
    }
}
