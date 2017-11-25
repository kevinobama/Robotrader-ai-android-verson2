package com.example.kevingates.robotrader_ai_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

public class marketCryptoOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_crypto_one);
    }

    public void putDataToListViewMultipleColumns(View View)
    {
        try {
            String jsonStr = marketJsonData();

            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONObject prices = jsonObj.getJSONObject("prices");
            JSONObject exchangeCountries = jsonObj.getJSONObject("exchangeCountries");

            ArrayList<User> users = new ArrayList<User>();

            Iterator<String> exchangeCountrykeys = exchangeCountries.keys();
            while (exchangeCountrykeys.hasNext()) {
                String keyStr = (String)exchangeCountrykeys.next();
                String valueStr = exchangeCountries.getString(keyStr);

                users.add(new User(keyStr, valueStr));
            }
            CustomUsersAdapter adapter = new CustomUsersAdapter(this, users);

            ListView listView = (ListView) findViewById(R.id.listView2);
            listView.setAdapter(adapter);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
    }

    public void putDataToListView(View View)
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

    public void myListView(ArrayList<String> list) {
        final ListView listview = (ListView) findViewById(R.id.listView2);

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        listview.setAdapter(adapter);
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
}
