package id.co.next_innovation.leaseapp.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

import id.co.next_innovation.leaseapp.NextInnovation;
import id.co.next_innovation.leaseapp.data.DataManager;
import id.co.next_innovation.leaseapp.di.ApplicationContext;
import id.co.next_innovation.leaseapp.di.module.ApplicationModule;
import id.co.next_innovation.leaseapp.service.SyncService;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(NextInnovation app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();}
