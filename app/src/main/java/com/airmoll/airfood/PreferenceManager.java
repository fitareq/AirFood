package com.airmoll.airfood;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor spEditor;
    private Context context;
    private static final String FIRST_LAUNCH = "firstLaunch";
    private int mode = 0;
    private static final String PREFERENCE = "Airmoll";

    public PreferenceManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFERENCE,mode);
        spEditor = sharedPreferences.edit();
    }
    public void setFirstLaunch(boolean isFirstLaunch)
    {
        spEditor.putBoolean(FIRST_LAUNCH,isFirstLaunch);
        spEditor.commit();
    }
    public boolean FirstLaunch()
    {
        return sharedPreferences.getBoolean(FIRST_LAUNCH,true);
    }
}
