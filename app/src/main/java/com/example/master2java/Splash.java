package com.example.master2java;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread th = new Thread() {
            @Override
            public void run() {
                try { sleep(3000); }
                catch (Exception e) { e.printStackTrace();}
                finally {
                    startActivity(new Intent(Splash.this , MainActivity.class));
                }

            }
        } ;
        th.start();



    }

}
