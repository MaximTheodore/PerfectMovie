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

public class PremierFilmRecyclerAdapter extends RecyclerView.Adapter<PremierFilmRecyclerAdapter.PremierFilmViewHolder> {

    private ArrayList<PremierFilmItem> premierFilms;
    private Context cont;
    private OnItemClickListener _listener;

    public PremierFilmRecyclerAdapter(Context context, ArrayList<PremierFilmItem> premierFilms) {
        this.premierFilms = premierFilms;
        this.cont = context;
    }

    @NonNull
    @Override
    public PremierFilmRecyclerAdapter.PremierFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.premierfilm_card, parent, false);
        return new PremierFilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PremierFilmRecyclerAdapter.PremierFilmViewHolder holder, int position) {
        PremierFilmItem premierFilm = premierFilms.get(position);
        holder.title.setText(premierFilm.getNameRu());
        holder.year.setText(String.valueOf(premierFilm.getYear()));
        Picasso.with(holder.itemView.getContext())
                .load(premierFilm.getPosterUrlPreview())
                .into(holder.poster);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition();
                if (_listener != null && clickedPosition != RecyclerView.NO_POSITION) {
                    _listener.onItemClick(clickedPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return premierFilms.size();
    }



    public void setOnItemClickListener(OnItemClickListener listener) {
        this._listener = listener;
    }

    public class PremierFilmViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView year;
        ImageView poster;

        public PremierFilmViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.premier_title);
            year = itemView.findViewById(R.id.premier_year);
            poster = itemView.findViewById(R.id.premier_poster);
        }
    }
}
