package com.example.movies.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface getData  {

    String Lang="en-US";
    String PosterBaseURL="http://image.tmdb.org/t/p/w300/";
    String Base_URL="https://api.themoviedb.org/3/movie/";
    String API_KEY="API_KEY";

    @GET("{sort_by}?api_key="+ API_KEY +"&language="+Lang)
    Call<Movies> getMovies(@Path("sort_by") String sort_by,
                           @Query("page") String page);

    @GET("{id}/videos?api_key="+API_KEY)
    Call<Videos> Videos(@Path("id") String id);

    @GET("{id}/reviews?api_key="+API_KEY)
    Call<Reviews> Reviews(@Path("id") String id,
                          @Query("page") String page);

}
