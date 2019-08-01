package com.example.movies;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.movies.API.Movies;
import com.example.movies.API.getData;
import com.example.movies.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    MoviesAdapter moviesAdapter;
    RecyclerView recyclerView;
    List<Movies.MoviesBean> moviesBeansList;
    MainViewModel mainViewModel;
    String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.Recycler);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setHasFixedSize(true);
        mainViewModel=ViewModelProviders.of(this).get(MainViewModel.class);

        moviesBeansList=new ArrayList<>();

        if(!new Internet().hasInternetAccess(this) || mainViewModel.getType().equals(getString(R.string.Favourite))){
            mainViewModel.getFavourite();
        }else if(mainViewModel.getType().equals(getString(R.string.MostPopular)))
            mainViewModel.getMostPopular();
        else if (mainViewModel.getType().equals(getString(R.string.TopRate)))
            mainViewModel.getTopRated();

        mainViewModel.getMovies().observe(this, new Observer<List<Movies.MoviesBean>>() {
            @Override
            public void onChanged(List<Movies.MoviesBean> moviesBeans) {

                Log.d(TAG,"Listener size "+moviesBeans.size());
                if(moviesAdapter==null) {
                    moviesAdapter=new MoviesAdapter(getApplicationContext(),moviesBeans);
                    recyclerView.setAdapter(moviesAdapter);
                }else {
                    moviesAdapter.setMovies(moviesBeans);
                    moviesAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.Popular:
                mainViewModel.Init();
                moviesAdapter=null;
                mainViewModel.getMostPopular();
                mainViewModel.setType(String.valueOf(R.string.MostPopular));
                return true;
            case R.id.Rating:
                mainViewModel.Init();
                moviesAdapter=null;
                mainViewModel.getTopRated();
                mainViewModel.setType(String.valueOf(R.string.TopRate));
                return  true;
            case R.id.favourite:
                mainViewModel.Init();
                moviesAdapter=null;
                mainViewModel.getFavourite();
                mainViewModel.setType(String.valueOf(R.string.Favourite));
            default:
                return true;
        }

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
