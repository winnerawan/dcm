package id.co.next_innovation.leaseapp.ui.search;

import java.util.List;

import id.co.next_innovation.leaseapp.data.db.model.Customer;
import id.co.next_innovation.leaseapp.ui.base.MvpView;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public interface SearchView extends MvpView {

    List<Customer> filterCustomer(List<Customer> customers, String query);

    void showCustomer(List<Customer> customers);

}
