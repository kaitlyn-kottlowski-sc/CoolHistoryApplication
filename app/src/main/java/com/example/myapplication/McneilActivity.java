package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.text.method.LinkMovementMethod;

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


        Objects.requireNonNull(getSupportActionBar()).setTitle("McNeil");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView text = findViewById(R.id.link_Computer_Science);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }}
