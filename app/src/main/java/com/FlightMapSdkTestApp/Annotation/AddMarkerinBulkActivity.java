package com.FlightMapSdkTestApp.Annotation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.FlightMapSdkTestApp.R;
import com.FlightMapSdkTestApp.utils.GeoParseUtil;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import timber.log.Timber;

public class AddMarkerinBulkActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
    private MapboxMap mFlightMap;
    private MapView mapView;
    private List<LatLng> locations;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_markerin_bulk);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this::initMap);
    }
    private void initMap(MapboxMap flightMap) {
        this.mFlightMap =  flightMap;
        // method to set flightmap attribute gravity and margin .
        mFlightMap.getUiSettings().setAttributionGravity(Gravity.RIGHT|Gravity.END|Gravity.BOTTOM);
        mFlightMap.getUiSettings().setAttributionMargins(0,0,0,20);
        flightMap.setStyle(Style.LIGHT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(
                this, R.array.bulk_marker_list, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getMenuInflater().inflate(R.menu.menu_bulk_marker, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(AddMarkerinBulkActivity.this);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int amount = Integer.valueOf(getResources().getStringArray(R.array.bulk_marker_list)[position]);
        if (locations == null) {
            progressDialog = ProgressDialog.show(this, "Loading", "Fetching markers", false);
            new LoadLocationTask(this, amount).execute();
        } else {
            showMarkers(amount);
        }
    }

    private void onLatLngListLoaded(List<LatLng> latLngs, int amount) {
        progressDialog.hide();
        locations = latLngs;
        showMarkers(amount);
    }

    private void showMarkers(int amount) {
        if (mFlightMap == null || locations == null || mapView.isDestroyed()) {
            return;
        }

        mFlightMap.clear();
        if (locations.size() < amount) {
            amount = locations.size();
        }

        showGlMarkers(amount);
    }

    private void showGlMarkers(int amount) {
        List<MarkerOptions> markerOptionsList = new ArrayList<>();
        DecimalFormat formatter = new DecimalFormat("#.#####");
        Random random = new Random();
        int randomIndex;

        for (int i = 0; i < amount; i++) {
            randomIndex = random.nextInt(locations.size());
            LatLng latLng = locations.get(randomIndex);
            markerOptionsList.add(new MarkerOptions()
                    .position(latLng)
                    .title(String.valueOf(i))
                    .snippet(formatter.format(latLng.getLatitude()) + ", " + formatter.format(latLng.getLongitude())));
        }

        mFlightMap.addMarkers(markerOptionsList);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // nothing selected, nothing to do!
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
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }



    private static class LoadLocationTask extends AsyncTask<Void, Integer, List<LatLng>> {

        private WeakReference<AddMarkerinBulkActivity> activity;
        private int amount;

        private LoadLocationTask(AddMarkerinBulkActivity activity, int amount) {
            this.amount = amount;
            this.activity = new WeakReference<>(activity);
        }

        @Override
        protected List<LatLng> doInBackground(Void... params) {
            AddMarkerinBulkActivity activity = this.activity.get();
            if (activity != null) {
                String json = null;
                try {
                    //File is stored  locally in Assets folder
                    json = GeoParseUtil.loadStringFromAssets(activity.getApplicationContext(), "points.geojson");
                } catch (IOException exception) {
                    Timber.e(exception, "Could not add markers");
                }

                if (json != null) {
                    return GeoParseUtil.parseGeoJsonCoordinates(json);
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<LatLng> locations) {
            super.onPostExecute(locations);
            AddMarkerinBulkActivity activity = this.activity.get();
            if (activity != null) {
                activity.onLatLngListLoaded(locations, amount);
            }
        }
    }
}
