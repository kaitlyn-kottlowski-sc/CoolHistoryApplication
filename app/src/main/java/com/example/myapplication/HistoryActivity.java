package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.text.method.LinkMovementMethod;

import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class HistoryActivity extends AppCompatActivity {

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Bundle extras = getIntent().getExtras();
//        String layout = null;
//        if (extras != null) {
//            layout = extras.getString("Layout");
//        }
//        getIntent().removeExtra("Layout");
//
//        int id = getResources().getIdentifier(layout, "layout", getPackageName());
//        setContentView(id);

        setContentView(R.layout.activity_mcneill);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Historic Info");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView text = findViewById(R.id.link_Computer_Science);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
