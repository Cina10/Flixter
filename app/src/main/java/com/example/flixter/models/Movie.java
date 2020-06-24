package com.example.flixter.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String posterPath;
    String title;
    String overview;

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public Movie(JSONObject jsonObject) {
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("title");
        this.overview = jsonObject.getString("overview");
    }

    //returns a list of movies from JSON array
    public static List<Movie> fromJsonArray(JSONArray movieJasonArray)
    {
        List<Movie> movie = new ArrayList<>();
        for(int i = 0; i<movieJasonArray.length();i++)
        {
            movie.add(new Movie(movieJasonArray.getJSONObject(i));
        }
    }
}
