package com.example.master2java;

import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class home_two extends AppCompatActivity {

    private TextView mTextView;
    NavigationView nav ;
    DrawerLayout drawer ;
    Toolbar toolbar ;
    ActionBarDrawerToggle toggle ;
    FragmentManager fm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_two);
        drawer = findViewById(R.id.drawer) ;
        nav = findViewById(R.id.navigationView) ;
        toolbar = findViewById(R.id.topAppbar) ;
        fm = getSupportFragmentManager() ;

/*toolbar.setNavigationOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
            drawer.openDrawer(GravityCompat.START);
    }
});*/
        toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close) ;
        drawer.addDrawerListener(toggle);

        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();


nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId() ;
        // if the user click any place the drawer will be closed
        drawer.closeDrawer(GravityCompat.START);
        switch (id) {
            case R.id.serv :
                fm.beginTransaction().replace(R.id.frameLayout , new first() ).commit();
                break;
            case R.id.menu_item :
                fm.beginTransaction().replace(R.id.frameLayout , new tablayout() ).commit();
                break;

            case R.id.about :
                fm.beginTransaction().replace(R.id.frameLayout , new second()).commit();
                break ;


            default:
                return true ;
        }

        return true ;
    }

});

        //mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on

    }
}