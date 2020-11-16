package com.example.projectmobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setUsername(String usename) {
        prefs.edit().putString("usename", usename).commit();
    }

    public String getUsername() {
        String usename = prefs.getString("usename","");
        return usename;
    }
}
