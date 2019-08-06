package com.example.favoriteconsumer;

import android.database.Cursor;

import java.util.ArrayList;

public class MappingHelper {

    public static ArrayList<MovieModel>mapCursorToArrayList (Cursor moviesCursor)
    {
        ArrayList<MovieModel> movies = new ArrayList<>();

        if(moviesCursor != null)
        {
            while(moviesCursor.moveToNext())
            {
                int id = moviesCursor.getInt(moviesCursor.getColumnIndexOrThrow("id"));
                String title = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow("name"));
                String posterPath = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow("poster_path"));
                String overview = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow("overview"));
                String releaseDate = moviesCursor.getString(moviesCursor.getColumnIndexOrThrow("release_date"));
                double voteAverage = moviesCursor.getDouble(moviesCursor.getColumnIndexOrThrow("vote_average"));
                movies.add(new MovieModel(id,title,posterPath,overview,releaseDate,voteAverage));
            }
        }
        return movies;
    }
}
