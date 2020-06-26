package com.example.flixter.models;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {


    String backdropPath;
    String posterPath;
    String title;
    String overview;

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath); //hardcoding for right now
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public Movie(@NotNull JSONObject jsonObject) throws JSONException {
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("title");
        this.overview = jsonObject.getString("overview");
    }

    //returns a list of movies from JSON array
    public static List<Movie> fromJsonArray(JSONArray movieJasonArray) throws JSONException
    {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i<movieJasonArray.length();i++)
        {
            movies.add(new Movie(movieJasonArray.getJSONObject(i)));
        }
        return movies;
    }
}
