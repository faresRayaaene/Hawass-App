package com.example.master2java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageadapter extends FragmentPagerAdapter {
    private  int tabsNumber ;


    public pageadapter(@NonNull FragmentManager fm, int behavior , int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs ;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case  0 : return new first() ;
            case  1 : return new second();
            case 2 : return new third() ;
            default: return null ;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
