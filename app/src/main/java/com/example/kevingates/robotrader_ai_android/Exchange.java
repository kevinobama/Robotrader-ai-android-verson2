package com.example.kevingates.robotrader_ai_android;

/**
 * Created by kevingates on 11/25/17.
 */

import java.util.ArrayList;

public class Exchange {
    //declare private data instead of public to ensure the privacy of data field of each class
    private String exchange;
    private String country;
    private String buy;
    private String sell;

    public Exchange(String exchange, String country, String buy, String sell) {
        this.exchange = exchange;
        this.country = country;
        this.buy = buy;
        this.sell = sell;
    }

    public String getExchange(){
        return exchange;
    }
    public String getCountry(){
        return country;
    }
    public String getBuy(){
        return buy;
    }
    public String getSell(){
        return sell;
    }
}

