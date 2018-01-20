package id.co.next_innovation.leaseapp.ui.help;

import javax.inject.Inject;

import id.co.next_innovation.leaseapp.data.DataManager;
import id.co.next_innovation.leaseapp.ui.base.BasePresenter;
import id.co.next_innovation.leaseapp.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class HelpPresenter<V extends HelpView> extends BasePresenter<V> implements HelpMvpPresenter<V> {

    @Inject
    public HelpPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
