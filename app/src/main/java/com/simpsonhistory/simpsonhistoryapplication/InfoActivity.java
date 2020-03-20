package com.simpsonhistory.simpsonhistoryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.text.method.LinkMovementMethod;

import android.view.View;
import android.widget.TextView;

import java.util.Objects;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class InfoActivity extends AppCompatActivity {


    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Information Page");
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
