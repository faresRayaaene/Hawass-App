package com.example.master2java;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener;

import java.util.ArrayList;
import java.util.List;

public class home  extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer ;
    ActionBarDrawerToggle toggle ;
    NavigationView navigationView ;

    FragmentManager fm ;

    ViewPager pager ;

    TabLayout tablayout ;
    TabItem first , second , third ;

   // Fragment other ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        PagerAdapter adapt ;
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drwaer) ;
        navigationView = (NavigationView) findViewById(R.id.navigationView) ;
        navigationView.setNavigationItemSelectedListener(this);
        fm = getSupportFragmentManager() ;

        pager = findViewById(R.id.view_pager) ;
        tablayout = (TabLayout) findViewById(R.id.TabLayout) ;
        first = findViewById(R.id.first) ;
        second = findViewById(R.id.second) ;
        third= findViewById(R.id.third) ;

        //other = findViewById(R.id.other) ;
      adapt = new pageadapter(getSupportFragmentManager() , FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tablayout.getTabCount());
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


        toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open, R.string.close) ;
        drawer.addDrawerListener(toggle);

        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();


    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);

       /* switch (item.getItemId()){
            case R.id.serv : fm.beginTransaction().replace(R.id.including , new home() ).commit();
            break;
            case R.id.menu_item: fm.beginTransaction().replace(R.id.including , new first()).commit();
                break ;
            case R.id.about: fm.beginTransaction().replace(R.id.including , new third()).commit();
                break ;

            default:
                setTitle('f');

        }*/

        return false;



      /*  if(item.getItemId() == R.id.serv ){
            Toast.makeText(this,"Services is clicked" , Toast.LENGTH_SHORT).show();

        }
        if(item.getItemId() == R.id.menu_item ){
            Toast.makeText(this,"Account is clicked" , Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.about ){
            Toast.makeText(this,"Maps is clicked" , Toast.LENGTH_SHORT).show();
        }*/



    }

   // MenuItem menuNav = (MenuItem) NavigationView.getMenu();

   //NavigationView.getMenu().performIdentifierAction(R.id.first,0) ;

    // navNV.getMenu ().performIdentifierAction (R.id.nav_first, 0);
}
