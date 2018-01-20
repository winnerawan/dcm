package id.co.next_innovation.leaseapp.data;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.co.next_innovation.leaseapp.data.db.DbHelper;
import id.co.next_innovation.leaseapp.data.db.model.Customer;
import id.co.next_innovation.leaseapp.data.network.ApiHeader;
import id.co.next_innovation.leaseapp.data.network.ApiHelper;
import id.co.next_innovation.leaseapp.data.network.AppKey;
import id.co.next_innovation.leaseapp.data.network.AppParams;
import id.co.next_innovation.leaseapp.data.network.model.CountResponse;
import id.co.next_innovation.leaseapp.data.network.model.CustomerRequest;
import id.co.next_innovation.leaseapp.data.network.model.CustomersResponse;
import id.co.next_innovation.leaseapp.data.network.model.SignRequest;
import id.co.next_innovation.leaseapp.data.network.model.SignResponse;
import id.co.next_innovation.leaseapp.data.prefs.PreferencesHelper;
import id.co.next_innovation.leaseapp.di.ApplicationContext;
import io.reactivex.Observable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public AppKey getAppKey() {
        return mApiHelper.getAppKey();
    }

    @Override
    public Observable<SignResponse.In> postAuthentication(SignRequest.In request) {
        return mApiHelper.postAuthentication(request);
    }

    @Override
    public Observable<SignResponse.Up> postSignUp(SignRequest.Up request) {
        return mApiHelper.postSignUp(request);
    }

    @Override
    public String getDecodeUrl() {
        return mApiHelper.getDecodeUrl();
    }

    @Override
    public AppParams getAppParams() {
        return mApiHelper.getAppParams();
    }

    @Override
    public boolean isLoggedIn() {
        return mPreferencesHelper.isLoggedIn();
    }

    @Override
    public void setLoggedIn(boolean loggedIn) {
        mPreferencesHelper.setLoggedIn(loggedIn);
    }

    @Override
    public Observable<CustomersResponse> getAllCustomer(CustomerRequest.All request) {
        return mApiHelper.getAllCustomer(request);
    }

    @Override
    public void insertAllCustomer(List<Customer> customers) {
        mDbHelper.insertAllCustomer(customers);
    }

    @Override
    public List<Customer> getAllCustomerFromDB() {
        return mDbHelper.getAllCustomerFromDB();
    }

    @Override
    public void setCount(int count) {
        mPreferencesHelper.setCount(count);
    }

    @Override
    public int getCount() {
        return mPreferencesHelper.getCount();
    }

    @Override
    public Observable<CountResponse> counter() {
        return mApiHelper.counter();
    }

    @Override
    public void setFirstUsing(boolean firstUsing) {
        mPreferencesHelper.setFirstUsing(firstUsing);
    }

    @Override
    public boolean isFirstUsing() {
        return mPreferencesHelper.isFirstUsing();
    }

    @Override
    public Customer getCustomerByID(int id) {
        return mDbHelper.getCustomerByID(id);
    }
}
