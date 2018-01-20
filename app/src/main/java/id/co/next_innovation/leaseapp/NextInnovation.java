package id.co.next_innovation.leaseapp;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import id.co.next_innovation.leaseapp.BuildConfig;
import id.co.next_innovation.leaseapp.data.DataManager;
import id.co.next_innovation.leaseapp.data.network.ApiEndPoint;
import id.co.next_innovation.leaseapp.di.component.ApplicationComponent;
import id.co.next_innovation.leaseapp.di.component.DaggerApplicationComponent;
import id.co.next_innovation.leaseapp.di.module.ApplicationModule;
import id.co.next_innovation.leaseapp.utils.AppLogger;


import javax.inject.Inject;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class NextInnovation extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }


}
