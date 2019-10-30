package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scroll);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

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

        Intent intent = new Intent(ScrollActivity.this, McneilActivity.class);
        intent.putExtra("Layout", "McNeill");
        startActivity(intent);
    }

    public void click_Cowls(View view)
    {

        setContentView(R.layout.activity_cowls);
    }

    public void click_Dunn(View view)
    {
        setContentView(R.layout.activity_dunn);
    }
    public void click_Hillman(View view)
    {
        setContentView(R.layout.activity_hillman);
    }
    public void click_Kent(View view)
    {
        setContentView(R.layout.activity_kent);
    }
    public void click_Mary_Berry(View view)
    {
        setContentView(R.layout.activity_mary_berry);
    }
    public void click_Smith_Chapel(View view)
    {
        setContentView(R.layout.activity_smith_chapel);
    }

    public void click_Carver(View view)
    {
        setContentView(R.layout.activity_carver);
    }

    public void click_College_Hall(View view)
    {
        setContentView(R.layout.activity_college_hall);
    }
}

