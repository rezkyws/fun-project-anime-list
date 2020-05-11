package com.example.listanime;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Add up button
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setIcon(R.drawable.arrow_back);
        }

        ImageView imageView = findViewById(R.id.photo);
        TextView name = findViewById(R.id.my_name);
        TextView email = findViewById(R.id.my_email);

        imageView.setImageResource(R.drawable.rezky);
        name.setText("Rezky Wahyuda Sitepu");
        email.setText("desurezuki@gmail.com");
    }

    //Make up button clickable
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
