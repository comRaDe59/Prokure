package com.example.khyati.prokureii;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by khyati on 9/29/2015.
 */
public class PrefUtils {
    private static final String CART_AMOUNT = "CartAmount";

    public static int getCartCount(final Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getInt(CART_AMOUNT,-1);
    }

    public static void setCartCount(final Context context,int count){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putInt(CART_AMOUNT,count).commit();
    }


}
