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
        //intArray();
        //openLogin();
    }

    public void marketCrypto(View View)
    {
        Intent myIntent = new Intent(MainActivity.this, marketCrypto.class);
        startActivity(myIntent);
    }

    public void marketCryptoOne(View View)
    {
        Intent myIntent = new Intent(MainActivity.this, marketCryptoOne.class);
        startActivity(myIntent);
    }

    public void marketCryptoTwo(View View)
    {
        Intent myIntent = new Intent(MainActivity.this, marketCryptoTwo.class);
        startActivity(myIntent);
    }

    public void openActivity(View View)
    {
        Intent myIntent = new Intent(MainActivity.this, ListViewExampleActivity.class);
        startActivity(myIntent);
        Log.v("message", "opened");
    }

    public void intArray() {
        int[] ints   = new int[20];

        for(int i=1; i <20 ; i++){
            ints[i] = i;
        }

        System.out.println("canada="+Arrays.toString(ints));
    }

    public void openLogin(View View)
    {
        Intent login = new Intent(MainActivity.this, activity_login.class);
        startActivity(login);
    }
}
