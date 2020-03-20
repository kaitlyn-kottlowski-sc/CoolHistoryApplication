package com.simpsonhistory.simpsonhistoryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
    }

    public void click_Map(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public void changeViewInfo(View view) {

        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public void changeViewHelp(View view) {

        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    public void changeViewList(View view) {

        Intent intent = new Intent(this, ScrollActivity.class);
        startActivity(intent);
    }


}