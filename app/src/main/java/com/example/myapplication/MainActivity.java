package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        // Initialize
        //ImageButton wallaceButton = findViewById(R.id.wallaceButton);

    }

    public void click_Map(View view)
    {
        //Intent intent = new Intent(this, MapPopActivity.class);
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public void click_Wallace(View view)
    {

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


        setContentView(R.layout.activity_scroll);

        /*Intent intent = new Intent(this, Activity_scroll.class);
        startActivity(intent);*/


    }
}
