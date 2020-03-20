package com.simpsonhistory.simpsonhistoryapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;


import java.util.Objects;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class HelpActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("SourceLockedOrientationActivity")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Help Page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
    }

    public void click_back(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}