# FlightmapSDKDemo-Android
This repository is of Flight Map Android Maps Sdk .
About FlightMapSdk
The FlightMap Maps SDK for Android is a library for embedding interactive map views and  vector maps onto Android devices.
# Installing dependencies:-
-Latest stable Android Studio
- New Project created or Old Existing Project should be in Android X 
# Running project:-
Run the configuration for the FlightMapSdk TestApp module and select a device or emulator to deploy on. Based on the selected device, . You can see the project compiling in the View > Tool Windows > Gradle Console.
# Additional resources
- Integrating  the  FlightMap SDK In a Project :-
-Add implementation 'flightmapsdk.flightmaplightsdk:flightmap:1.3.3'  in your Project module app gradle build file
-Add maven 
-{ url 'https://dl.bintray.com/flightmap/com.flightmap' }  
in your Project module gradle root under 
allprojects {
    repositories {
        jcenter()
        maven { url 'https://dl.bintray.com/flightmap/com.flightmap' } 
    }
}
sync the project

# Setting FlightMap Access Token
- To Login A project user should have Valid Access Token 
- Enter the Access token on login Screen .
-A developer can see that the access token is Initialize in Application class named  {FlightMapApplication} 
- On how to intialize a access token within a Activity or Fragment please check Activity {PressForMarkerActivity in Demo App}

#  Features

# Simple map
- Simply Load A Map with Custom Style Url  of Dark and Light Them .Reference Class - SimpleMapviewActivity.java

# Bulk Annotations
- Load annotations marker in bulk  to the map via a geojson file from assets folder.Reference Class - AddMarkerinBulkActivity.java

# Dynamic Markers
- Update the position of a Marker Annoation  with the tap of a button. Reference Class - DynamicMarkerViewController.java

# Add  Marker annotation on tap of Map
- Add marker annotation to the map by tapping onto a coordinate Reference Class - PressForMarkerActivity.java

# Marker Rotation with bearing 
- Rotate a marker annotation image smoothly by providing the bearing and pass the new image in BitMap Utils for rotation. Reference Class - RotateMarkerActivity.java

# Polygon
- Add a polygon to the map with  cooridnates of lattitude & longitude  from arraylist. Reference Class - DynamicMarkerChangeActivity.java

# Polyline
- Add a polyline to the map with  cooridnates of lattitude & longitude  from arraylist. Reference Class - PolylineActivity.java

# Animation Types of Camera 
- Different type of camera animations to zoom in and zoom out map to a desired coordinates  that are available. Reference Class - CameraAnimationTypeActivity.java

# Info Window
- Set a Default  infow window on marker tap . Reference Class - InfoWindowActivity.java

# Custom Infow Window with custom marker icon
- Change a layout of infowindow  and set a marker from drawable  image .Reference Class - DynamicInfoWindowAdapterActivity.java 

# User Location & Tracking Modes
 - Show user current  location on map . Refernce Controllers . Reference Class- LocationComponentActivationActivity.java
 
 - Change user current location icon with a custom drawble image which have to be mentioned in Style file . Reference Class - CustomLocationIcon.java






 











