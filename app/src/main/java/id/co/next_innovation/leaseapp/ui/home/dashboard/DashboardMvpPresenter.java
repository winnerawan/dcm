package id.co.next_innovation.leaseapp.ui.home.dashboard;

import java.util.List;

import id.co.next_innovation.leaseapp.data.db.model.Customer;
import id.co.next_innovation.leaseapp.ui.base.MvpPresenter;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public interface DashboardMvpPresenter<V extends DashboardView> extends MvpPresenter<V> {

    void onViewPrepared();

    int CustomerCounter();

    List<Customer> loadDataFromDB();

    List<Customer> loadDataFromAPI();
}
