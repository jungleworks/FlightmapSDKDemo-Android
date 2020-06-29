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



