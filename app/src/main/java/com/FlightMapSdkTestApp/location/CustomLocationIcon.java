package com.FlightMapSdkTestApp.location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Toast;

import com.FlightMapSdkTestApp.R;

import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.LocationComponentOptions;

import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import java.util.List;

public class CustomLocationIcon extends AppCompatActivity implements OnMapReadyCallback{

    private MapView mapView;
    private MapboxMap mFlightMap;
    private PermissionsManager permissionsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_location_icon);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        if (PermissionsManager.areLocationPermissionsGranted(this)) {
            mapView.getMapAsync(this);
        } else {
            permissionsManager = new PermissionsManager(new PermissionsListener() {
                @Override
                public void onExplanationNeeded(List<String> permissionsToExplain) {
                    Toast.makeText(CustomLocationIcon.this, "You need to accept location permissions.",
                            Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPermissionResult(boolean granted) {
                    if (granted) {
                        mapView.getMapAsync(CustomLocationIcon.this);
                    } else {
                        finish();
                    }
                }
            });
            permissionsManager.requestLocationPermissions(this);
        }
    }


    @Override
    public void onMapReady(@NonNull MapboxMap flightmap) {
        this.mFlightMap = flightmap;
        flightmap.getUiSettings().setCompassEnabled(false);
        flightmap.setStyle(Style.DARK,
                style -> enableLocationComponent(style));

        mFlightMap.getUiSettings().setAttributionMargins(280,0,0,20);
    }
    private void enableLocationComponent(Style style) {
        LocationComponent locationComponent ;
        locationComponent = mFlightMap.getLocationComponent();
        locationComponent.activateLocationComponent(
                LocationComponentActivationOptions
                        .builder(CustomLocationIcon.this, style)
                        .build());

// declare a style file and name that style file CustomLocationComponent add a drawble layout in it
        LocationComponentOptions options = LocationComponentOptions.createFromAttributes(
                this,  R.style.CustomLocationComponent);


            options = options.toBuilder()
                    .build();
        locationComponent.applyStyle(options);
        locationComponent.setLocationComponentEnabled(true);
        // change render mode to GPS set custom icon
        locationComponent.setRenderMode(RenderMode.GPS);
    }



    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

}
