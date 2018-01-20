package id.co.next_innovation.leaseapp.ui.detail;

import id.co.next_innovation.leaseapp.data.db.model.Customer;
import id.co.next_innovation.leaseapp.ui.base.MvpPresenter;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public interface DetailMvpPresenter<V extends DetailView> extends MvpPresenter<V> {

    Customer getCustomerDetail(int id);
}
