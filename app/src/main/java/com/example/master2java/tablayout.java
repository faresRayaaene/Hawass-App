package com.example.master2java;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tablayout#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tablayout extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    ViewPager pager ;

    TabLayout tablayout ;
    TabItem first , second , third ;

    PagerAdapter adapt ;
    FragmentManager fm ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tablayout() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tablayout.
     */
    // TODO: Rename and change types and number of parameters
    public static tablayout newInstance(String param1, String param2) {
        tablayout fragment = new tablayout();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getParentFragmentManager() ;
       // Fragment fragment = new third() ;
      //  fm.beginTransaction().replace(R.id.frameLayout , new second() ).commit();

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tablayout, container, false);


      pager =(ViewPager) v.findViewById(R.id.view_pager2);
        tablayout = (TabLayout) v.findViewById(R.id.tablayoutt) ;
        first = (TabItem)v.findViewById(R.id.places) ;
        second = (TabItem)v.findViewById(R.id.maps) ;
        third=(TabItem)v.findViewById(R.id.reviews) ;



        adapt = new pageadapter(getParentFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tablayout.getTabCount());
       pager.setAdapter(adapt);// pour synchroniser avec l'état du drawer ouvert ou fermé

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
      pager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener(tablayout));


        return v ;


    }
}