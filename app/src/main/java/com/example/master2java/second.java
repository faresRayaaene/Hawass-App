package com.example.master2java;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.List;


public class second extends Fragment

{

    private GoogleMap gmp;
    private Marker alg;
    private Marker con;
    private Marker stor;
    private Marker ann;
    private Marker gul;

    public double start_long , end_long , start_lat , end_lat ;


    private LocationManager locationManager;
    private LocationListener locationListener;




    public second() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    private void checkmypermession() {
        Dexter.withContext(getActivity()).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Toast.makeText(getActivity(),"permession Garanted " , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
              /*  Intent intent = new Intent() ;
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS) ;
                Uri uri = Uri.fromParts("package" , getPackageName(),"") ;
                intent.setData(uri) ;
                startActivity(intent) ;*/
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();

    }




/*
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if(ContextCompat.checkSelfPermission(getActivity() ,Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                        0, 0, locationListener);
            }

        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        checkmypermession();

        /* this part concern the Gps location
        locationManager = (LocationManager) this.getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                  //  Log.d("my location" , location.toString()) ;
            }
        };
           //cHECK permession of location
        if (ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this.getActivity() , new String [] {
                   Manifest.permission.ACCESS_FINE_LOCATION
            },3);

        }else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    0, 0, locationListener);

        }*/








        SupportMapFragment map = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.my_map);
        map.getMapAsync(new OnMapReadyCallback() {
            @SuppressLint("MissingPermission")
            @Override
            public void onMapReady(GoogleMap googleMap) {

                List<Marker> markerList = new ArrayList<>() ;
                List<Float> arrayList = new ArrayList<Float>() ;
                float resultsGulema[] = new float[20] ;
                float resultsStora[] = new float[20] ;
                float resultsAnnaba[] = new float[20] ;




                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {

                        LatLng latLng = new LatLng(marker.getPosition().latitude, marker.getPosition().longitude) ;
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng , 16 ));

                        marker.showInfoWindow();
                        end_lat = marker.getPosition().latitude ;
                        end_long  = marker.getPosition().longitude ;
                       /*Toast.makeText(getActivity(),"permession Garanted  "+ end_lat + end_long
                                , Toast.LENGTH_LONG).show();*/


                        return true;
                    }
                });
                Location.distanceBetween(36.242824,6.564584,36.460243 ,7.269562,
                        resultsGulema);



                Location.distanceBetween(36.242824 , 6.564584 , 36.900844 , 6.879083 ,
                        resultsStora);

                Location.distanceBetween(36.242824 , 6.564584 , 36.920805 , 7.763760 ,
                        resultsAnnaba);

                arrayList.add(resultsGulema[0]) ;
                arrayList.add(resultsStora[0]) ;
                //arrayList.add(resultsAnnaba[0]) ;



                Toast.makeText(getActivity(),"the closest city is  : Stora " /*+ arrayList.get(0)*/
                        , Toast.LENGTH_LONG).show();


               /*LatLng cons = new LatLng(36.242903 , 6.563472) ;
                con =  googleMap.addMarker(new MarkerOptions().position(cons)) ;
                con.setTag(0);
                markerList.add(con) ;*/

                googleMap.setMyLocationEnabled(true);
                //Stora
                LatLng stora = new LatLng(36.900844 , 6.879083 ) ;
              stor =   googleMap.addMarker(new MarkerOptions().position(stora).title("Stora"  +  resultsStora[0] )) ;
                stor.setTag(0);
                markerList.add(stor) ;
               // googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cons, 12));

                //Annaba
                LatLng annaba = new LatLng(36.920805 , 7.763760 ) ;
               ann =  googleMap.addMarker(new MarkerOptions().position(annaba).title("Annaba" +  resultsAnnaba[0])) ;
                ann.setTag(0);
                markerList.add(ann) ;
                //googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(annaba, 17));
                //Alger
                LatLng alger = new LatLng(36.745156 ,  3.077096 ) ;
              alg =   googleMap.addMarker(new MarkerOptions().position(alger).title("Alger")) ;
              alg.setTag(0);



                // Distance calculation

                //Geulma
                LatLng gulema = new LatLng(36.460243,  7.269562 ) ;
                gul = googleMap.addMarker(new MarkerOptions().position(gulema).title("Hammam el dbagh" +resultsGulema[0] )) ;
                gul.setTag(0);

                markerList.add(gul) ;
              //  gmp.animateCamera(CameraUpdateFactory.newLatLngZoom(stora, 15));

                for (Marker m : markerList) {
                    LatLng latLng = new LatLng(m.getPosition().latitude, m.getPosition().longitude) ;
                    googleMap.addMarker(new MarkerOptions().position(latLng)) ;
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng , 8 ));
                }


            }


        });
        return view ;
    }


}