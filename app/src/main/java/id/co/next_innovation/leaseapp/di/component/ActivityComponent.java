package id.co.next_innovation.leaseapp.di.component;

import dagger.Component;
import id.co.next_innovation.leaseapp.di.PerActivity;
import id.co.next_innovation.leaseapp.di.module.ActivityModule;
import id.co.next_innovation.leaseapp.ui.detail.DetailActivity;
import id.co.next_innovation.leaseapp.ui.help.HelpActivity;
import id.co.next_innovation.leaseapp.ui.home.HomeActivity;
import id.co.next_innovation.leaseapp.ui.home.dashboard.DashboardFragment;
import id.co.next_innovation.leaseapp.ui.more.MoreActivity;
import id.co.next_innovation.leaseapp.ui.search.SearchActivity;
import id.co.next_innovation.leaseapp.ui.splash.SplashActivity;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity activity);
    void inject(HomeActivity activity);
    void inject(SearchActivity activity);
    void inject(MoreActivity activity);
    void inject(HelpActivity activity);
    void inject(DetailActivity activity);


    void inject(DashboardFragment fragment);

}
