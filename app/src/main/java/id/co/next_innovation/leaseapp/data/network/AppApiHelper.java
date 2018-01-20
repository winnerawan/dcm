package id.co.next_innovation.leaseapp.data.network;

import android.util.Base64;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.co.next_innovation.leaseapp.data.network.model.CountResponse;
import id.co.next_innovation.leaseapp.data.network.model.CustomerRequest;
import id.co.next_innovation.leaseapp.data.network.model.CustomersResponse;
import id.co.next_innovation.leaseapp.data.network.model.SignRequest;
import id.co.next_innovation.leaseapp.data.network.model.SignResponse;
import id.co.next_innovation.leaseapp.utils.AppLogger;
import io.reactivex.Observable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;
    private AppKey mKey;
    private AppParams mParams;

    @Inject
    public AppApiHelper(ApiHeader apiHeader, AppKey key, AppParams params) {
        mApiHeader = apiHeader;
        mKey = key;
        mParams = params;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public AppKey getAppKey() {
        return mKey;
    }

    @Override
    public AppParams getAppParams() {
        return mParams;
    }

    @Override
    public String getDecodeUrl() {
        return new String(Base64.decode(getAppKey().invokeNativeFunction(), Base64.DEFAULT));
    }

    @Override
    public Observable<SignResponse.In> postAuthentication(SignRequest.In request) {
        return Rx2AndroidNetworking.post(getDecodeUrl() + "")
                .addBodyParameter(request)
                .build()
                .getObjectObservable(SignResponse.In.class);
    }

    @Override
    public Observable<SignResponse.Up> postSignUp(SignRequest.Up request) {
        return Rx2AndroidNetworking.post(getDecodeUrl() + "")
                .addBodyParameter(request)
                .build()
                .getObjectObservable(SignResponse.Up.class);
    }

    @Override
    public Observable<CustomersResponse> getAllCustomer(CustomerRequest.All request) {
        return Rx2AndroidNetworking.get(getDecodeUrl() + "/customers")
                .build()
                .getObjectObservable(CustomersResponse.class);
    }

    @Override
    public Observable<CountResponse> counter() {
        return Rx2AndroidNetworking.get(getDecodeUrl()+"/count")
                .build()
                .getObjectObservable(CountResponse.class);
    }
}
