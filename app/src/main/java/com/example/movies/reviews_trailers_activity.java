package com.example.movies;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.movies.API.Reviews;
import com.example.movies.API.Videos;
import com.example.movies.API.getData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class reviews_trailers_activity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ReviewsAdapter reviewAdapter;
    VideoAdapter videoAdapter;
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews_trailers_activity);

        mRecyclerView=findViewById(R.id.mrecyclerview);

        Intent intent=getIntent();
        ID=intent.getIntExtra("id",-1);
        String type=intent.getStringExtra("type");

        if(ID==-1) {
            Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();
            finish();
        }

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        if(type.equals(String.valueOf(R.string.Reviews))){
            setTitle(R.string.Reviews);
            GetReviews(new ArrayList<Reviews.ResultsBean>() ,1);

        }else{
            setTitle(R.string.video);
            GetVideos(new ArrayList<Videos.ResultsBean>());
        }




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }


    void GetReviews(final List<Reviews.ResultsBean> ReviewsList, final int page){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(getData.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getData data=retrofit.create(getData.class);
        Call<com.example.movies.API.Reviews> call=data.Reviews(String.valueOf(ID),String.valueOf(page));

        call.enqueue(new retrofit2.Callback<Reviews>() {
            @Override
            public void onResponse(Call<com.example.movies.API.Reviews> call, Response<com.example.movies.API.Reviews> response) {
                com.example.movies.API.Reviews reviews=response.body();
                if(reviews==null){
                    return;
                }
                if(reviews.getResults().size()==0){
                    Toast.makeText(reviews_trailers_activity.this, "no reviews to display try again later", Toast.LENGTH_SHORT).show();
                    finish();
                }
                ReviewsList.addAll(reviews.getResults());

                if(reviewAdapter!=null)
                    reviewAdapter.notifyDataSetChanged();

                if(reviews.getPage()==1){
                    reviewAdapter=new ReviewsAdapter(reviews_trailers_activity.this,ReviewsList);
                    mRecyclerView.setAdapter(reviewAdapter);
                }

                if(reviews.getTotal_pages()==reviews.getPage())
                    return;
                else
                    GetReviews(ReviewsList,page+1);
            }

            @Override
            public void onFailure(Call<com.example.movies.API.Reviews> call, Throwable t) {
                Toast.makeText(reviews_trailers_activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("ReviewsError",t.getMessage());
            }
        });
    }

    void GetVideos(final List<com.example.movies.API.Videos.ResultsBean> videosList){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(getData.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getData data=retrofit.create(getData.class);
        Call<com.example.movies.API.Videos> call=data.Videos(String.valueOf(ID));

        call.enqueue(new retrofit2.Callback<Videos>() {
            @Override
            public void onResponse(Call<com.example.movies.API.Videos> call, Response<com.example.movies.API.Videos> response) {
                com.example.movies.API.Videos videos=response.body();
                if(videos==null)
                    return;

                if(videos.getResults().size()==0)
                {
                    Toast.makeText(reviews_trailers_activity.this, "no trialers to display try again later", Toast.LENGTH_SHORT).show();
                    finish();
                }
                videosList.addAll(videos.getResults());
                videoAdapter=new VideoAdapter(reviews_trailers_activity.this,videosList);
                mRecyclerView.setAdapter(videoAdapter);


            }

            @Override
            public void onFailure(Call<com.example.movies.API.Videos> call, Throwable t) {
                Toast.makeText(reviews_trailers_activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("ReviewsError",t.getMessage());
            }
        });
    }
}
