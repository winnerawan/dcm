package id.co.next_innovation.leaseapp.ui.home.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.next_innovation.leaseapp.NextInnovation;
import id.co.next_innovation.leaseapp.R;
import id.co.next_innovation.leaseapp.data.db.model.Customer;
import id.co.next_innovation.leaseapp.di.component.ActivityComponent;
import id.co.next_innovation.leaseapp.ui.base.BaseFragment;
import id.co.next_innovation.leaseapp.ui.home.dashboard.customer.CustomerAdapter;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class DashboardFragment extends BaseFragment implements DashboardView {

    @Inject
    DashboardMvpPresenter<DashboardView> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @Inject
    CustomerAdapter mAdapter;

    @BindView(R.id.recyclerview_dashboard)
    RecyclerView mRecyclerView;

    @BindView(R.id.count_customer)
    TextView mCount;

    public static DashboardFragment newInstance() {
        Bundle args = new Bundle();
        DashboardFragment fragment = new DashboardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            //mAdapter.setCallback(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.onViewPrepared();
    }

    @Override
    public void showCustomer(List<Customer> customers) {
        mAdapter.addItems(customers);
    }

    @Override
    public void showSizeCustomer(String count) {
        mCount.setText(count +" " +getString(R.string.customer));
    }
}
