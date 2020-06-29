package com.FlightMapSdkTestApp.Annotation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.FlightMapSdkTestApp.R;
import com.FlightMapSdkTestApp.utils.IconUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;

/**
 * Test activity showcasing updating a Marker position, title, icon and snippet.
 */
public class DynamicMarkerChangeActivity extends AppCompatActivity {

  private static final LatLng LAT_LNG_DELHI = new LatLng(28.7041, 77.1025);
  private static final LatLng LAT_LNG_CHANDIGARH = new LatLng(30.7333, 76.7794);

  private MapView mapView;
  private MapboxMap mFlightMap;
  private Marker marker;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dynamic_marker);

    mapView = findViewById(R.id.mapView);
    FloatingActionButton fab = findViewById(R.id.fab);
    mapView.setTag(false);
    mapView.onCreate(savedInstanceState);

    mapView.getMapAsync(flightmap -> {
      flightmap.setStyle(Style.LIGHT);


      DynamicMarkerChangeActivity.this.mFlightMap = flightmap;
      mFlightMap.getUiSettings().setAttributionMargins(280,0,0,20);
      // Camera zoom is set in Xml for a particular  lat long
      // Create marker
      MarkerOptions markerOptions = new MarkerOptions()
        .position(LAT_LNG_DELHI)
        .icon(IconUtils.drawableToIcon(DynamicMarkerChangeActivity.this, R.drawable.ic_stars,
          ResourcesCompat.getColor(getResources(), R.color.colorAccent, getTheme())))
        .title(getString(R.string.dynamic_marker_delhi))
        .snippet(getString(R.string.dynamic_marker_chandigarh));
      marker = flightmap.addMarker(markerOptions);
    });

    fab.setColorFilter(ContextCompat.getColor(this, R.color.appcolor));
    fab.setOnClickListener(view -> {
      if (mFlightMap != null) {
        updateMarker();
      }
    });
  }

  private void updateMarker() {
    // update model
    boolean first = (boolean) mapView.getTag();
    mapView.setTag(!first);

    // update marker
    marker.setPosition(first ? LAT_LNG_DELHI : LAT_LNG_CHANDIGARH);
    marker.setIcon(IconUtils.drawableToIcon(this, R.drawable.mapbox_marker_icon_default, first
      ? ResourcesCompat.getColor(getResources(), R.color.colorAccent, getTheme()) :
      ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme())
    ));

    marker.setTitle(first
      ? getString(R.string.dynamic_marker_delhi) : getString(R.string.dynamic_marker_chandigarh));
    marker.setSnippet(first
      ? getString(R.string.dynamic_marker_delhi_snippet) : getString(R.string.dynamic_marker_chandigarh_snippet));
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
