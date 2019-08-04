package com.example.movies.ViewModel;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movies.API.Movies;
import com.example.movies.API.getData;
import com.example.movies.Database.appDatabase;
import com.example.movies.Database.appExecuters;
import com.example.movies.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG=MainViewModel.class.getSimpleName();
    private LiveData<List<Movies.MoviesBean>> Favourite;
    private MutableLiveData<List<Movies.MoviesBean>> movies;
    private Call <Movies> call;
    private int page=1;
    private String type=getApplication().getString(R.string.TopRate);

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    private int getPage() {
        return page;
    }
    private void setPage(int page) {
        this.page = page;
    }

    public void Init(){
        Log.d(TAG,"Init");
        if(call!=null)
            call.cancel();
        movies.setValue(new ArrayList<Movies.MoviesBean>());
        Log.d(TAG,String.valueOf(getMovies().getValue().size()));
        page=1;

    }

    public MainViewModel(@NonNull Application application) {
        super(application);
        movies= new MutableLiveData<>();
        Favourite=new MutableLiveData<>();
        appExecuters.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                Favourite=appDatabase.getInstance(getApplication()).moviesDAO().loadAll();
            }
        });
        Log.d(TAG,"retrieving favourite from db");
        Init();
    }

    public LiveData<List<Movies.MoviesBean>> getMovies() {
        return movies;
    }

    public void getMoviesAPI(){
        Log.d(TAG,"MoviesAPI "+getType()+" "+getPage());

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(getData.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getData data=retrofit.create(getData.class);
        call=data.getMovies(this.getType(),String.valueOf(getPage()));
        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                Movies moviesCall=response.body();
                if(moviesCall==null)
                    return;
                List<Movies.MoviesBean> tmp=new ArrayList<>();
                if(page>1)
                 tmp.addAll(movies.getValue());
                tmp.addAll(moviesCall.getResults());
                movies.setValue(tmp);
                if(moviesCall.getTotal_pages()==moviesCall.getPage() || call.isCanceled())
                    return;

                setPage(getPage()+1);
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

                if(call.isCanceled())
                    return;
                Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("getMoviesAPI",t.getMessage());
            }
        });
    }

    public LiveData<List<Movies.MoviesBean>> getFavourite(){
       return Favourite;
    }

}