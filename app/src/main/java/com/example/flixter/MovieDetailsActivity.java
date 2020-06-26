package com.example.flixter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.Target;
import com.example.flixter.models.Movie;

import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {
    Movie movie;

    //viewObjects
    TextView tvTitle;
    TextView tvOverview;
    RatingBar rbVoteAve;
    ImageView ivPoster;

    private static final String TAG = "MovieDetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        rbVoteAve = (RatingBar) findViewById(R.id.rbVoteAve);
        ivPoster = (ImageView) findViewById(R.id.ivPoster);

        //unwrap parcel of the movie passed via intent, using simple name as key
        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d(TAG, String.format("Showing details for '%s'", movie.getTitle()));

        // set the title and overview
        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());

        // vote average is 0..10, convert to 0..5 by dividing by 2
        float voteAverage = movie.getVoteAve().floatValue();
        rbVoteAve.setRating(voteAverage = voteAverage > 0 ? voteAverage / 2.0f : voteAverage);

        String imageUrl = movie.getBackdropPath();
        int radius = 30;
        //set image
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            Glide.with(this).load(imageUrl)
                    .transform(new RoundedCorners(radius))
                    .placeholder(R.mipmap.placeholder_landscape_foreground).into(ivPoster);
        }
        else{
            Glide.with(this).load(imageUrl)
                    .transform(new RoundedCorners(radius))
                    .placeholder(R.mipmap.placeholder_landscape_foreground).into(ivPoster);
        }



    }
}
