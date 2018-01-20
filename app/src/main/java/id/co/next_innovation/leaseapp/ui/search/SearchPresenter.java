package id.co.next_innovation.leaseapp.ui.search;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import id.co.next_innovation.leaseapp.data.DataManager;
import id.co.next_innovation.leaseapp.data.db.model.Customer;
import id.co.next_innovation.leaseapp.ui.base.BasePresenter;
import id.co.next_innovation.leaseapp.utils.AppLogger;
import id.co.next_innovation.leaseapp.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class SearchPresenter<V extends SearchView> extends BasePresenter<V> implements SearchMvpPresenter<V> {

    @Inject
    public SearchPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void showCustomerFromDB() {

        getMvpView().showLoading();

        getMvpView().showCustomer(getDataManager().getAllCustomerFromDB());

        AppLogger.e("Log"+ new Gson().toJson(getDataManager().getAllCustomerFromDB()));
        getMvpView().hideLoading();

    }
}
