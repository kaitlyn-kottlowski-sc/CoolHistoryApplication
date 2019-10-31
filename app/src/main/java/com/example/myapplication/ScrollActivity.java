package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ScrollActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scroll);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Simpson Buildings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void clickHopper(View view){

        final Intent intent = new Intent(this, HistoryActivity.class);
        int id = getResources().getIdentifier("activity_hopper", "layout", getPackageName());
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }

    public void click_BillBuxton(View view)
    {
        final Intent intent = new Intent(this, HistoryActivity.class);
        int id = R.layout.activity_bill_buxton;
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }

    public void click_Wallace(View view)
    {
        final Intent intent = new Intent(this, HistoryActivity.class);
        int id = R.layout.activity_wallace;
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }

    public void click_GreatHall(View view)
    {
        final Intent intent = new Intent(this, HistoryActivity.class);
        int id = R.layout.activity_greathall;
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }

    public void click_McNeill(View view)
    {
        final Intent intent = new Intent(this, HistoryActivity.class);

        int id = R.layout.activity_mcneill;
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }

    public void click_Cowles(View view)
    {
        final Intent intent = new Intent(this, HistoryActivity.class);
        int id = R.layout.activity_cowles;
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }

    public void click_Dunn(View view)
    {
        final Intent intent = new Intent(this, HistoryActivity.class);
        int id = R.layout.activity_dunn;
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }
    public void click_Hillman(View view)
    {
        final Intent intent = new Intent(this, HistoryActivity.class);
        int id = R.layout.activity_hillman;
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }
    public void click_Kent(View view)
    {
        final Intent intent = new Intent(this, HistoryActivity.class);
        int id = R.layout.activity_kent;
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }
    public void click_Mary_Berry(View view)
    {
        final Intent intent = new Intent(this, HistoryActivity.class);
        int id = R.layout.activity_mary_berry;
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }
    public void click_Smith_Chapel(View view)
    {
        final Intent intent = new Intent(this, HistoryActivity.class);
        int id = R.layout.activity_smith_chapel;
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }

    public void click_Carver(View view)
    {
        final Intent intent = new Intent(this, HistoryActivity.class);
        int id = R.layout.activity_carver;
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }

    public void click_College_Hall(View view)
    {
        final Intent intent = new Intent(this, HistoryActivity.class);
        int id = R.layout.activity_college_hall;
        intent.putExtra("layout_id", id);
        startActivity(intent);
    }


}
