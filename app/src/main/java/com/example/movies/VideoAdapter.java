package com.example.movies;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movies.API.Videos;

import java.util.List;

public class VideoAdapter  extends RecyclerView.Adapter<VideoAdapter.VideoVH> {

    List<Videos.ResultsBean> videosList;
    Context context;

    public VideoAdapter(Context context,List<Videos.ResultsBean> videos) {
        this.videosList = videos;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View v=inflater.inflate(R.layout.video,viewGroup,false);
        return new VideoVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoVH videoVH, final int i) {
        videoVH.Name.setText(videosList.get(i).getName());
        videoVH.Type.setText(videosList.get(i).getType());

        videoVH.VideoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v="+videosList.get(i).getKey()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videosList.size();
    }

    class VideoVH extends RecyclerView.ViewHolder{
        CardView VideoCard;
        TextView Name,Type;
        public VideoVH(@NonNull View itemView) {
            super(itemView);
            VideoCard=itemView.findViewById(R.id.video_card);
            Name=itemView.findViewById(R.id.video_name);
            Type=itemView.findViewById(R.id.video_type);
        }
    }
}
