package com.example.movies;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.API.Movies;
import com.example.movies.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MoviesAdapter moviesAdapter;
    RecyclerView recyclerView;
    MainViewModel mainViewModel;
    List<Movies.MoviesBean> favourite;
    String TAG = MainActivity.class.getSimpleName();
    GridLayoutManager gridLayoutManager;
    private final String RV_POSITION_KEY="RV_Pos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.Recycler);

        gridLayoutManager=new GridLayoutManager(this,3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        favourite = new ArrayList<>();

        if(savedInstanceState!=null) {
            Log.d(TAG,"Instance Restored");
            int pos=savedInstanceState.getInt(RV_POSITION_KEY,-1);
            if(mainViewModel.getMovies().getValue()!=null
                    && !mainViewModel.getMovies().getValue().isEmpty()
                    && pos > -1){
                moviesAdapter=new MoviesAdapter(this,mainViewModel.getMovies().getValue());
                recyclerView.setAdapter(moviesAdapter);
                recyclerView.scrollToPosition(pos);
            }
        }

        if(moviesAdapter==null) {
            if (!new Internet().hasInternetAccess(this) || mainViewModel.getType().equals(getString(R.string.Favourite))) {
                mainViewModel.setType(getString(R.string.Favourite));
                getFavourite();
            } else
                mainViewModel.getMoviesAPI();
        }
        mainViewModel.getMovies().observe(this, new Observer<List<Movies.MoviesBean>>() {
            @Override
            public void onChanged(List<Movies.MoviesBean> moviesBeans) {
                Log.d(TAG, "Movie Listener size " + moviesBeans.size());
                if (!mainViewModel.getType().equals(getString(R.string.Favourite))) {
                    if (moviesAdapter == null) {
                        moviesAdapter = new MoviesAdapter(MainActivity.this, moviesBeans);
                        recyclerView.setAdapter(moviesAdapter);
                    } else {
                        moviesAdapter.setMovies(moviesBeans);
                    }
                }
            }
        });

        mainViewModel.getFavourite().observe(this, new Observer<List<Movies.MoviesBean>>() {
            @Override
            public void onChanged(List<Movies.MoviesBean> moviesBeans) {
                favourite = moviesBeans;
                Log.d(TAG, "Favourite Listener size " + moviesBeans.size());
                if (mainViewModel.getType().equals(getString(R.string.Favourite))) {
                    moviesAdapter.setMovies(favourite);
                }
            }
        });

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                mainViewModel.getMoviesAPI();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Popular:
                mainViewModel.Init();
                moviesAdapter = null;
                mainViewModel.setType(getString(R.string.MostPopular));
                mainViewModel.getMoviesAPI();
                return true;
            case R.id.Rating:
                mainViewModel.Init();
                moviesAdapter = null;
                mainViewModel.setType(getString(R.string.TopRate));
                mainViewModel.getMoviesAPI();
                return true;
            case R.id.favourite:
                mainViewModel.Init();
                moviesAdapter = null;
                mainViewModel.setType(getString(R.string.Favourite));
                getFavourite();
            default:
                return true;
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if(moviesAdapter!=null && moviesAdapter.getItemCount()>0){
            outState.putInt(RV_POSITION_KEY,gridLayoutManager.findFirstVisibleItemPosition());
            Log.d(TAG,"RV Pos "+gridLayoutManager.findFirstVisibleItemPosition());
        }
    }

    public void getFavourite() {

        if (moviesAdapter == null) {
            moviesAdapter = new MoviesAdapter(MainActivity.this, favourite);
            recyclerView.setAdapter(moviesAdapter);
        } else
            moviesAdapter.setMovies(favourite);
    }
}
