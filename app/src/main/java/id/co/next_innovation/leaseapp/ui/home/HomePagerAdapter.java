package id.co.next_innovation.leaseapp.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import id.co.next_innovation.leaseapp.R;
import id.co.next_innovation.leaseapp.ui.home.dashboard.DashboardFragment;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;
    private AppCompatActivity activity;

    public HomePagerAdapter(AppCompatActivity mActivity, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.activity = mActivity;
        this.mTabCount=1;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return DashboardFragment.newInstance();
            default:
                return DashboardFragment.newInstance();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return activity.getString(R.string.dashboard);
            default:
                return activity.getString(R.string.dashboard);
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }
}
