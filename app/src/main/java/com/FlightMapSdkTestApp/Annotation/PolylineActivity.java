package com.FlightMapSdkTestApp.Annotation;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;


import com.FlightMapSdkTestApp.R;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.PolylineOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;

import java.util.ArrayList;
import java.util.List;

public class PolylineActivity extends AppCompatActivity {
    private static final String STATE_POLYLINE_OPTIONS = "polylineOptions";


    private ArrayList<PolylineOptions> polylineOptions = new ArrayList<>();
    List<LatLng> polygonLatLngList = new ArrayList<>();

    private MapView mapView;
    private MapboxMap mFlightMap;
    private int millisecondSpeed = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polyline);
        View fab = findViewById(R.id.fab);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(flightMap -> {
            PolylineActivity.this.mFlightMap = flightMap;
            mFlightMap.getUiSettings().setAttributionMargins(280,0,0,20);
            flightMap.setStyle(new Style.Builder().fromUri("https://maps.flightmap.io/styles//default.json"));
            mFlightMap.addPolyline(new PolylineOptions()
                    .addAll(adddatatopolylinelist())
                    .color(R.color.colorgrey)
                    .width(2));
// Create polyline options with existing LatLng ArrayList
            CameraPosition position = new CameraPosition.Builder()
                    .target(new LatLng(45.522585, -122.685699))
                    .zoom(8)
                    .tilt(20)
                    .build();
            mFlightMap.animateCamera(CameraUpdateFactory.newCameraPosition(position), millisecondSpeed);
         });

    }


  public List<LatLng> adddatatopolylinelist() {
      polygonLatLngList.add(new LatLng(45.52214,-122.63748));
      polygonLatLngList.add(new LatLng(45.52218,-122.64855 ));
      polygonLatLngList.add(new LatLng(45.52219,-122.6545 ));
      polygonLatLngList.add(new LatLng(45.52219,-122.6545 ));
      polygonLatLngList.add(new LatLng( 45.52219,-122.6545));

      polygonLatLngList.add(new LatLng( 45.52196,-122.65497));
      polygonLatLngList.add(new LatLng( 45.52104,-122.65631));
      polygonLatLngList.add(new LatLng(45.51935 ,-122.6578 ));
      polygonLatLngList.add(new LatLng(45.51848,-122.65867 ));
      polygonLatLngList.add(new LatLng(45.51848,-122.65867 ));
      polygonLatLngList.add(new LatLng(45.51293,-122.65872 ));
      polygonLatLngList.add(new LatLng(45.51295,-122.66576));
      polygonLatLngList.add(new LatLng(45.51252,-122.66745 ));
      polygonLatLngList.add(new LatLng(45.51244,-122.66813));
      polygonLatLngList.add(new LatLng(45.51385,-122.67359 ));
      polygonLatLngList.add(new LatLng(45.51385,-122.67359 ));
      polygonLatLngList.add(new LatLng(45.51385,-122.67359 ));

      polygonLatLngList.add(new LatLng(45.51385,-122.67359 ));
      polygonLatLngList.add(new LatLng(45.51406,-122.67415 ));
      polygonLatLngList.add(new LatLng(45.51484,-122.67481 ));
      polygonLatLngList.add(new LatLng(45.51532,-122.676 ));
      polygonLatLngList.add(new LatLng(45.51668,-122.68106 ));
      polygonLatLngList.add(new LatLng(45.50934,-122.68503));
      polygonLatLngList.add(new LatLng(45.50858,-122.68546));
      polygonLatLngList.add(new LatLng(45.50783,-122.6852));
      polygonLatLngList.add(new LatLng(45.50714,-122.68424 ));
      polygonLatLngList.add(new LatLng(45.50585,-122.68433 ));
      polygonLatLngList.add(new LatLng(45.50521,-122.68429 ));
      polygonLatLngList.add(new LatLng(45.50445,-122.68456));
      polygonLatLngList.add(new LatLng(45.50371,-122.68538 ));
      polygonLatLngList.add(new LatLng(45.50311,-122.68653 ));
      polygonLatLngList.add(new LatLng(45.50292,-122.68731 ));
      polygonLatLngList.add(new LatLng(45.50253,-122.68742));
      polygonLatLngList.add(new LatLng(45.50239,-122.6867 ));
      polygonLatLngList.add(new LatLng(45.5026,-122.68545 ));
      polygonLatLngList.add(new LatLng(45.50294,-122.68407));
      polygonLatLngList.add(new LatLng(45.50271,-122.68357 ));
      polygonLatLngList.add(new LatLng(45.50055,-122.68236 ));
      polygonLatLngList.add(new LatLng(45.49994,-122.68233 ));
      polygonLatLngList.add(new LatLng(45.49955,-122.68267 ));
      polygonLatLngList.add(new LatLng(45.49919,-122.68257 ));
      polygonLatLngList.add(new LatLng(45.49842,-122.68376 ));
      polygonLatLngList.add(new LatLng(45.49821,-122.68428 ));
      polygonLatLngList.add(new LatLng(45.49798,-122.68573 ));
      polygonLatLngList.add(new LatLng(45.49805,-122.68923 ));
      polygonLatLngList.add(new LatLng(45.49857,-122.68926));

      polygonLatLngList.add(new LatLng(45.49911,-122.68814 ));
      polygonLatLngList.add(new LatLng(45.49921,-122.68865 ));
      polygonLatLngList.add(new LatLng(45.49905,-122.6897 ));

      polygonLatLngList.add(new LatLng(45.49917,-122.69346 ));

      polygonLatLngList.add(new LatLng(45.49902,-122.69404 ));
      polygonLatLngList.add(new LatLng(45.49796,-122.69438 ));
      polygonLatLngList.add(new LatLng(45.49697,-122.69504 ));
      polygonLatLngList.add(new LatLng(45.49661,-122.69624 ));
      polygonLatLngList.add(new LatLng(45.49661,-122.69624 ));
      polygonLatLngList.add(new LatLng(45.4955,-122.69781 ));
      polygonLatLngList.add(new LatLng(45.49517,-122.69803));
      polygonLatLngList.add(new LatLng(45.49508,-122.69711 ));
      polygonLatLngList.add(new LatLng(45.4948,-122.69688));
      polygonLatLngList.add(new LatLng(45.49368,-122.69744 ));
      polygonLatLngList.add(new LatLng(45.49311,-122.69702 ));
      polygonLatLngList.add(new LatLng(45.49294,-122.69665 ));
      polygonLatLngList.add(new LatLng(45.49212,-122.69788 ));
      polygonLatLngList.add(new LatLng(45.49264,-122.69771 ));
      polygonLatLngList.add(new LatLng(45.49332,-122.69835 ));
      polygonLatLngList.add(new LatLng(45.49334,-122.7007 ));
      polygonLatLngList.add(new LatLng(45.49358,-122.70167 ));
      polygonLatLngList.add(new LatLng(45.49401,-122.70215 ));
      polygonLatLngList.add(new LatLng(45.49439,-122.70229 ));
      polygonLatLngList.add(new LatLng(45.49566,-122.70185 ));
      polygonLatLngList.add(new LatLng(45.49635,-122.70215 ));
      polygonLatLngList.add(new LatLng(45.49674,-122.70346 ));
      polygonLatLngList.add(new LatLng(45.49758,-122.70517 ));
      polygonLatLngList.add(new LatLng(45.49736,-122.70614 ));
      polygonLatLngList.add(new LatLng(45.49736,-122.70663 ));
      polygonLatLngList.add(new LatLng(45.49767,-122.70807 ));
      polygonLatLngList.add(new LatLng(45.49798,-122.70807 ));
      polygonLatLngList.add(new LatLng(45.49798,-122.70717 ));
      polygonLatLngList.add(new LatLng(45.4984,-122.70713 ));
      polygonLatLngList.add(new LatLng(45.49893,-122.70774));
        return polygonLatLngList;
    }



    @Override
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
        outState.putParcelableArrayList(STATE_POLYLINE_OPTIONS, polylineOptions);
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
