package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MapPopActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map_popup);
    }

    public void click_BackToMain(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void click_GoToMap(View view)
    {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}
