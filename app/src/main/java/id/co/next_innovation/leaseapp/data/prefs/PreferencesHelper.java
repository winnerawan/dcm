package id.co.next_innovation.leaseapp.data.prefs;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public interface PreferencesHelper {

    boolean isLoggedIn();
    void setLoggedIn(boolean loggedIn);

    void setCount(int count);
    int getCount();

    void setFirstUsing(boolean firstUsing);
    boolean isFirstUsing();
}
