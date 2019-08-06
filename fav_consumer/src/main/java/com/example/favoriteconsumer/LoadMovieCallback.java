package com.example.favoriteconsumer;

import android.database.Cursor;

public interface LoadMovieCallback {
    void onPostExecute(Cursor movies);
}
