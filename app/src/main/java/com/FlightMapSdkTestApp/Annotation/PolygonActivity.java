package com.FlightMapSdkTestApp.Annotation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.FlightMapSdkTestApp.R;
import com.mapbox.mapboxsdk.annotations.Polygon;
import com.mapbox.mapboxsdk.annotations.PolygonOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.MapboxMapOptions;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import java.util.ArrayList;
import java.util.List;

public class PolygonActivity extends AppCompatActivity  implements OnMapReadyCallback {
    List<LatLng> polygonLatLngList = new ArrayList<>();
    private Polygon polygon;
    private MapView mapView;
    private MapboxMap mFlightMap;
    private boolean fullAlpha = true;
    static final float FULL_ALPHA = 1.0f;
    static final float PARTIAL_ALPHA = 0.5f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create a Map view without declaring Xml
        // configure inital map state
        MapboxMapOptions options = MapboxMapOptions.createFromAttributes(this, null)
                .attributionTintColor(R.color.appcolor)
                .compassFadesWhenFacingNorth(false)
                .camera(new CameraPosition.Builder()
                        .target(new LatLng(45.520486, -122.673541))
                        .zoom(8)
                        .tilt(30)
                        .build());
        mapView = new MapView(this, options);
        mapView.setId(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        adddatatolist();
        mapView.getMapAsync(this);

        setContentView(mapView);


    }


    @Override
    public void onMapReady(@NonNull MapboxMap flightmap) {
        mFlightMap = flightmap;
        mFlightMap.setStyle(Style.LIGHT);
        mFlightMap.getUiSettings().setAttributionMargins(280,0,0,20);
        //set compass enabled false to not show compass on map
        mFlightMap.getUiSettings().setCompassEnabled(false);
        polygon = mFlightMap.addPolygon(new PolygonOptions()
                .addAll(polygonLatLngList)
                .fillColor(R.color.appcolor));
        polygon.setAlpha(fullAlpha ? FULL_ALPHA : PARTIAL_ALPHA);
    }

    private void adddatatolist() {
        polygonLatLngList.add(new LatLng(45.522585, -122.685699));
        polygonLatLngList.add(new LatLng(45.534611, -122.708873));
        polygonLatLngList.add(new LatLng(45.530883, -122.678833));
        polygonLatLngList.add(new LatLng(45.547115, -122.667503));
        polygonLatLngList.add(new LatLng(45.530643, -122.660121));
        polygonLatLngList.add(new LatLng(45.533529, -122.636260));
        polygonLatLngList.add(new LatLng(45.521743, -122.659091));
        polygonLatLngList.add(new LatLng(45.510677, -122.648792));
        polygonLatLngList.add(new LatLng(45.515008, -122.664070));
        polygonLatLngList.add(new LatLng(45.502496, -122.669048));
        polygonLatLngList.add(new LatLng(45.515369, -122.678489));
        polygonLatLngList.add(new LatLng(45.506346, -122.702007));
        polygonLatLngList.add(new LatLng(45.522585, -122.685699));


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
    }

}
