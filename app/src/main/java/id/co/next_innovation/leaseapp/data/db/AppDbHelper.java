package id.co.next_innovation.leaseapp.data.db;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.co.next_innovation.leaseapp.data.db.model.Customer;
import id.co.next_innovation.leaseapp.data.db.model.CustomerDao;
import id.co.next_innovation.leaseapp.data.db.model.DaoMaster;
import id.co.next_innovation.leaseapp.data.db.model.DaoSession;


/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();

    }

    @Override
    public void insertAllCustomer(List<Customer> customers) {
        for (int i = 0; i<customers.size(); i++) {
            mDaoSession.getCustomerDao().insert(customers.get(i));
        }
    }

    @Override
    public List<Customer> getAllCustomerFromDB() {
//        if (mDaoSession.getCustomerDao()!=null) {
//            return mDaoSession.getCustomerDao().loadAll();
//        }
        return mDaoSession.getCustomerDao().loadAll();
    }

    @Override
    public Customer getCustomerByID(int id) {
        return mDaoSession.getCustomerDao().queryBuilder()
                .where(CustomerDao.Properties.Id.eq(id))
                .list().get(0);
    }
}
