package id.co.next_innovation.leaseapp.ui.home.dashboard;

import com.androidnetworking.error.ANError;

import java.util.List;

import javax.inject.Inject;

import id.co.next_innovation.leaseapp.data.DataManager;
import id.co.next_innovation.leaseapp.data.db.model.Customer;
import id.co.next_innovation.leaseapp.data.network.model.CountResponse;
import id.co.next_innovation.leaseapp.data.network.model.CustomerRequest;
import id.co.next_innovation.leaseapp.data.network.model.CustomersResponse;
import id.co.next_innovation.leaseapp.ui.base.BasePresenter;
import id.co.next_innovation.leaseapp.utils.AppLogger;
import id.co.next_innovation.leaseapp.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class DashboardPresenter<V extends DashboardView> extends BasePresenter<V> implements DashboardMvpPresenter<V> {

    private int count = 0;
    private List<Customer> customers;

    @Inject
    public DashboardPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {

        getMvpView().showLoading();
        count = CustomerCounter();

        if (!getDataManager().isFirstUsing() && getDataManager().getCount()!=0 && getDataManager().getCount()==count) {
            getMvpView().showCustomer(loadDataFromDB());
            getMvpView().showSizeCustomer(String.valueOf(count));
            getMvpView().hideLoading();
        } else {
            loadDataFromAPI();
            getMvpView().showSizeCustomer(String.valueOf(count));
            getMvpView().hideLoading();

        }
    }

    @Override
    public int CustomerCounter() {
        getCompositeDisposable().add(getDataManager().counter()
                .observeOn(getSchedulerProvider().ui())
                .subscribeOn(getSchedulerProvider().io())
                .subscribe(countResponse -> {
                    if (countResponse!=null) {
                        count = countResponse.getCount();
                    }
                }, throwable -> {

                }));

        AppLogger.e("COUNT "+count);
        return count;
    }


    @Override
    public List<Customer> loadDataFromDB() {
        return getDataManager().getAllCustomerFromDB();
    }

    @Override
    public List<Customer> loadDataFromAPI() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager().getAllCustomer(new CustomerRequest.All())
                .observeOn(getSchedulerProvider().ui())
                .subscribeOn(getSchedulerProvider().io())
                .subscribe(customersResponse -> {
                    if (!customersResponse.getError()) {

                        customers = customersResponse.getCustomers();
                        getMvpView().showCustomer(customers);
                        getMvpView().showSizeCustomer(String.valueOf(customers.size()));

                        getDataManager().insertAllCustomer(customers);
                        getDataManager().setCount(customers.size());

                        getDataManager().setFirstUsing(false);
                    }
                    getMvpView().hideLoading();

                }, throwable -> {
                    if (!isViewAttached()) {
                        return;
                    }

                    getMvpView().hideLoading();

                    // handle the error here
                    if (throwable instanceof ANError) {
                        ANError anError = (ANError) throwable;
                        handleApiError(anError);
                    }
                }));

        return customers;
    }
}
