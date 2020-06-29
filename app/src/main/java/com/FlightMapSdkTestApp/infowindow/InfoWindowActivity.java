package com.FlightMapSdkTestApp.infowindow;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.FlightMapSdkTestApp.R;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;


import java.text.DecimalFormat;

/**
 * Test activity showcasing using the InfoWindow API above Washington D.C.
 * <p>
 * Allows to test mulitple concurrently open InfoWindows.
 * </p>
 */
public class InfoWindowActivity extends AppCompatActivity
  implements OnMapReadyCallback, MapboxMap.OnInfoWindowCloseListener, MapboxMap.OnInfoWindowClickListener,
  MapboxMap.OnInfoWindowLongClickListener {

  private MapboxMap mFlightMap;
  private MapView mapView;
  private Marker customMarker;

  private MapboxMap.OnMapLongClickListener mapLongClickListener = new MapboxMap.OnMapLongClickListener() {
    @Override
    public boolean onMapLongClick(@NonNull LatLng point) {
      if (customMarker != null) {
        // Remove previous added marker
        mFlightMap.removeAnnotation(customMarker);
        customMarker = null;
      }

      // Add marker on long click location with default marker image
      customMarker = mFlightMap.addMarker(new MarkerOptions()
        .title("Custom Marker")
        .snippet(new DecimalFormat("#.#####").format(point.getLatitude()) + ", "
          + new DecimalFormat("#.#####").format(point.getLongitude()))
        .position(point));
      return true;
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_infowindow);

    mapView = (MapView) findViewById(R.id.mapView);
    mapView.onCreate(savedInstanceState);
    mapView.getMapAsync(this);
  }

  @Override
  public void onMapReady(@NonNull MapboxMap flightmap) {
    this.mFlightMap = flightmap;
    flightmap.setStyle(Style.LIGHT_THEME, style -> {

      addMarkers();
      addInfoWindowListeners();
    });
    mFlightMap.getUiSettings().setAttributionMargins(280,0,0,20);
  }

  private void addMarkers() {
    mFlightMap.addMarker(new MarkerOptions()
      .title("Intersection")
      .snippet("H St NW with 15th St NW")
      .position(new LatLng(38.9002073, -77.03364419)));

    mFlightMap.addMarker(new MarkerOptions().title("Intersection")
      .snippet("E St NW with 17th St NW")
      .position(new LatLng(38.8954236, -77.0394623)));

    mFlightMap.addMarker(new MarkerOptions().title("The Ellipse").position(new LatLng(38.89393, -77.03654)));

    mFlightMap.addMarker(new MarkerOptions().position(new LatLng(38.89596, -77.03434)));

    mFlightMap.addMarker(new MarkerOptions().snippet("Lafayette Square").position(new LatLng(38.89949, -77.03656)));

    Marker marker = mFlightMap.addMarker(new MarkerOptions()
      .title("White House")
      .snippet("The official residence and principal workplace of the President of the United States, "
        + "located at 1600 Pennsylvania Avenue NW in Washington, D.C. It has been the residence of every"
        + "U.S. president since John Adams in 1800.")
      .position(new LatLng(38.897705003219784, -77.03655168667463)));

    // open InfoWindow at startup
    mFlightMap.selectMarker(marker);
  }

  private void addInfoWindowListeners() {
    mFlightMap.setOnInfoWindowCloseListener(this);
    mFlightMap.addOnMapLongClickListener(mapLongClickListener);
    mFlightMap.setOnInfoWindowClickListener(this);
    mFlightMap.setOnInfoWindowLongClickListener(this);
  }

  private void toggleConcurrentInfoWindow(boolean allowConcurrentInfoWindow) {
    mFlightMap.deselectMarkers();
    mFlightMap.setAllowConcurrentMultipleOpenInfoWindows(allowConcurrentInfoWindow);
  }

  private void toggleDeselectMarkersOnTap(boolean deselectMarkersOnTap) {
    mFlightMap.getUiSettings().setDeselectMarkersOnTap(deselectMarkersOnTap);
  }

  @Override
  public boolean onInfoWindowClick(@NonNull Marker marker) {
    Toast.makeText(getApplicationContext(), "OnClick: " + marker.getTitle(), Toast.LENGTH_LONG).show();
    // returning true will leave the info window open
    return false;
  }

  @Override
  public void onInfoWindowClose(Marker marker) {
    Toast.makeText(getApplicationContext(), "OnClose: " + marker.getTitle(), Toast.LENGTH_LONG).show();
  }

  @Override
  public void onInfoWindowLongClick(Marker marker) {
    Toast.makeText(getApplicationContext(), "OnLongClick: " + marker.getTitle(), Toast.LENGTH_LONG).show();
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
    if (mFlightMap != null) {
      mFlightMap.removeOnMapLongClickListener(mapLongClickListener);
    }
    mapView.onDestroy();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_infowindow, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_toggle_concurrent_infowindow:
        toggleConcurrentInfoWindow(!item.isChecked());
        item.setChecked(!item.isChecked());
        return true;
      case R.id.action_toggle_deselect_markers_on_tap:
        toggleDeselectMarkersOnTap(!item.isChecked());
        item.setChecked(!item.isChecked());
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}