package com.example.favoriteconsumer;

import android.net.Uri;

public class DatabaseContract {
    private static final String TABLE_NAME = "MovieDB";
    private static final String AUTHORITY = "com.example.submission_3";
    private static final String SCHEME = "content";
    public static final Uri URI_MOVIE = new Uri.Builder().scheme(SCHEME)
            .authority(AUTHORITY)
            .appendPath(TABLE_NAME)
            .build();
}
