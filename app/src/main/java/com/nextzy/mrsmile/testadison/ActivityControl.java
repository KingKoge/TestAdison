package com.nextzy.mrsmile.testadison;

import android.support.v4.app.Fragment;

/**
 * Created by nextzy on 8/24/2016 AD.
 */
public interface ActivityControl {

    void addFragment(Fragment fragment);
    void finishThis();
    void onBackPressed();
}
