package com.kathford.openstreetmapexample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {
    private MapView mapView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);

        // Initialize OsmDroid configuration
        Configuration.getInstance().setUserAgentValue(getPackageName());

        // Find the MapView from the layout
        mapView = findViewById(R.id.map);

        // Set the tile source (e.g., OpenStreetMap)
        mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);

        // Set the default zoom level and center coordinates
        mapView.getController().setZoom(10);
        mapView.getController().setCenter(new GeoPoint(27.673581557553778, 85.33846210483713));
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
}
