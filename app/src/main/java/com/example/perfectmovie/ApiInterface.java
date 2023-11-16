package com.example.perfectmovie;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/v2.2/films/collections?type=TOP_250_MOVIES&page=1")
    Call<TopFilms> getTopFilmsList();
    @GET("api/v2.2/films/premieres?year=2019&month=FEBRUARY")
    Call<PremierFilm> getPremierFilmsList();
    @GET("api/v2.2/films/{id}/videos")
    Call<Trailer> getTrailerFilmsList(@Path("id") int filmId);
    @GET("api/v1/staff")
    Call<ArrayList<Staff>> getStaffList(@Query("filmId") int filmId);

}
