package id.co.next_innovation.leaseapp.ui.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.next_innovation.leaseapp.R;
import id.co.next_innovation.leaseapp.data.db.model.Customer;
import id.co.next_innovation.leaseapp.ui.base.BaseActivity;
import id.co.next_innovation.leaseapp.ui.home.dashboard.customer.CustomerAdapter;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class SearchActivity extends BaseActivity implements SearchView {

    @Inject
    SearchMvpPresenter<SearchView> mPresenter;

    @Inject
    CustomerAdapter mAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.recyclerview_search)
    RecyclerView mRecyclerView;

    @BindView(R.id.txt_search)
    TextView mSearch;

    private List<Customer> mCustomers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getActivityComponent().inject(this);
        overridePendingTransition(R.anim.anim_pop_up, R.anim.anim_push_up);
        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();

        mSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (mCustomers != null) {
                    final List<Customer> filteredCustomer = filterCustomer(mCustomers, mSearch.getText()
                            .toString().toLowerCase());
                    mAdapter = new CustomerAdapter(filteredCustomer);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    @OnClick(R.id.img_close)
    void close() {
        finishAction();
    }

    @Override
    protected void setUp() {
        mRecyclerView.setLayoutManager(mLayoutManager);
        mPresenter.showCustomerFromDB();

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showCustomer(List<Customer> customers) {
        mAdapter.addItems(customers);
        mCustomers = customers;
    }

    @Override
    public List<Customer> filterCustomer(List<Customer> customers, String query) {
        query = query.toLowerCase();
        final List<Customer> filteredModelList = new ArrayList<>();
        for (Customer model : customers) {
            final String customer_name = model.getStnk().toLowerCase();
            final String customer_nopol = model.getNopol();
            final String customer_unit = model.getUnit().toLowerCase();

            final String customer_noka = model.getNoka().toLowerCase();
            final String customer_nosin = model.getNosin();
            final String customer_bank = model.getBank().toLowerCase();
            final String customer_cabang = model.getCabang().toLowerCase();

            if (customer_name.contains(query) || customer_nopol.contains(query) || customer_unit.contains(query)
                    || customer_noka.contains(query) || customer_nosin.contains(query) || customer_bank.contains(query)
                    || customer_cabang.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    private void finishAction() {
        finish();
        overridePendingTransition(R.anim.anim_pop_down, R.anim.anim_push_down);
    }

    public void onBackPressed() {
        finishAction();
    }

}
