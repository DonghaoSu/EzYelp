package com.codingdemos.tablayout;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabItem tabMap;
    TabItem tabList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle(getResources().getString(R.string.app_name));
//        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tablayout);
        tabMap = findViewById(R.id.tabMap);
        tabList = findViewById(R.id.tabList);
        viewPager = findViewById(R.id.viewPager);
        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
//                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
//                            R.color.colorAccent));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorAccent));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                R.color.colorAccent));
                    }
                } else if (tab.getPosition() == 2) {
//                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
//                            android.R.color.darker_gray));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            android.R.color.darker_gray));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                android.R.color.darker_gray));
                    }
                } else {
//                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
//                            R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorPrimary));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                R.color.colorPrimaryDark));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }



//    public  void onClick(View v) {
////        Object transferData[] = new Object[2];
////        GetNearByPlaces getNearbyPlaces = new GetNearByPlaces();
//
//        googleMapFragment = (GoogleMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        GoogleMap mMap = googleMapFragment.mMap;
//        if (v.getId() == R.id.search_address) {
//            EditText addressField = (EditText) findViewById(R.id.location_search);
//            String address = addressField.getText().toString();
//            List<Address> addressList = null;
//            MarkerOptions userMarkerOptions = new MarkerOptions();
//            if (!TextUtils.isEmpty(address)) {
//                Geocoder geocoder = new Geocoder(this);
//
//                try {
//                    addressList = geocoder.getFromLocationName(address, 5);
//                    if (addressList != null) {
//                        for (int i = 0; i < addressList.size(); i++) {
//                            Address userAddress = addressList.get(i);
//                            LatLng latLng = new LatLng(userAddress.getLatitude(), userAddress.getLongitude());
//
//                            userMarkerOptions.position(latLng);
//                            userMarkerOptions.title(address);
//                            userMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
//                            mMap.addMarker(userMarkerOptions);
//                            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//                            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
//                        }
//                    } else {
//                        Toast.makeText(this, "Location not found...", Toast.LENGTH_SHORT).show();
//
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                Toast.makeText(this, "Please enter an address", Toast.LENGTH_SHORT).show();
//            }
//        }
//
////                mMap.clear();
////                String url = getUrl(latitide, longitude, "restaurant");
////                transferData[0] = mMap;
////                transferData[1] = url;
////
////                getNearbyPlaces.execute(transferData);
////                Toast.makeText(this, "Searching for Nearby Restaurants...", Toast.LENGTH_SHORT).show();
////                Toast.makeText(this, "Showing Nearby Restaurants...", Toast.LENGTH_SHORT).show();
//    }
//
}
