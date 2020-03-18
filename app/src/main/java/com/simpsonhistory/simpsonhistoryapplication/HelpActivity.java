package com.simpsonhistory.simpsonhistoryapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;


import java.util.Objects;

public class HelpActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Help Page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize
        //ImageButton wallaceButton = findViewById(R.id.wallaceButton);
    }

    public void click_back(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}