package com.example.listanime;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows top airing anime category
        final TextView topAiringAnime = findViewById(R.id.top_airing_anime);
        final TextView topUpcomingAnime = findViewById(R.id.top_upcoming_anime);
        final TextView mostPopularAnime = findViewById(R.id.most_popular_anime);
        ImageView icon = findViewById(R.id.app_icon);
        icon.setImageResource(R.drawable.app_icon);

        // Set a click listener on the View
        topAiringAnime.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the top airing anime category is clicked on.
            @Override
            public void onClick(View v) {
                int modeActivity = 1;
                // Create a new intent to open the {@link TopAiringActivity}
                Intent topAiringAnimeIntent = new Intent(MainActivity.this, ListActivity.class);

                topAiringAnimeIntent.putExtra(ListActivity.EXTRA_MODE, modeActivity);

                // Start the new activity
                startActivity(topAiringAnimeIntent);
            }
        });

        // Set a click listener on the View
        topUpcomingAnime.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the top upcoming anime category is clicked on.
            @Override
            public void onClick(View v) {
                int modeActivity = 2;
                // Create a new intent to open the {@link TopUpcomingActivity}
                Intent topUpcomingAnimeIntent = new Intent(MainActivity.this, ListActivity.class);

                topUpcomingAnimeIntent.putExtra(ListActivity.EXTRA_MODE, modeActivity);

                // Start the new activity
                startActivity(topUpcomingAnimeIntent);
            }
        });

        // Set a click listener on the View
        mostPopularAnime.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the most popular anime category is clicked on.
            @Override
            public void onClick(View v) {
                int modeActivity = 3;
                // Create a new intent to open the {@link MostPopularActivity}
                Intent mostPopularAnimeIntent = new Intent(MainActivity.this, ListActivity.class);

                mostPopularAnimeIntent.putExtra(ListActivity.EXTRA_MODE, modeActivity);

                // Start the new activity
                startActivity(mostPopularAnimeIntent);
            }
        });
    }

    public void showAbout() {
        Intent topAiringAnimeIntent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(topAiringAnimeIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        if (selectedMode == R.id.about) {
            showAbout();
        }
    }
}
