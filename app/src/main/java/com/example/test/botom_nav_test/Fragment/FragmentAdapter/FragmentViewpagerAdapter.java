package com.example.test.botom_nav_test.Fragment.FragmentAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentViewpagerAdapter extends FragmentPagerAdapter {

    public final List<Fragment> fragmentList = new ArrayList<>();
    public final List<String> fragmentListTitles = new ArrayList<>();

    public FragmentViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    /*public FragmentViewpagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }*/
    /*public FragmentPagerAdapter(FragmentManager fm, int behavior) {

    }*/

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentListTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitles.get(position);
    }

    public void AddFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentListTitles.add(title);
    }
}