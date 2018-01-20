package id.co.next_innovation.leaseapp.di.module;

import android.app.Application;
import android.content.Context;



import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import id.co.next_innovation.leaseapp.data.AppDataManager;
import id.co.next_innovation.leaseapp.data.DataManager;
import id.co.next_innovation.leaseapp.data.db.AppDbHelper;
import id.co.next_innovation.leaseapp.data.db.DbHelper;
import id.co.next_innovation.leaseapp.data.network.ApiHeader;
import id.co.next_innovation.leaseapp.data.network.ApiHelper;
import id.co.next_innovation.leaseapp.data.network.AppApiHelper;
import id.co.next_innovation.leaseapp.data.network.AppKey;
import id.co.next_innovation.leaseapp.data.network.AppParams;
import id.co.next_innovation.leaseapp.data.prefs.AppPreferencesHelper;
import id.co.next_innovation.leaseapp.data.prefs.PreferencesHelper;
import id.co.next_innovation.leaseapp.di.ApplicationContext;
import id.co.next_innovation.leaseapp.di.DatabaseInfo;
import id.co.next_innovation.leaseapp.di.PreferenceInfo;
import id.co.next_innovation.leaseapp.utils.AppConstants;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader provideApiHeader(DbHelper header) {
//        if (header==null || header.getNasabah()==null) {
//            return new ApiHeader("");
//        }
        return new ApiHeader("");
    }

    @Provides
    @Singleton
    AppKey provideAppKey() {
        return new AppKey();
    }

    @Provides
    @Singleton
    AppParams provideAppParams() {
        return new AppParams();
    }

}
