package com.example.movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movies.API.Movies;
import com.example.movies.API.Reviews;
import com.example.movies.API.getData;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieActivity extends AppCompatActivity {

    TextView OriginalName,Language,Rating,Adult,Overview,ReleaseDate,Title;
    ImageView Poster;
    Movies.MoviesBean movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movie);

        OriginalName=findViewById(R.id.OriginalNametxt);
        Language=findViewById(R.id.Languagetxt);
        Rating=findViewById(R.id.Ratingtxt);
        Adult=findViewById(R.id.Adulttxt);
        Overview=findViewById(R.id.Overview);
        ReleaseDate=findViewById(R.id.ReleaseDatetxt);
        Poster=findViewById(R.id.MovieThumbnail);
        Title=findViewById(R.id.Titletxt);

        Intent intent=getIntent();
        movies=intent.getParcelableExtra("movie");

        SetUIValues();
    }

    void SetUIValues(){

        Picasso.get()
                .load(getData.PosterBaseURL+movies.getPoster_path())
                .into(Poster, new Callback() {
                    @Override
                    public void onSuccess() {}

                    @Override
                    public void onError(Exception e) {
                        Picasso.get().load(R.drawable.default_img).into(Poster);
                        Log.e("PicassoError",e.getMessage());
                    }
                });

        setTitle(movies.getTitle());
        Title.setText(movies.getTitle() );

        OriginalName.setText(movies.getOriginal_title());
        Language.setText(movies.getOriginal_language());
        Rating.setText(String.valueOf(movies.getVote_average()));
        Adult.setText(String.valueOf(movies.isAdult()));
        ReleaseDate.setText(movies.getRelease_date());
        Overview.setText(movies.getOverview());
    }

    public void btnReviews(View view) {
        Intent intent=new Intent(this,reviews_trailers_activity.class);
        intent.putExtra("id",movies.getId());
        intent.putExtra("type",String.valueOf(R.string.Reviews));
        startActivity(intent);
    }


    public void btnTrailers(View view) {
        Intent intent=new Intent(this,reviews_trailers_activity.class);
        intent.putExtra("id",movies.getId());
        intent.putExtra("type",String.valueOf(R.string.video));
        startActivity(intent);
    }

}
