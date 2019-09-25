package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MapActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

    }

    public void click_Wallace(View view)
    {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }

    public void click_BackToMainFromMap(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
