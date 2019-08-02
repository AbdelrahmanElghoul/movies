package com.example.movies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movies.API.Movies;
import com.example.movies.API.getData;
import com.example.movies.Database.appDatabase;
import com.example.movies.Database.appExecuters;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MovieActivity extends AppCompatActivity {

    TextView OriginalName,Language,Rating,Adult,Overview,ReleaseDate,Title;
    ImageView Poster, img_favourite;
    Movies.MoviesBean movies;
    boolean favourite =false;
    String TAG=MovieActivity.class.getSimpleName();

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
        img_favourite =findViewById(R.id.btn_favourite);

        final Intent intent=getIntent();
        movies=intent.getParcelableExtra("movie");

        CheckFavourite();

        img_favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(favourite){
                    img_favourite.setImageResource(R.drawable.unfavourite);
                    appExecuters.getInstance().diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            appDatabase.getInstance(getApplicationContext()).moviesDAO().deleteMovieById(movies.getId());
                        }
                    });
                }else{
                    img_favourite.setImageResource(R.drawable.favourite);
                    appExecuters.getInstance().diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            appDatabase.getInstance(getApplicationContext()).moviesDAO().insertMovie(movies);
                        }
                    });
                }
                favourite = !favourite;
            }
        });

        SetUIValues();
    }

    void SetUIValues(){

        Picasso.get()
                .load(getData.PosterBaseURL+movies.getPoster_path())
                .error(R.drawable.default_img)
                .into(Poster, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        Log.d(TAG,e.getMessage());
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

    public void CheckFavourite(){

        appExecuters.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (appDatabase.getInstance(getApplicationContext()).moviesDAO().getMovieById(movies.getId()) != null) {
                    favourite = true;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            img_favourite.setImageResource(R.drawable.favourite);

                        }
                    });
                }
            }
        });

    }

}
