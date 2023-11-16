package com.example.perfectmovie;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PremierFilmFragment extends Fragment implements OnItemClickListener {

    private RecyclerView premierRecyclerView;
    private PremierFilmRecyclerAdapter premierFilmAdapter;
    private ProgressBar progressBar;
    private ArrayList<PremierFilmItem> pfi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_premier_film, container, false);
        premierRecyclerView = view.findViewById(R.id.premierRecyclerView);
        progressBar = view.findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);

        Animation fadeIn = AnimationUtils.loadAnimation(getContext(), R.anim.blunk_animation);
        view.startAnimation(fadeIn);

        ApiInterface apiInterface = ServiceBuilder.buildRequest().create(ApiInterface.class);
        Call<PremierFilm> call = apiInterface.getPremierFilmsList();

        call.enqueue(new Callback<PremierFilm>() {
            @Override
            public void onResponse(Call<PremierFilm> call, Response<PremierFilm> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    premierRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    premierRecyclerView.setHasFixedSize(true);
                    PremierFilm film = response.body();
                    pfi = film.items;

                    PremierFilmRecyclerAdapter premierFilmAdapter = new PremierFilmRecyclerAdapter(getContext(), film.items);
                    premierFilmAdapter.setOnItemClickListener(PremierFilmFragment.this);
                    premierRecyclerView.setAdapter(premierFilmAdapter);

                } else {
                    Toast.makeText(getContext(), response.message() + " " + response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PremierFilm> call, Throwable t) {

            }
        });

        return view;
    }

    public void onItemClick(int position) {
        PremierFilmItem selectedfilm = pfi.get(position);

        Intent intent = new Intent(getContext(), detailview.class);
        intent.putExtra("id",String.valueOf(selectedfilm.getKinopoiskId()));
        intent.putExtra("name", selectedfilm.getNameRu());
        intent.putExtra("img", selectedfilm.getPosterUrlPreview());
        intent.putExtra("year", selectedfilm.getPremiereRu());
        intent.putExtra("fragment", "premier");

        startActivity(intent);
    }
}