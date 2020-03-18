package com.simpsonhistory.simpsonhistoryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.text.method.LinkMovementMethod;

import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class InfoActivity extends AppCompatActivity {

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        Objects.requireNonNull(getSupportActionBar()).setTitle("App Information");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView text = findViewById(R.id.linkToAdmissions);

         text.setMovementMethod(LinkMovementMethod.getInstance());

        TextView otherText = findViewById(R.id.linkToSimpsonIowaHistory);

        otherText.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void click_back(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
