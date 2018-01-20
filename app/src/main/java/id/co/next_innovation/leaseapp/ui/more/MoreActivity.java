package id.co.next_innovation.leaseapp.ui.more;

import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import id.co.next_innovation.leaseapp.R;
import id.co.next_innovation.leaseapp.ui.base.BaseActivity;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class MoreActivity extends BaseActivity implements MoreView {

    @Inject
    MoreMvpPresenter<MoreView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        getActivityComponent().inject(this);
        overridePendingTransition(R.anim.anim_pop_up, R.anim.anim_push_up);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();

    }


    @Override
    protected void setUp() {

    }

    private void finishAction() {
        finish();
        overridePendingTransition(R.anim.anim_pop_down, R.anim.anim_push_down);
    }

    public void onBackPressed() {
        finishAction();
    }
}
