package com.example.kevingates.robotrader_ai_android;

/**
 * Created by kevingates on 11/25/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomCryptoAdapter extends ArrayAdapter<User> {
    public CustomCryptoAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.market_prices_crypto_listview, parent, false);
        }

        // Get the data item for this position
        User user = getItem(position);

        TextView exchange = (TextView) convertView.findViewById(R.id.exchange);
        TextView sell = (TextView) convertView.findViewById(R.id.sell);

        exchange.setText(user.getName());
        sell.setText(user.getHometown());

        return convertView;
    }
}
