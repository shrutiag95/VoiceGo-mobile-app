package com.recyclerinfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by hpuser on 02-06-2016.
 */
public class MyFragPagerAdapter extends FragmentPagerAdapter
{

    ArrayList<Fragment> pages =  new ArrayList<>();

    public MyFragPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {


        return pages.size();
    }

    public void addPAge(Fragment f){
        pages.add(f);
    }

    //Setting Tab title

    @Override
    public CharSequence getPageTitle(int position) {

        return pages.get(position).toString();
    }
}
