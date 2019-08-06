package com.example.favoriteconsumer;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_DATA = "extra_data";
    ImageView detailPhoto;
    TextView detailTitle;
    TextView detailDate;
    TextView detailDesc;
    TextView ratingDesc;
    MovieModel movie;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        movie = getIntent().getParcelableExtra(EXTRA_DATA);
        String poster = "https://image.tmdb.org/t/p/w500" + movie.getPosterPath();
        detailPhoto = findViewById(R.id.img_id);
        Glide.with(this)
                .load(poster)
                .apply(new RequestOptions().override(300, 300))
                .into(detailPhoto);
        detailTitle = findViewById(R.id.title_id);
        detailTitle.setText(movie.getTitle());
        detailDate = findViewById(R.id.date_id);
        String date = String.format(getResources().getString(R.string.date));
        System.out.println(date);
        detailDate.setText(date + " " + movie.getReleaseDate());
        detailDesc = findViewById(R.id.desc_id);
        String overview = String.format(getResources().getString(R.string.overview));
        detailDesc.setText(overview + "\n" + movie.getOverview());
        ratingDesc = findViewById(R.id.rating_id);
        String rating = String.format(getResources().getString(R.string.rating));
        ratingDesc.setText(rating + " " + movie.getVoteAverage());
        getSupportActionBar().setTitle(movie.getTitle());
    }
}
