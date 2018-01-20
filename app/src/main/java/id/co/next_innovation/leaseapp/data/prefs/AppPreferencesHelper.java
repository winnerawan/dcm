package id.co.next_innovation.leaseapp.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.co.next_innovation.leaseapp.di.ApplicationContext;
import id.co.next_innovation.leaseapp.di.PreferenceInfo;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private static final String KEY_LOGGED_IN = "KEY_LOGGED_IN";
    private static final String KEY_CLIENT_ID = "KEY_CLIENT_ID";
    private static final String KEY_CLIENT_SECRET = "KEY_CLIENT_SECRET";
    private static final String KEY_CONTENT_TYPE = "KEY_CONTENT_TYPE";

    private static final String KEY_FIRST = "KEY_FIRST";

    private static final String KEY_COUNT = "KEY_COUNT";



    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public boolean isLoggedIn() {
        return mPrefs.getBoolean(KEY_LOGGED_IN, false);
    }

    @Override
    public void setLoggedIn(boolean loggedIn) {
        mPrefs.edit().putBoolean(KEY_LOGGED_IN, loggedIn).apply();
    }

    @Override
    public void setCount(int count) {
        mPrefs.edit().putInt(KEY_COUNT, count).apply();
    }

    @Override
    public int getCount() {
        return mPrefs.getInt(KEY_COUNT, 0);
    }

    @Override
    public void setFirstUsing(boolean firstUsing) {
        mPrefs.edit().putBoolean(KEY_FIRST, firstUsing).apply();
    }

    @Override
    public boolean isFirstUsing() {
        return mPrefs.getBoolean(KEY_FIRST, true);
    }
}
