package com.example.movies;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movies.API.Reviews;

import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder> {


    List<Reviews.ResultsBean> reviewsList;
    Context context;

    public ReviewsAdapter(Context context,List<Reviews.ResultsBean> reviews) {
        this.reviewsList = reviews;
        this.context = context;
    }

    @NonNull
    @Override
    public ReviewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.reviews,viewGroup,false);
        return new ReviewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ReviewsViewHolder reviewsViewHolder, final int i) {
        reviewsViewHolder.Reviewer.setText(reviewsList.get(i).getAuthor());
        reviewsViewHolder.Review.setText(reviewsList.get(i).getContent());

        reviewsViewHolder.Review.setMovementMethod(new ScrollingMovementMethod());

    }

    @Override
    public int getItemCount() {
        return reviewsList.size();
    }

    class ReviewsViewHolder extends RecyclerView.ViewHolder{

        CardView reviewCard;
        TextView Reviewer,Review;
        public ReviewsViewHolder(@NonNull View itemView) {
            super(itemView);
            Reviewer=itemView.findViewById(R.id.reviewer_name);
            Review=itemView.findViewById(R.id.review);
            reviewCard=itemView.findViewById(R.id.review_card);
        }
    }
}
