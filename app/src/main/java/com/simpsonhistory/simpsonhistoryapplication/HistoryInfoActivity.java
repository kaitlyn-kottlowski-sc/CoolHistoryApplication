package com.simpsonhistory.simpsonhistoryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.text.method.LinkMovementMethod;

import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.Objects;

public class HistoryInfoActivity extends AppCompatActivity {

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();


        assert b != null;
        if (!b.containsKey("image2"))
        {
            setContentView(R.layout.activity_one_image_history_page);

        }
        else {
            setContentView(R.layout.activity_two_images_history_page);
            ImageView image2 = findViewById(R.id.image2);
            image2.setImageDrawable(getDrawable(b.getInt("image2")));
            TextView history2 = findViewById(R.id.history2);
            history2.setText(getResources().getString(b.getInt("history2")));
        }

        TextView title = findViewById(R.id.title);
        title.setText(getResources().getString(b.getInt("title")));
        TextView author = findViewById(R.id.author);
        author.setText(getResources().getString(b.getInt("author")));
        ImageView image1 = findViewById(R.id.image1);
        image1.setImageDrawable(getDrawable(b.getInt("image1")));
        TextView history1 = findViewById(R.id.history1);
        history1.setText(getResources().getString(b.getInt("history1")));
        TextView link = findViewById(R.id.link);
        link.setMovementMethod(LinkMovementMethod.getInstance());
        link.setText(getResources().getString(b.getInt("link")));

        String name = b.getString("name");
        Objects.requireNonNull(getSupportActionBar()).setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {// API 5+ solution
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
