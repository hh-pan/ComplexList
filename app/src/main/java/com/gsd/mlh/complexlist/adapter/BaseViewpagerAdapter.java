package com.gsd.mlh.complexlist.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by Pan on 2018/3/19.
 * Desc:
 */

public class BaseViewpagerAdapter extends FragmentPagerAdapter {

    private final Fragment[] mPageArray;

    public BaseViewpagerAdapter(@NonNull FragmentManager fm, int behavior, Fragment[] pageArray) {
        super(fm, behavior);
        mPageArray = pageArray;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (mPageArray != null){
            return mPageArray[position];
        }
        return null;
    }

    @Override
    public int getCount() {
        if (mPageArray != null) {
            return mPageArray.length;
        }
        return 0;
    }
}
