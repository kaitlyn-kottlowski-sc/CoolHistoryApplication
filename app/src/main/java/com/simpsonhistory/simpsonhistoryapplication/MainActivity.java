package com.simpsonhistory.simpsonhistoryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
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