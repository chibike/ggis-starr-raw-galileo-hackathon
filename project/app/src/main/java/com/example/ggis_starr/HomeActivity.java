package com.example.ggis_starr;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    public static HomeActivity thisActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        thisActivity = this;
        Button measurePointFeatureButton = (Button) findViewById(R.id.take_point_measurement_btn);
        measurePointFeatureButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(thisActivity, MeasurePointFeature.class);
                        startActivity((intent));
                    }
                }
        );

    }
}
