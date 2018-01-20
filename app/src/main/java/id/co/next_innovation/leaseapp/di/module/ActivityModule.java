package id.co.next_innovation.leaseapp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

import id.co.next_innovation.leaseapp.data.db.model.Customer;
import id.co.next_innovation.leaseapp.di.ActivityContext;
import id.co.next_innovation.leaseapp.di.PerActivity;
import id.co.next_innovation.leaseapp.ui.detail.DetailMvpPresenter;
import id.co.next_innovation.leaseapp.ui.detail.DetailPresenter;
import id.co.next_innovation.leaseapp.ui.detail.DetailView;
import id.co.next_innovation.leaseapp.ui.help.HelpMvpPresenter;
import id.co.next_innovation.leaseapp.ui.help.HelpPresenter;
import id.co.next_innovation.leaseapp.ui.help.HelpView;
import id.co.next_innovation.leaseapp.ui.home.HomeMvpPresenter;
import id.co.next_innovation.leaseapp.ui.home.HomePagerAdapter;
import id.co.next_innovation.leaseapp.ui.home.HomePresenter;
import id.co.next_innovation.leaseapp.ui.home.HomeView;
import id.co.next_innovation.leaseapp.ui.home.dashboard.DashboardMvpPresenter;
import id.co.next_innovation.leaseapp.ui.home.dashboard.DashboardPresenter;
import id.co.next_innovation.leaseapp.ui.home.dashboard.DashboardView;
import id.co.next_innovation.leaseapp.ui.home.dashboard.customer.CustomerAdapter;
import id.co.next_innovation.leaseapp.ui.more.MoreMvpPresenter;
import id.co.next_innovation.leaseapp.ui.more.MorePresenter;
import id.co.next_innovation.leaseapp.ui.more.MoreView;
import id.co.next_innovation.leaseapp.ui.search.SearchMvpPresenter;
import id.co.next_innovation.leaseapp.ui.search.SearchPresenter;
import id.co.next_innovation.leaseapp.ui.search.SearchView;
import id.co.next_innovation.leaseapp.ui.splash.SplashMvpPresenter;
import id.co.next_innovation.leaseapp.ui.splash.SplashPresenter;
import id.co.next_innovation.leaseapp.ui.splash.SplashView;
import id.co.next_innovation.leaseapp.utils.rx.AppSchedulerProvider;
import id.co.next_innovation.leaseapp.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashView> provideSplashPresenter(
            SplashPresenter<SplashView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    HomeMvpPresenter<HomeView> provideHomePresenter(
            HomePresenter<HomeView> presenter) {
        return presenter;
    }

    @Provides
    DashboardMvpPresenter<DashboardView> provideDashboardPresenter(
            DashboardPresenter<DashboardView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SearchMvpPresenter<SearchView> provideSearchPresenter(
            SearchPresenter<SearchView> presenter) {
        return presenter;
    }

    @Provides
    HomePagerAdapter provideHomePagerAdapter(AppCompatActivity activity) {
        return new HomePagerAdapter(activity, activity.getSupportFragmentManager());
    }

    @Provides
    @PerActivity
    MoreMvpPresenter<MoreView> provideMorePresenter(
            MorePresenter<MoreView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    HelpMvpPresenter<HelpView> provideHelpPresenter(
            HelpPresenter<HelpView> presenter) {
        return presenter;
    }

    @Provides
    CustomerAdapter provideCustomerAdapterOnDashboard() {
        return new CustomerAdapter(new ArrayList<Customer>());
    }

    @Provides
    @PerActivity
    DetailMvpPresenter<DetailView> provideDetailPresenter(
            DetailPresenter<DetailView> presenter) {
        return presenter;
    }
}
