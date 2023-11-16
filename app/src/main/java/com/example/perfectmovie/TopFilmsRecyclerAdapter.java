package com.example.perfectmovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TopFilmsRecyclerAdapter extends RecyclerView.Adapter<TopFilmsRecyclerAdapter.TopFilmViewHolder> {

    private ArrayList<TopFilmItem> topFilms;
    private Context context;
    private OnItemClickListener _listener;

    public TopFilmsRecyclerAdapter(Context context, ArrayList<TopFilmItem> topFilms) {
        this.topFilms = topFilms;
        this.context = context;
    }
    @NonNull
    @Override
    public TopFilmsRecyclerAdapter.TopFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topfilms_card, parent, false);
        return new TopFilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopFilmsRecyclerAdapter.TopFilmViewHolder holder, int position) {
        TopFilmItem topFilm = topFilms.get(position);

        holder.title.setText(topFilm.getNameRu());
        holder.rating.setText(String.valueOf(topFilm.getRatingKinopoisk()));

        Picasso.with(context).load(topFilm.getPosterUrlPreview()).into(holder.poster);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();
                if (_listener != null && clickedPosition != RecyclerView.NO_POSITION) {
                    _listener.onItemClick(clickedPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return topFilms.size();
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this._listener = listener;
    }
    public class TopFilmViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView rating;
        ImageView poster;

        public TopFilmViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.top_title);
            rating = itemView.findViewById(R.id.top_rating);
            poster = itemView.findViewById(R.id.top_poster);
        }
    }
}
