package id.co.next_innovation.leaseapp.data.db;


import java.util.List;

import id.co.next_innovation.leaseapp.data.db.model.Customer;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public interface DbHelper {

    void insertAllCustomer(List<Customer> customers);
    List<Customer> getAllCustomerFromDB();
    Customer getCustomerByID(int id);
}
