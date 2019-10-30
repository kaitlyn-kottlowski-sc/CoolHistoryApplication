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
public class InfoActivity extends AppCompatActivity {

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        Objects.requireNonNull(getSupportActionBar()).setTitle("Information");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView text = findViewById(R.id.link_Simpson);

         text.setMovementMethod(LinkMovementMethod.getInstance());

        TextView otherText = findViewById(R.id.link_Iowa);

        otherText.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void click_back(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
