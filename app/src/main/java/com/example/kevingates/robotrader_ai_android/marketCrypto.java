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
import android.util.*;
//import android.content.Intent;
import 	java.util.*;
import android.widget.*;
import org.json.*;


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

                marketCrypto.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String jsonStr = marketJsonData();

                            JSONObject jsonObj = new JSONObject(jsonStr);
                            JSONObject prices = jsonObj.getJSONObject("prices");
                            JSONObject exchangeCountries = jsonObj.getJSONObject("exchangeCountries");


                            ArrayList<String> contactArray = new ArrayList<String>();

                            Iterator<String> exchangeCountrykeys = exchangeCountries.keys();
                            while (exchangeCountrykeys.hasNext()) {
                                //String key = price.next();

                                String keyStr = (String)exchangeCountrykeys.next();
                                String valueStr = exchangeCountries.getString(keyStr);

                                contactArray.add(keyStr+'|'+valueStr);

                                //try {
                                    //Object value = prices.get(key);
                                    //contactArray.add(value);
                                    //contactArray.add(key);
                                //} catch (JSONException e) {
                                    // Something went wrong!
                                //}
                            }

//                            iter = exchangeCountries.keys();
//                            while (iter.hasNext()) {
//                                String key = iter.next();
//                                try {
//                                    Object value = exchangeCountries.get(key);
//                                    contactArray.add(key);
//                                } catch (JSONException e) {
//                                    // Something went wrong!
//                                }
//                            }

                            myListView(contactArray);

                        } catch (JSONException e) {
                            Log.e("JSON Parser", "Error parsing data " + e.toString());
                        }
                    }
                });

            return null;
        }


        protected Void doInBackgroundBackup(String... params) {
            try {
                URL url = new URL("https://robotrader.ai/api/front/v1/market/prices/crypto?base_currency=USD");

                HttpURLConnection connection = (HttpURLConnection)url.openConnection();

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                final StringBuilder responseOutput = new StringBuilder();
                final String json= br.readLine();
                br.close();

//                final String baseCurrency;
//                final String trans;
//                try {
//                        JSONObject jsonObj = new JSONObject(json);
//                        baseCurrency = jsonObj.getString("baseCurrency");
//                        trans = jsonObj.getString("trans");
//                        Log.v("json",  trans);
//                        Log.v("json",  baseCurrency);
//
//                    } catch (JSONException e) {
//                        Log.e("JSON Parser", "Error parsing data " + e.toString());
//                    }

                //Log.v("Json", "Json=" + json);


                marketCrypto.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                         String baseCurrency;
                         String trans;
                          //exchangeCountries;
                         try {
                            /** JSONObject jsonObj = new JSONObject(json);
                            baseCurrency = jsonObj.getString("baseCurrency");
                            trans = jsonObj.getString("trans");
                            JSONArray exchangeCountries = jsonObj.getJSONArray("exchangeCountries");
                            Log.v("json",  trans);
                            Log.v("json",  baseCurrency);
                            TextView textview1 = (TextView)findViewById(R.id.textview1);
                            textview1.setText(baseCurrency); **/


//                             for (int i=0; i < exchangeCountries.length(); i++) {
//
//                                 //exchangeCountries.getString(i);
//                                 Log.v("json exchangeCountries",  exchangeCountries.getString(i));
//                             }

                             String jsonStr = jsonData();

                             Log.e("json", "Response from url: " + jsonStr);

                                 //try {
                                     JSONObject jsonObj = new JSONObject(jsonStr);

                                     // Getting JSON Array node
                                     JSONArray contacts = jsonObj.getJSONArray("contacts");

                                     // looping through All Contacts
                                     ArrayList<String> contactArray = new ArrayList<String>();
                                     for (int i = 0; i < contacts.length(); i++) {
                                         JSONObject c = contacts.getJSONObject(i);
                                         String id = c.getString("id");
                                         String name = c.getString("name");
                                         String email = c.getString("email");

                                         contactArray.add(name);

                                         Log.v("json name",  name);
                                         Log.v("json name",  email);

                                     }


                             //ArrayList<String> list = new ArrayList<String>();
                             //list.add("B");
                             //list.add("C");
                             myListView(contactArray);
                             //Log.v("json exchangeCountries",  exchangeCountries.toString());
                             //Log.v("json",  Arrays.toString(exchangeCountries));
                            //ArrayList<String> list = new ArrayList<String>();
                            //JSONArray jsonArray = (JSONArray)exchangeCountries;
//                            if (exchangeCountries != null) {
//                                int len = exchangeCountries.length();
//                                for (int i=0;i<len;i++){
//                                    list.add(exchangeCountries.get(i).toString());
//                                }
//                            }


                            //myListView(list);

                        } catch (JSONException e) {
                            Log.e("JSON Parser", "Error parsing data " + e.toString());
                        }
                        Log.v("Json", "Json=" + json);


//                        ArrayList<String> list = new ArrayList<String>();
//                        JSONArray jsonArray = (JSONArray)output;
//                        if (jsonArray != null) {
//                            int len = jsonArray.length();
//                            for (int i=0;i<len;i++){
//                                list.add(jsonArray.get(i).toString());
//                            }
//                        }
                        //String[] list = new String[] { "Android", "iPhone"};
                        //myListView(list);
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




    public void myListView(ArrayList<String> list) {
        final ListView listview = (ListView) findViewById(R.id.listView2);

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        listview.setAdapter(adapter);
    }

    public String jsonData()
    {
        //for (int i = 0; i < 10; ++i) {
            //list.add(values[i]);
        //}
        return "{\n" +
                "    \"contacts\": [\n" +
                "        {\n" +
                "            \"id\": \"c200\",\n" +
                "            \"name\": \"Ravi Tamada\",\n" +
                "            \"email\": \"ravi@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"male\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"c201\",\n" +
                "            \"name\": \"Johnny Depp\",\n" +
                "            \"email\": \"johnny_depp@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"male\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"c202\",\n" +
                "            \"name\": \"Leonardo Dicaprio\",\n" +
                "            \"email\": \"leonardo_dicaprio@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"male\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"c203\",\n" +
                "            \"name\": \"John Wayne\",\n" +
                "            \"email\": \"john_wayne@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"male\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"c204\",\n" +
                "            \"name\": \"Angelina Jolie\",\n" +
                "            \"email\": \"angelina_jolie@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"female\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"c205\",\n" +
                "            \"name\": \"Dido\",\n" +
                "            \"email\": \"dido@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"female\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"c206\",\n" +
                "            \"name\": \"Adele\",\n" +
                "            \"email\": \"adele@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"female\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"c207\",\n" +
                "            \"name\": \"Hugh Jackman\",\n" +
                "            \"email\": \"hugh_jackman@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"male\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"c208\",\n" +
                "            \"name\": \"Will Smith\",\n" +
                "            \"email\": \"will_smith@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"male\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"c209\",\n" +
                "            \"name\": \"Clint Eastwood\",\n" +
                "            \"email\": \"clint_eastwood@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"male\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"c2010\",\n" +
                "            \"name\": \"Barack Obama\",\n" +
                "            \"email\": \"barack_obama@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"male\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"c2011\",\n" +
                "            \"name\": \"Kate Winslet\",\n" +
                "            \"email\": \"kate_winslet@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"female\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"c2012\",\n" +
                "            \"name\": \"Eminem\",\n" +
                "            \"email\": \"eminem@gmail.com\",\n" +
                "            \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
                "            \"gender\": \"male\",\n" +
                "            \"phone\": {\n" +
                "                \"mobile\": \"+91 0000000000\",\n" +
                "                \"home\": \"00 000000\",\n" +
                "                \"office\": \"00 000000\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    public String marketJsonData()
    {
        return "{\n" +
                "    \"baseCurrency\": \"USD\",\n" +
                "    \"prices\": {\n" +
                "        \"BTC\": {\n" +
                "            \"LBTC\": {\n" +
                "                \"buy\": 8423.27166408,\n" +
                "                \"sell\": 8423.27166408,\n" +
                "                \"updated\": 1511589029\n" +
                "            },\n" +
                "            \"GDAX\": {\n" +
                "                \"buy\": \"8264.01000\",\n" +
                "                \"sell\": \"8264.00000\",\n" +
                "                \"updated\": 1511589030\n" +
                "            },\n" +
                "            \"POLO\": {\n" +
                "                \"buy\": \"8250.66816\",\n" +
                "                \"sell\": \"8241.03634\",\n" +
                "                \"updated\": 1511589029\n" +
                "            },\n" +
                "            \"COIC\": {\n" +
                "                \"buy\": 8235.620674,\n" +
                "                \"sell\": 8235.010986,\n" +
                "                \"updated\": 1511589030\n" +
                "            },\n" +
                "            \"BITF\": {\n" +
                "                \"buy\": \"8235.10000\",\n" +
                "                \"sell\": \"8235.00000\",\n" +
                "                \"updated\": 1511589030\n" +
                "            },\n" +
                "            \"BFLY\": {\n" +
                "                \"buy\": \"8268.11200\",\n" +
                "                \"sell\": \"8208.70000\",\n" +
                "                \"updated\": 1511589030\n" +
                "            },\n" +
                "            \"KRAK\": {\n" +
                "                \"buy\": \"8186.10000\",\n" +
                "                \"sell\": \"8180.21500\",\n" +
                "                \"updated\": 1511589029\n" +
                "            },\n" +
                "            \"BSTM\": {\n" +
                "                \"buy\": \"8182.64343\",\n" +
                "                \"sell\": \"8176.88000\",\n" +
                "                \"updated\": 1511589029\n" +
                "            }\n" +
                "        },\n" +
                "        \"BCH\": {\n" +
                "            \"KRAK\": {\n" +
                "                \"buy\": \"1600.00000\",\n" +
                "                \"sell\": \"1599.70000\",\n" +
                "                \"updated\": 1511589029\n" +
                "            }\n" +
                "        },\n" +
                "        \"ETC\": {\n" +
                "            \"BITF\": {\n" +
                "                \"buy\": \"20.74700\",\n" +
                "                \"sell\": \"20.73700\",\n" +
                "                \"updated\": 1511589030\n" +
                "            },\n" +
                "            \"POLO\": {\n" +
                "                \"buy\": \"20.81390\",\n" +
                "                \"sell\": \"20.71390\",\n" +
                "                \"updated\": 1511589029\n" +
                "            },\n" +
                "            \"KRAK\": {\n" +
                "                \"buy\": \"20.78300\",\n" +
                "                \"sell\": \"20.65900\",\n" +
                "                \"updated\": 1511589029\n" +
                "            }\n" +
                "        },\n" +
                "        \"ETH\": {\n" +
                "            \"GDAX\": {\n" +
                "                \"buy\": \"467.29000\",\n" +
                "                \"sell\": \"467.28000\",\n" +
                "                \"updated\": 1511589030\n" +
                "            },\n" +
                "            \"POLO\": {\n" +
                "                \"buy\": \"466.37795\",\n" +
                "                \"sell\": \"465.10000\",\n" +
                "                \"updated\": 1511589029\n" +
                "            },\n" +
                "            \"BITF\": {\n" +
                "                \"buy\": \"464.63000\",\n" +
                "                \"sell\": \"464.60000\",\n" +
                "                \"updated\": 1511589030\n" +
                "            },\n" +
                "            \"KRAK\": {\n" +
                "                \"buy\": \"462.00000\",\n" +
                "                \"sell\": \"460.75000\",\n" +
                "                \"updated\": 1511589029\n" +
                "            }\n" +
                "        },\n" +
                "        \"XRP\": {\n" +
                "            \"KRAK\": {\n" +
                "                \"buy\": \"0.24350\",\n" +
                "                \"sell\": \"0.24301\",\n" +
                "                \"updated\": 1511588428\n" +
                "            },\n" +
                "            \"BSTM\": {\n" +
                "                \"buy\": \"0.24300\",\n" +
                "                \"sell\": \"0.24207\",\n" +
                "                \"updated\": 1511589029\n" +
                "            }\n" +
                "        },\n" +
                "        \"ZEC\": {\n" +
                "            \"BITF\": {\n" +
                "                \"buy\": \"347.23000\",\n" +
                "                \"sell\": \"345.48000\",\n" +
                "                \"updated\": 1511589030\n" +
                "            },\n" +
                "            \"KRAK\": {\n" +
                "                \"buy\": \"347.18000\",\n" +
                "                \"sell\": \"344.04000\",\n" +
                "                \"updated\": 1511589029\n" +
                "            }\n" +
                "        },\n" +
                "        \"LTC\": {\n" +
                "            \"GDAX\": {\n" +
                "                \"buy\": \"79.69000\",\n" +
                "                \"sell\": \"79.68000\",\n" +
                "                \"updated\": 1511589030\n" +
                "            },\n" +
                "            \"BITF\": {\n" +
                "                \"buy\": \"79.12100\",\n" +
                "                \"sell\": \"79.04900\",\n" +
                "                \"updated\": 1511589030\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"trans\": {\n" +
                "        \"KRAK\": \"Kraken\",\n" +
                "        \"OKCN\": \"OKCoin China\",\n" +
                "        \"OKCI\": \"OKCoin International\",\n" +
                "        \"BFXE\": \"Bitfinex (Exchange)\",\n" +
                "        \"HUOB\": \"Huobi\",\n" +
                "        \"BTCN\": \"BTC China\",\n" +
                "        \"BTCC\": \"BTCC\",\n" +
                "        \"YUNB\": \"Yunbi\",\n" +
                "        \"CHBT\": \"CHBTC\",\n" +
                "        \"BSTM\": \"Bitstamp\",\n" +
                "        \"CRYP\": \"Cryptopia\",\n" +
                "        \"LBTC\": \"Local Bitcoins China\",\n" +
                "        \"POLO\": \"Poloniex\",\n" +
                "        \"C2CX\": \"C2CX\",\n" +
                "        \"OAND\": \"Oanda\",\n" +
                "        \"GDAX\": \"GDAX\",\n" +
                "        \"BXTH\": \"BX in Thailand\",\n" +
                "        \"BFXT\": \"Bitfinex (Trading)\",\n" +
                "        \"BITF\": \"Bitfinex\",\n" +
                "        \"SZZC\": \"SZZC\",\n" +
                "        \"BTER\": \"Bter\",\n" +
                "        \"COIC\": \"Coincheck\",\n" +
                "        \"BTRX\": \"Bittrex\",\n" +
                "        \"GEMI\": \"Gemini\",\n" +
                "        \"BFLY\": \"Bitflyer\"\n" +
                "    },\n" +
                "    \"exchangeCountries\": {\n" +
                "        \"KRAK\": \"USA\",\n" +
                "        \"OKCN\": \"China\",\n" +
                "        \"OKCI\": \"Hong Kong\",\n" +
                "        \"BFXE\": \"International\",\n" +
                "        \"HUOB\": \"China\",\n" +
                "        \"BTCN\": \"China\",\n" +
                "        \"BTCC\": \"China\",\n" +
                "        \"YUNB\": \"China\",\n" +
                "        \"CHBT\": \"China\",\n" +
                "        \"BSTM\": \"International\",\n" +
                "        \"CRYP\": \"New Zealand\",\n" +
                "        \"LBTC\": \"China\",\n" +
                "        \"POLO\": \"International\",\n" +
                "        \"C2CX\": \"China\",\n" +
                "        \"OAND\": \"International\",\n" +
                "        \"GDAX\": \"USA\",\n" +
                "        \"BXTH\": \"Thailand\",\n" +
                "        \"BFXT\": \"International\",\n" +
                "        \"BITF\": \"International\",\n" +
                "        \"SZZC\": \"China\",\n" +
                "        \"BTER\": \"China\",\n" +
                "        \"COIC\": \"Japan\",\n" +
                "        \"BTRX\": \"USA\",\n" +
                "        \"GEMI\": \"USA\",\n" +
                "        \"BFLY\": \"Japan\"\n" +
                "    },\n" +
                "    \"nowTimestamp\": 1511589038,\n" +
                "    \"exchangeUrls\": {\n" +
                "        \"KRAK\": \"https://kraken.com\",\n" +
                "        \"OKCN\": \"https://okcoin.cn\",\n" +
                "        \"OKCI\": \"https://okcoin.com\",\n" +
                "        \"BFXE\": \"https://bitfinex.com\",\n" +
                "        \"HUOB\": \"https://www.huobi.com\",\n" +
                "        \"BTCN\": \"https://btcchina.com\",\n" +
                "        \"BTCC\": \"https://btcc.com\",\n" +
                "        \"YUNB\": \"https://yunbi.com\",\n" +
                "        \"CHBT\": \"https://www.chbtc.com\",\n" +
                "        \"BSTM\": \"https://bitstamp.com\",\n" +
                "        \"CRYP\": \"https://cryptopia.co.nz\",\n" +
                "        \"LBTC\": \"https://localbitcoins.com\",\n" +
                "        \"POLO\": \"https://poloniex.com\",\n" +
                "        \"C2CX\": \"https://www.c2cx.com\",\n" +
                "        \"OAND\": \"https://oanda.com\",\n" +
                "        \"GDAX\": \"https://gdax.com\",\n" +
                "        \"BXTH\": \"https://bx.in.th\",\n" +
                "        \"BFXT\": \"https://bitfinex.com\",\n" +
                "        \"BITF\": \"https://bitfinex.com\",\n" +
                "        \"SZZC\": \"https://szzc.com\",\n" +
                "        \"BTER\": \"https://bter.com\",\n" +
                "        \"COIC\": \"https://coincheck.com\",\n" +
                "        \"BTRX\": \"https://bittrex.com\",\n" +
                "        \"GEMI\": \"https://gemini.com\",\n" +
                "        \"BFLY\": \"https://bitflyer.jp\"\n" +
                "    }\n" +
                "}";
    }


    public void putDataToListView()
    {
        try {
            String jsonStr = marketJsonData();

            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONObject prices = jsonObj.getJSONObject("prices");
            JSONObject exchangeCountries = jsonObj.getJSONObject("exchangeCountries");

            ArrayList<String> contactArray = new ArrayList<String>();

            Iterator<String> exchangeCountrykeys = exchangeCountries.keys();
            while (exchangeCountrykeys.hasNext()) {

                String keyStr = (String)exchangeCountrykeys.next();
                String valueStr = exchangeCountries.getString(keyStr);

                contactArray.add(keyStr+'|'+valueStr);
            }

            myListView(contactArray);

        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
    }
}
