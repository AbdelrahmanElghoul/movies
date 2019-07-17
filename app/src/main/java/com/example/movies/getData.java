package com.example.movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface getData  {

    String Lang="en-US";
    String PosterBaseURL="http://image.tmdb.org/t/p/w300/";
    String Base_URL="https://api.themoviedb.org/3/movie/";
    String API_KEY="YOUR_API_KEY";

    @GET("top_rated?api_key="+ API_KEY +"&language="+Lang)
    Call<MoviesCall> TopRatedMovies(@Query("page") String page);

    @GET("popular?api_key="+ API_KEY +"&language="+Lang)
    Call<MoviesCall> MostPopularMovies(@Query("page") String page);

}
