package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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


    }

    public void clickHome(View view){

        setContentView(R.layout.activity_main_home);
    }


    public void clickHopper(View view){

        setContentView(R.layout.activity_hopper);
    }

    public void click_BillBuxton(View view)
    {
        setContentView(R.layout.activity_bill_buxton);
    }

    public void click_Wallace(View view)
    {
        setContentView(R.layout.activity_wallace);
    }

    public void click_GreatHall(View view)
    {
        setContentView(R.layout.activity_greathall);
    }

    public void click_McNeil(View view)
    {
        setContentView(R.layout.activity_mcneil);
    }


}
