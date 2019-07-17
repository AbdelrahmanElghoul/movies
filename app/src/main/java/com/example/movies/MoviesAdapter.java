package com.example.movies;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private Context context;
    private List<Movies> movies;

    public MoviesAdapter(Context context, List<Movies> movies) {
        this.context = context;
        this.movies = movies;

    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.movies_posters,viewGroup,false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder ViewHolder, final int position) {

        Picasso.get().load(getData.PosterBaseURL+movies.get(position).getPoster_path()).into(ViewHolder.Poster);
        ViewHolder.Name.setText(movies.get(position).getTitle()+"\n("+movies.get(position).getRelease_year()+")");
        ViewHolder.Rate.setText(String.valueOf(movies.get(position).getVote_average()));

        ViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MovieActivity.class);
                intent.putExtra("movie",movies.get(position));

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView Poster;
        TextView Rate,Name;


        MoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            Poster= itemView.findViewById(R.id.Poster);
            Rate=itemView.findViewById(R.id.txtRate);
            Name=itemView.findViewById(R.id.txtName);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
