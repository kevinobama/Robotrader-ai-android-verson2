package com.example.kevingates.robotrader_ai_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//import 	java.util.*;
//import android.util.*;
//import android.content.Intent;
import 	java.util.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONArray;

public class marketCrypto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_crypto);
    }



    public void sendGetRequest(View View) {
        //myListView();
        new GetClass(this).execute();
    }

    private class GetClass extends AsyncTask<String, Void, Void> {

        private final Context context;

        public GetClass(Context c){
            this.context = c;
        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                //TextView textview1 = (TextView) findViewById(R.id.textview1);
                URL url = new URL("https://robotrader.ai/api/front/v1/market/prices/crypto?base_currency=USD");

                HttpURLConnection connection = (HttpURLConnection)url.openConnection();

                connection.setRequestMethod("GET");
                connection.setRequestProperty("USER-AGENT", "Mozilla/5.0");
                connection.setRequestProperty("ACCEPT-LANGUAGE", "en-US,en;0.5");

                int responseCode = connection.getResponseCode();

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = "";
                final StringBuilder responseOutput = new StringBuilder();

                while((line = br.readLine()) != null ) {
                    responseOutput.append(line);
                }
                br.close();


                marketCrypto.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView textview1 = (TextView)findViewById(R.id.textview1);
                        textview1.setText(responseOutput.toString());

//                        ArrayList<String> list = new ArrayList<String>();
//                        JSONArray jsonArray = (JSONArray)output;
//                        if (jsonArray != null) {
//                            int len = jsonArray.length();
//                            for (int i=0;i<len;i++){
//                                list.add(jsonArray.get(i).toString());
//                            }
//                        }
                        String[] list = new String[] { "Android", "iPhone"};
                        myListView(list);
                    }
                });

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

    }

    public void myListView(String[] values) {
        final ListView listview = (ListView) findViewById(R.id.listView2);
//        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
//                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
//                "Android", "iPhone", "WindowsMobile" };

        final ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        listview.setAdapter(adapter);
    }

    public String jsonData()
    {
        //for (int i = 0; i < 10; ++i) {
            //list.add(values[i]);
        //}
        return "data";
    }
}
