package com.example.ggis_starr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import flamingo.flamingo_api.FlamingoManager;

public class MainActivity extends AppCompatActivity {

    public static MainActivity thisActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thisActivity = this;
        Button startMeasurementButton = (Button) findViewById(R.id.take_measurement_btn);
        startMeasurementButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(thisActivity, HomeActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
