package com.example.listanime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Objects;

public class ListActivity extends AppCompatActivity {
    public static final String EXTRA_MODE = "extra_mode";
    private RecyclerView rvAnimes;
    private boolean isCardView = true;
    private ArrayList<Anime> animes = new ArrayList<Anime>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anime_list);

        int mode = getIntent().getIntExtra(EXTRA_MODE, 0);

        //add back icon
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        switch (mode) {
            case 1:
                // Create a list of animes.
                animes.add(new Anime("Kaguya-sama: Love is War Season 2", getString(R.string.kaguya_sama), R.drawable.kaguya));
                animes.add(new Anime("Kingdom 3rd Season", getString(R.string.kingdom), R.drawable.kingdom));
                animes.add(new Anime("One Piece", getString(R.string.one_piece), R.drawable.onepiece));
                animes.add(new Anime("Toaru Kagaku no Railgun T", getString(R.string.toaru), R.drawable.toaru));
                animes.add(new Anime("Fruits Basket 2nd Season", getString(R.string.fruit_basket), R.drawable.fruitbasket));
                animes.add(new Anime("Detective Conan", getString(R.string.detective_conan), R.drawable.conan));
                animes.add(new Anime("Ascendance of a Bookworm", getString(R.string.honzuki), R.drawable.honzuki));
                animes.add(new Anime("Kami no Tou", getString(R.string.kami_nou), R.drawable.kaminou));
                animes.add(new Anime("Seitokai Yakuindomo", getString(R.string.seitokai), R.drawable.seitokai));
                animes.add(new Anime("Douluo Dalu 2nd Season", getString(R.string.douluo), R.drawable.douluo));
                animes.add(new Anime("BNA", getString(R.string.bna), R.drawable.bna));
                this.setTitle("Top Airing Anime");
                break;
            case 2:
                // Create a list of animes.
                animes.add(new Anime("Re:Zero kara Hajimeru Isekai Seikatsu 2nd Season", getString(R.string.rezero), R.drawable.rezero));
                animes.add(new Anime("Kimetsu no Yaiba Movie: Mugen Ressha-hen", getString(R.string.kimetsu), R.drawable.kimetsu));
                animes.add(new Anime("Evangelion: 3.0+1.0", getString(R.string.evangelion), R.drawable.evangelion));
                animes.add(new Anime("Yahari Ore no Seishun Love Comedy wa Machigatteiru. Kan", getString(R.string.oregairu), R.drawable.oregairu));
                animes.add(new Anime("Yakusoku no Neverland 2nd Season", getString(R.string.yakusoku), R.drawable.yakusoku));
                animes.add(new Anime("Tensei shitara Slime Datta Ken 2nd Season", getString(R.string.tensei), R.drawable.tensei));
                animes.add(new Anime("Tate no Yuusha no Nariagari 2nd Season", getString(R.string.tate), R.drawable.tatenoyuusha));
                animes.add(new Anime("Violet Evergarden Movie", getString(R.string.violet), R.drawable.violet));
                animes.add(new Anime("Dr. Stone: Stone Wars", getString(R.string.dr_stone), R.drawable.dr_stone));
                animes.add(new Anime("Shingeki no Kyojin The Final Season", getString(R.string.shingeki), R.drawable.shingeki));
                animes.add(new Anime("Sword Art Online: Alicization - War of Underworld 2nd Season", getString(R.string.sao), R.drawable.sao));
                this.setTitle("Top Upcoming Anime");
                break;
            case 3:
                // Create a list of animes.
                animes.add(new Anime("Death Note", getString(R.string.death_note), R.drawable.death_note));
                animes.add(new Anime("Shingeki no Kyojin", getString(R.string.shingeki_popular), R.drawable.shingeki_popular));
                animes.add(new Anime("Sword Art Online", getString(R.string.sao_popular), R.drawable.sao_popular));
                animes.add(new Anime("Fullmetal Alchemist: Brotherhood", getString(R.string.fullmetal), R.drawable.fullmetal));
                animes.add(new Anime("One Punch Man", getString(R.string.one_punch), R.drawable.one_punch));
                animes.add(new Anime("Tokyo Ghoul", getString(R.string.tokyo_ghoul), R.drawable.tokyo_ghoul));
                animes.add(new Anime("Steins;Gate", getString(R.string.stein_gate), R.drawable.stein_gate));
                animes.add(new Anime("Naruto", getString(R.string.naruto), R.drawable.naruto));
                animes.add(new Anime("No Game No Life", getString(R.string.nogame_nolife), R.drawable.nogame_nolife));
                animes.add(new Anime("Boku no Hero Academia", getString(R.string.boku_no_hero), R.drawable.boku_no_hero));
                animes.add(new Anime("Angel Beats!", getString(R.string.angle_beat), R.drawable.angel_beats));
                this.setTitle("Most Popular Anime");
                break;
        }
        rvAnimes = findViewById(R.id.rv_animes);
        rvAnimes.setHasFixedSize(true);

        showRecyclerCardView();
    }

    private void showRecyclerList(){
        rvAnimes.setLayoutManager(new LinearLayoutManager(this));
        AnimeAdapter listAnimeAdapter = new AnimeAdapter(animes);
        rvAnimes.setAdapter(listAnimeAdapter);

        listAnimeAdapter.setOnItemClickCallback(new AnimeAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Anime data) {
                showSelectedAnime(data);
            }
        });
    }

    private void showRecyclerGrid(){
        rvAnimes.setLayoutManager(new GridLayoutManager(this, 2));
        GridAnimeAdapter gridAnimeAdapter = new GridAnimeAdapter(animes);
        rvAnimes.setAdapter(gridAnimeAdapter);

        gridAnimeAdapter.setOnItemClickCallback(new GridAnimeAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Anime data) {
                showSelectedAnime(data);
            }
        });
    }

    private void showRecyclerCardView(){
        rvAnimes.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapter cardViewAnimeAdapter = new CardViewAdapter(animes);
        rvAnimes.setAdapter(cardViewAnimeAdapter);

        cardViewAnimeAdapter.setOnItemClickCallback(new CardViewAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Anime data) {
                showSelectedAnime(data);
            }
        });
    }

    public void showAbout() {
        Intent topAiringAnimeIntent = new Intent(ListActivity.this, AboutActivity.class);
        startActivity(topAiringAnimeIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        //Do something whenever the item clicked
        if (isCardView && (item.getItemId() == R.id.action_grid)) {
            item.setIcon(R.drawable.card_icon);
            isCardView = false;
        } else {
            item.setIcon(R.drawable.grid_icon);
            isCardView = true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSelectedAnime(Anime anime) {
        Intent seeDetail = new Intent(ListActivity.this, DetailActivity.class);
        seeDetail.putExtra(DetailActivity.EXTRA_NAME, anime.getTitle());
        seeDetail.putExtra(DetailActivity.EXTRA_IMAGE, anime.getImageResourceId());
        seeDetail.putExtra(DetailActivity.EXTRA_SYNOPSIS, anime.getDescription());
        startActivity(seeDetail);
    }

    public void setMode(int selectedMode) {
        //choose menu to be click
        switch (selectedMode) {
            case R.id.about:
                showAbout();
                break;
            case R.id.action_grid:
                if (isCardView)
                    showRecyclerGrid();
                else
                    showRecyclerCardView();
                break;
        }
    }
}
