package com.example.favoriteconsumer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class FavMovieAdapter extends RecyclerView.Adapter<FavMovieAdapter.ViewHolder> {
    private Context context;
    private List<MovieModel> movies;

    public FavMovieAdapter(Context context) {
        this.context = context;

    }
    public void setListMovies(List<MovieModel> movies)
    {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_movies, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final int pos = position;
        String poster = "https://image.tmdb.org/t/p/w500" + movies.get(pos).getPosterPath();
        Glide.with(context)
                .load(poster)
                .apply(new RequestOptions().override(300, 300))
                .into(holder.img);
        holder.txtTitle.setText(movies.get(pos).getTitle());
        holder.txtDateStart.setText(movies.get(pos).getReleaseDate());
        holder.rating.setText(Double.toString(movies.get(pos).getVoteAverage()));
        holder.imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(context, DetailActivity.class);
                detailIntent.putExtra(DetailActivity.EXTRA_DATA, movies.get(pos));
                context.startActivity(detailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtDateStart;
        TextView rating;
        TextView txtTitle;
        ImageButton imgButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgButton = itemView.findViewById(R.id.button_id);
            rating = itemView.findViewById(R.id.rating_id);
            img = itemView.findViewById(R.id.img_id);
            txtDateStart = itemView.findViewById(R.id.date_id);
            txtTitle = itemView.findViewById(R.id.title_id);
        }
    }
}
