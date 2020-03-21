package com.example.ggis_starr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import flamingo.flamingo_api.FlamingoManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlamingoManager flamingoManager = new FlamingoManager(MainActivity.this, new ArrayList<>());
    }
}
