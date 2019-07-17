package com.example.movies;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.Recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setHasFixedSize(true);


        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.show();
       getMostPopular(  new ArrayList<Movies>(),1);



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
                dialog.show();
                getMostPopular(new ArrayList<Movies>(),1);
                return true;
            case R.id.Rating:
                dialog.show();
                getTopRated(new ArrayList<Movies>(),1);
                return  true;
            default:
                return true;


        }

    }

    void getTopRated(final List<Movies> movies,final int page){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(getData.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getData data=retrofit.create(getData.class);
        Call <MoviesCall> call=data.TopRatedMovies(String.valueOf(page));

        call.enqueue(new Callback<MoviesCall>() {
            @Override
            public void onResponse(Call<MoviesCall> call, Response<MoviesCall> response) {
                MoviesCall moviesCall=response.body();
                if(moviesCall==null)
                    return;
                movies.addAll(moviesCall.getResults());

                if(moviesAdapter!=null)
                   moviesAdapter.notifyDataSetChanged();


                if(moviesCall.getPage()==1){
                    moviesAdapter=new MoviesAdapter(MainActivity.this,movies);
                    recyclerView.setAdapter(moviesAdapter);
                    dialog.dismiss();
                }

                if(moviesCall.getTotal_pages()==moviesCall.getPage())
                    return;
                else
                    getTopRated(movies,page+1);

            }

            @Override
            public void onFailure(Call<MoviesCall> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error",t.getMessage());
            }
        });
    }

    void getMostPopular(final List<Movies> movies,final int page){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(getData.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getData data=retrofit.create(getData.class);
        Call <MoviesCall> call=data.MostPopularMovies(String.valueOf(page));

        call.enqueue(new Callback<MoviesCall>() {
            @Override
            public void onResponse(Call<MoviesCall> call, Response<MoviesCall> response) {
                MoviesCall moviesCall=response.body();

                if(moviesCall==null)
                    return;
                movies.addAll(moviesCall.getResults());

                if(moviesAdapter!=null)
                     moviesAdapter.notifyDataSetChanged();

                if(moviesCall.getPage()==1){
                    moviesAdapter=new MoviesAdapter(MainActivity.this,movies);
                    recyclerView.setAdapter(moviesAdapter);
                    dialog.dismiss();
                }

                if(moviesCall.getTotal_pages()==moviesCall.getPage())
                    return;
                else
                    getMostPopular(movies,page+1);

            }

            @Override
            public void onFailure(Call<MoviesCall> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error",t.getMessage());
            }
        });
    }



}
