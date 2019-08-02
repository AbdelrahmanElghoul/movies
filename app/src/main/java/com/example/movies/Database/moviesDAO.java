package com.example.movies.Database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.movies.API.Movies;

import java.util.List;

@Dao
public interface moviesDAO {


    @Query("select * from movies")
    LiveData<List<Movies.MoviesBean>> loadAll();

    @Insert
    void insertMovie(Movies.MoviesBean userData);

    @Delete
    void deleteMovie(Movies.MoviesBean userData);

    @Query("delete from movies where id=:id")
    void deleteMovieById(int id);

    @Query("select * from movies where id=:id")
    Movies.MoviesBean getMovieById(int id);
}
