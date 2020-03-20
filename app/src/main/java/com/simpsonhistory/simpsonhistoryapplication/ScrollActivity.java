package com.simpsonhistory.simpsonhistoryapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;



import java.util.Objects;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class ScrollActivity extends AppCompatActivity {

    final private static int[] buildingButtonIDs = Buildings.buildingButtonIDs;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_scroll);
        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.scrollTitle));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

    }

    // Reference : https://stackoverflow.com/questions/20906281/how-to-connect-multiple-of-buttons-in-the-same-onclicklistener
    public void onClick(View view) {
        final int buttonId = view.getId();
        final Intent intent = new Intent(this,HistoryInfoActivity.class );
        String[] buildings = Buildings.buildingNames;

        for (int i = 0; i < buildings.length; i++) {
            if (buttonId == buildingButtonIDs[i]) {
                final String name = Buildings.buildingNames[i];
                int[] ids = Buildings.buildingInfo[i];

                intent.removeExtra("image2");
                intent.removeExtra("history2");


                for (int j = 0; j < ids.length; j++)
                {
                    if (ids.length == 5)
                    {
                        intent.putExtra(Buildings.idNamesForOneImage[j], ids[j]);

                    }
                    else intent.putExtra(Buildings.idNamesForTwoImages[j], ids[j]);
                }

                intent.putExtra("name", name);
                startActivity(intent);
            }
        }
    }
}
