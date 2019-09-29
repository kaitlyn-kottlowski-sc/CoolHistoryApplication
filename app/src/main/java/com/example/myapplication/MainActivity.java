package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        // Initialize
        //ImageButton wallaceButton = findViewById(R.id.wallaceButton);

    }

    public void click_Map(View view)
    {
        //Intent intent = new Intent(this, MapPopActivity.class);
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public void changeViewInfo(View view) {

        //boolean avail=false;

        /*if (avail) {
            info_page_image.setBackgroundResource(0);
            avail = false;
        } else {
            info_page_image.setBackgroundResource(R.drawable.ic_launcher);
            avail = true;
        }*/

        TextView greetingTextView = this.findViewById(R.id.greetingTextView);
        greetingTextView.setText(R.string.thanks_for_clicking);


        ImageView info_button = findViewById(R.id.info_button);
        info_button.setVisibility(View.INVISIBLE);

        ImageView help_button = findViewById(R.id.help_button);
        help_button.setVisibility(View.INVISIBLE);


        ImageView map_button = findViewById(R.id.map_button);
        map_button.setVisibility(View.INVISIBLE);

        ImageView list_button = findViewById(R.id.list_button);
        list_button.setVisibility(View.INVISIBLE);
    }
}
