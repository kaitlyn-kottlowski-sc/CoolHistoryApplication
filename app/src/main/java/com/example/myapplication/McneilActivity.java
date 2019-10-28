package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.text.method.LinkMovementMethod;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.Objects;

import java.util.Objects;
public class McneilActivity extends AppCompatActivity {

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcneil);

//        Intent intent = getIntent();
//        String layout = intent.getExtras().getString("Layout");
//
//        int id = getResources().getIdentifier(layout, "layout", getPackageName());
//
//        int id = this.getResources().getString(layout);
//        setContentView(id);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView text = findViewById(R.id.link_Computer_Science);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
