package com.dadaabcamps.mmarket;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by DAU ICT on 9/16/2016.
 */
public class Message {

    public static void message(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
