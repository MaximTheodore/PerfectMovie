package com.example.perfectmovie;

import java.util.ArrayList;

public class PremierFilmItem {
    private int kinopoiskId;
    private String nameRu;
    private String nameEn;
    private int year;
    private String posterUrl;
    private String posterUrlPreview;
    private ArrayList<Country> countries;
    private ArrayList<Genre> genres;
    private int duration;
    private String premiereRu;

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getPosterUrlPreview() {
        return posterUrlPreview;
    }

    public int getKinopoiskId() {
        return kinopoiskId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPosterUrlPreview(String posterUrlPreview) {
        this.posterUrlPreview = posterUrlPreview;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public void setKinopoiskId(int kinopoiskId) {
        this.kinopoiskId = kinopoiskId;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public int getYear() {
        return year;
    }

    public String getPremiereRu() {
        return premiereRu;
    }

    public void setPremiereRu(String premiereRu) {
        this.premiereRu = premiereRu;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
