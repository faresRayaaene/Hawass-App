package com.example.master2java;

import android.Manifest;
import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


public class third extends Fragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks ,
        GoogleApiClient.OnConnectionFailedListener ,View.OnClickListener{

    boolean isPermissionGranted ;
    SupportMapFragment map ;
    GoogleMap gmap ;
    FloatingActionButton floatb ;
    private FusedLocationProviderClient mLocationClient ;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third,container,false) ;
        floatb = (FloatingActionButton) view.findViewById(R.id.floatb) ;

        //  mapView =  getChildFragmentManager().findFragmentById(R.id.my_map2);


        checkmypermession();
        initMap() ;
        mLocationClient = new FusedLocationProviderClient(getActivity()) ;
        floatb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 getCurrLoc() ;
            }
        });



        // Inflate the layout for this fragment

        return view ;
    }

    @SuppressLint("MissingPermission")
    private void getCurrLoc() {
        mLocationClient.getLastLocation().addOnCompleteListener((task -> {
            if(task.isSuccessful()) {
                Location loaction = task.getResult();
                goeLocation(loaction.getLatitude(), loaction.getLongitude()) ;


            }
        } )) ;
    }

    private void goeLocation(double latitude, double longitude) {
        LatLng latLng = new LatLng(latitude,longitude) ;
        CameraUpdate cameraUpdateFactory = CameraUpdateFactory.newLatLngZoom(latLng, 18) ;
        gmap.moveCamera(cameraUpdateFactory);
        gmap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    private void initMap() {
        if(isPermissionGranted) {
            map = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.my_map2);
            map.getMapAsync(this);
        }
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


    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap.setMyLocationEnabled(true);
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    @Override
    public void onClick(View v) {

    }
}