package com.example.listanime;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_SYNOPSIS = "extra_synopsis";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setIcon(R.drawable.arrow_back);
        }

        ImageView imageView = findViewById(R.id.cover);
        TextView title = findViewById(R.id.title_detail);
        TextView synopsis = findViewById(R.id.synopsis);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String description = getIntent().getStringExtra(EXTRA_SYNOPSIS);
        int image = getIntent().getIntExtra(EXTRA_IMAGE, 0);
        title.setText(name);
        synopsis.setText(description);
        imageView.setImageResource(image);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
