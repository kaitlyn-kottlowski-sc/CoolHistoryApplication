package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class ScrollActivity extends AppCompatActivity {

    final private static int[] buildingButtonIDs = Buildings.buildingButtonIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scroll);
        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.scrollTitle));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    // Reference : https://stackoverflow.com/questions/20906281/how-to-connect-multiple-of-buttons-in-the-same-onclicklistener
    public void onClick(View view) {
        final int buttonId = view.getId();
        final Intent intent = new Intent(this,HistoryActivity.class );
        String[] buildings = Buildings.buildingNames;

        for (int i = 0; i < buildings.length; i++) {
            if (buttonId == buildingButtonIDs[i]) {
                final int layoutID= Buildings.buildingLayoutIDs[i];
                intent.putExtra("layout_id", layoutID);
                startActivity(intent);
            }
        }
    }
}
