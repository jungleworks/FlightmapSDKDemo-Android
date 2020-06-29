package com.FlightMapSdkTestApp.Annotation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.FlightMapSdkTestApp.R;
import com.FlightMapSdkTestApp.utils.IconUtils;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;

public class RotateMarkerActivity extends AppCompatActivity {

    private MapView mapView;
    private MapboxMap mFlightMap;
    private Marker marker;
    private float bearing =0;
    private static final LatLng LAT_LNG_LONDON_EYE = new LatLng(51.50325, -0.11968);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_marker);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        View rotatebttn = findViewById(R.id.rotatebttn);

            rotatebttn.setOnClickListener(view -> {
                bearing =180;
               rotateflightmapmarker(bearing,LAT_LNG_LONDON_EYE);
            });


        mapView.getMapAsync(flightMap -> {
           mFlightMap = flightMap;
            flightMap.setStyle(new Style.Builder().fromUri("https://maps.flightmap.io/styles//default.json"));
            bearing = 90;
            addflightmapmarker(90,LAT_LNG_LONDON_EYE);
        });



    }
    private void addflightmapmarker(float bearing, LatLng latLng) {


        Bitmap myImg =getBitmapFromVectorDrawable(this,R.drawable.mapbox_user_puck_icon);
        Matrix matrix = new Matrix();
        matrix.postRotate(bearing);

        Bitmap rotated = Bitmap.createBitmap(myImg, 0, 0, myImg.getWidth(), myImg.getHeight(),
                matrix, true);
        MarkerOptions options = new com.mapbox.mapboxsdk.annotations.MarkerOptions()
                .position(new com.mapbox.mapboxsdk.geometry.LatLng(latLng.latitude,latLng.longitude))
//                            .rotation(location.getBearing())
                .icon(IconFactory.getInstance(RotateMarkerActivity.this).fromBitmap(rotated));
        marker = mFlightMap.addMarker(options);
    }
    private void rotateflightmapmarker(final float bearing, final LatLng latLng) {
        // User Have to convert a image into bitmap and rotate it with the bearing  at an angle and update the
        //marker position with a new image
        Bitmap myImg =getBitmapFromVectorDrawable(this,R.drawable.mapbox_user_puck_icon);
        Matrix matrix = new Matrix();
        matrix.postRotate(bearing);

        Bitmap rotated = Bitmap.createBitmap(myImg, 0, 0, myImg.getWidth(), myImg.getHeight(),
                matrix, true);

        marker.setPosition(new com.mapbox.mapboxsdk.geometry.LatLng(latLng.latitude, latLng.longitude));
        marker.setIcon(IconFactory.getInstance(RotateMarkerActivity.this).fromBitmap(rotated));

    }

    //Method to convert A vector Image into Png
    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
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
