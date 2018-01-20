package id.co.next_innovation.leaseapp.data.network;

import id.co.next_innovation.leaseapp.data.network.model.CountResponse;
import id.co.next_innovation.leaseapp.data.network.model.CustomerRequest;
import id.co.next_innovation.leaseapp.data.network.model.CustomersResponse;
import id.co.next_innovation.leaseapp.data.network.model.SignRequest;
import id.co.next_innovation.leaseapp.data.network.model.SignResponse;
import io.reactivex.Observable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public interface ApiHelper {

    ApiHeader getApiHeader();
    AppKey getAppKey();
    String getDecodeUrl();
    AppParams getAppParams();
    Observable<SignResponse.In> postAuthentication(SignRequest.In request);
    Observable<SignResponse.Up> postSignUp(SignRequest.Up request);
    Observable<CustomersResponse> getAllCustomer(CustomerRequest.All request);
    Observable<CountResponse> counter();
}
