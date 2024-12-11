package com.foreground.plugin;

import android.util.Log;

public class ForegroundPlugin {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
