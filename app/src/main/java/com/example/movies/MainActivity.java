package com.example.movies;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.Recycler);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setHasFixedSize(true);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        favourite = new ArrayList<>();
        if (!new Internet().hasInternetAccess(this) || mainViewModel.getType().equals(getString(R.string.Favourite))) {
            getFavourite();
        } else if (mainViewModel.getType().equals(getString(R.string.MostPopular)))
            mainViewModel.getMostPopular();
        else
            mainViewModel.getTopRated();

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
                    moviesAdapter.setMovies(moviesBeans);
                }
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
                mainViewModel.getMostPopular();
                mainViewModel.setType(getString(R.string.MostPopular));
                return true;
            case R.id.Rating:
                mainViewModel.Init();
                moviesAdapter = null;
                mainViewModel.getTopRated();
                mainViewModel.setType(getString(R.string.TopRate));
                return true;
            case R.id.favourite:
                mainViewModel.Init();
                moviesAdapter = null;
                getFavourite();
                mainViewModel.setType(getString(R.string.Favourite));
            default:
                return true;
        }

    }

    public void getFavourite() {

        if(favourite.isEmpty())
            Toast.makeText(this, "no favourite movies yet", Toast.LENGTH_SHORT).show();
        if (moviesAdapter == null) {
            moviesAdapter = new MoviesAdapter(MainActivity.this, favourite);
            recyclerView.setAdapter(moviesAdapter);
        } else
            moviesAdapter.setMovies(favourite);
    }
    /*
    void getTopRated(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(getData.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getData data=retrofit.create(getData.class);
        call=data.TopRatedMovies(String.valueOf(mainViewModel.getPage()));

        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                Movies moviesCall=response.body();
                if(moviesCall==null)
                    return;
                moviesBeansList.addAll(moviesCall.getResults());

                if(moviesAdapter!=null && moviesCall.getPage()!=1)
                   moviesAdapter.notifyDataSetChanged();
                else{
                    moviesAdapter=new MoviesAdapter(MainActivity.this,moviesBeansList);
                    recyclerView.setAdapter(moviesAdapter);
                }

                if(moviesCall.getTotal_pages()==moviesCall.getPage())
                    return;
                else {
                    mainViewModel.setPage(mainViewModel.getPage()+1);
                    getTopRated();
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

                if(call.isCanceled())
                    return;
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("TopRatedError",t.getMessage());
            }
        });
    }

    void getMostPopular(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(getData.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getData data=retrofit.create(getData.class);
        call=data.MostPopularMovies(String.valueOf(mainViewModel.getPage()));

        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                Movies moviesCall=response.body();

                if(moviesCall==null)
                    return;
               moviesBeansList.addAll(moviesCall.getResults());

                if(moviesAdapter!=null && moviesCall.getPage()!=1)
                     moviesAdapter.notifyDataSetChanged();
                else{
                    moviesAdapter=new MoviesAdapter(MainActivity.this,moviesBeansList);
                    recyclerView.setAdapter(moviesAdapter);
                }

                if(moviesCall.getTotal_pages()==moviesCall.getPage())
                    return;
                else {
                    mainViewModel.setPage(mainViewModel.getPage()+1);
                    getMostPopular();
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                if(call.isCanceled())
                    return;

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("MostPopularError",t.getMessage());
            }
        });
    }

    void getFavourite(){
        if(mainViewModel.getMovies().getValue()==null || mainViewModel.getMovies().getValue().isEmpty())
            Toast.makeText(this, "no img_favourite movie yet", Toast.LENGTH_SHORT).show();
        mainViewModel.getMovies().observe(this, new Observer<List<Movies.MoviesBean>>() {
            @Override
            public void onChanged(List<Movies.MoviesBean> moviesBeans) {
                if(mainViewModel.getType().equals(getString(R.string.Favourite))){
                    recyclerView.setAdapter(new MoviesAdapter(getApplicationContext(),moviesBeans));
                }
            }
        });
    }
*/
}
