package id.co.next_innovation.leaseapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.astuetz.PagerSlidingTabStrip;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.next_innovation.leaseapp.R;
import id.co.next_innovation.leaseapp.ui.base.BaseActivity;
import id.co.next_innovation.leaseapp.ui.help.HelpActivity;
import id.co.next_innovation.leaseapp.ui.more.MoreActivity;
import id.co.next_innovation.leaseapp.ui.search.SearchActivity;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class HomeActivity extends BaseActivity implements HomeView {

    @Inject
    HomeMvpPresenter<HomeView> mPresenter;

    @Inject
    HomePagerAdapter mHomeAdapter;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @BindView(R.id.tabs)
    PagerSlidingTabStrip mTabs;

    //btn_icons
    @BindView(R.id.btn_home) ImageView icHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();

        mTabs.setViewPager(mViewPager);
    }

    @OnClick(R.id.f_btn_search)
    void search() {
        startActivity(new Intent(this, SearchActivity.class));
    }

    @OnClick(R.id.f_btn_help)
    void help(){
        startActivity(new Intent(this, HelpActivity.class));
    }

    @OnClick(R.id.f_btn_more)
    void more() {
        startActivity(new Intent(this, MoreActivity.class));
    }

    @Override
    protected void setUp() {
        mHomeAdapter.setCount(1);
        mViewPager.setAdapter(mHomeAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(1);
        mTabs.setViewPager(mViewPager);
    }
}
