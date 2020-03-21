package com.example.ggis_starr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Console;
import java.util.ArrayList;

import flamingo.flamingo_api.FlamingoManager;

public class MeasurePointFeature extends AppCompatActivity {

    /**
     * Request Permission from User
     */
    private static final int REQUEST_ACCESS_FINE_LOCATION_PERMISSION = 1;
    private static final int REQUEST_READ_PHONE_STATE_PERMISSION = 2;

    /**
     * A simple logging class to handle logging for errors
     */
    private static SimpleLogger mSimpleLogger;

    public static MeasurePointFeature thisActivity;

    /**
     * The Flamingo client manager
     */
    FlamingoManager mFlamingoManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure_point_feature);

        thisActivity = this;
        mSimpleLogger = new SimpleLogger();

        if (requestUserLocationPermission() && requestUserReadPhonePermission())
        {
            mFlamingoManager = new FlamingoManager(thisActivity, new ArrayList<>());
        }
        else
        {
            finish();
        }

        Button recordMeasurementButton = (Button) findViewById(R.id.record_measurement_btn);
        recordMeasurementButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        takeMeasurement();
                    }
                }
        );
    }

    public boolean requestUserLocationPermission()
    {
        if (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity, Manifest.permission.ACCESS_FINE_LOCATION))
            {
                mSimpleLogger.showinfo(thisActivity, "You need to enable location to use this app", 2000);
                return false;
            }
            else
            {
                ActivityCompat.requestPermissions(thisActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_ACCESS_FINE_LOCATION_PERMISSION);
            }
        }

        return true;
    }

    public boolean requestUserReadPhonePermission()
    {
        if (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity, Manifest.permission.READ_PHONE_STATE))
            {
                mSimpleLogger.showinfo(thisActivity, "You need to enable location to use this app", 2000);
                return false;
            }
            else
            {
                ActivityCompat.requestPermissions(thisActivity, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE_PERMISSION);
            }
        }

        return true;
    }

    public void takeMeasurement()
    {
        mSimpleLogger.showinfo(thisActivity, "Hello, world", 1000);

        try
        {
            mFlamingoManager.registerFlamingoService("hackathon", "huser3", "C5gWuH6qrhrDUyxj");
            mSimpleLogger.showinfo(thisActivity, mFlamingoManager.getRegistrationStatus().toString(), 5000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
