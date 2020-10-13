package com.example.movies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.movies.API.Movies;
import com.example.movies.API.getData;
import com.example.movies.Database.appDatabase;
import com.example.movies.Database.appExecuters;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MovieActivity extends AppCompatActivity {


    @BindView(R.id.OriginalNametxt) TextView OriginalName;
    @BindView(R.id.Languagetxt) TextView Language;
    @BindView(R.id.Ratingtxt) TextView Rating;
    @BindView(R.id.Adulttxt) TextView Adult;
    @BindView(R.id.Overview) TextView Overview;
    @BindView(R.id.ReleaseDatetxt) TextView ReleaseDate;
    @BindView(R.id.Titletxt) TextView Title;
    @BindView(R.id.MovieThumbnail) ImageView Poster;
    @BindView( R.id.btn_favourite) ImageView img_favourite;
    /*
    TextView OriginalName,Language,Rating,Adult,Overview,ReleaseDate,Title;
    ImageView Poster, img_favourite;
    */

    Movies.MoviesBean movies;
    boolean favourite =false;
    String TAG=MovieActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        Timber.plant(new Timber.DebugTree());
        Timber.d("ButterKnife Bind");

        final Intent intent=getIntent();
        movies=intent.getParcelableExtra("movie");

        CheckFavourite();

        img_favourite.setOnClickListener(v -> {
            if(favourite){
                img_favourite.setImageResource(R.drawable.unfavourite);
                appExecuters.getInstance().diskIO().execute(() -> appDatabase.getInstance(getApplicationContext()).moviesDAO().deleteMovieById(movies.getId()));
            }else{
                img_favourite.setImageResource(R.drawable.favourite);
                appExecuters.getInstance().diskIO().execute(() -> appDatabase.getInstance(getApplicationContext()).moviesDAO().insertMovie(movies));
            }
            favourite = !favourite;
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
                        Timber.d(e);
                    }
                });
        setTitle(movies.getTitle());
        Title.setText(movies.getTitle() );

        OriginalName.setText(movies.getOriginal_title());
        Language.setText(movies.getOriginal_language());
        Rating.setText(String.valueOf(movies.getVote_average()));
        Adult.setText(movies.isAdult()?"Adults only":"family friendly");
        ReleaseDate.setText(movies.getRelease_date());
        Overview.setText(movies.getOverview());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

    public void btnReviews(View view) {
        if(!new Internet().hasInternetAccess(this))
        {
            Toast.makeText(this, "you must be online to see reviews", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent=new Intent(this,reviews_trailers_activity.class);
        intent.putExtra("id",movies.getId());
        intent.putExtra("type",String.valueOf(R.string.Reviews));
        startActivity(intent);
    }

    public void btnTrailers(View view) {
        if(!new Internet().hasInternetAccess(this))
        {
            Toast.makeText(this, "you must be online to see trailers", Toast.LENGTH_SHORT).show();
            return;
        }
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
