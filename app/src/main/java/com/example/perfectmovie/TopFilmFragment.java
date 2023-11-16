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


public class TopFilmFragment extends Fragment implements OnItemClickListener {
    private RecyclerView topRecyclerView;
    private TopFilmsRecyclerAdapter topFilmAdapter;
    private ArrayList<TopFilmItem> tfi;
    ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_film, container, false);

        Animation fadeIn = AnimationUtils.loadAnimation(getContext(), R.anim.blunk_animation);
        view.startAnimation(fadeIn);

        progressBar = view.findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
        topRecyclerView = view.findViewById(R.id.topRecyclerView);

        ApiInterface apiInterface = ServiceBuilder.buildRequest().create(ApiInterface.class);
        Call<TopFilms> call = apiInterface.getTopFilmsList();

        call.enqueue(new Callback<TopFilms>() {
            @Override
            public void onResponse(Call<TopFilms> call, Response<TopFilms> response) {
                if (response.isSuccessful() && response.body() != null) {
                    progressBar.setVisibility(View.GONE);

                    topRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    topRecyclerView.setHasFixedSize(true);

                    ArrayList<TopFilmItem> topFilms = response.body().items;
                    tfi = topFilms;
                    topFilmAdapter = new TopFilmsRecyclerAdapter(getContext(), topFilms);
                    topFilmAdapter.setOnItemClickListener(TopFilmFragment.this);
                    topRecyclerView.setAdapter(topFilmAdapter);
                }
            }

            @Override
            public void onFailure(Call<TopFilms> call, Throwable t) {

            }
        });

        return view;
    }

    @Override
    public void onItemClick(int position) {
        TopFilmItem selectedfilm = tfi.get(position);

        Intent intent = new Intent(getContext(), detailview.class);
        intent.putExtra("id",String.valueOf(selectedfilm.getKinopoiskId()));
        intent.putExtra("name", selectedfilm.getNameRu());
        intent.putExtra("img", selectedfilm.getPosterUrlPreview());
        intent.putExtra("year", String.valueOf(selectedfilm.getYear()));
        intent.putExtra("fragment", "top");
        startActivity(intent);
    }
}