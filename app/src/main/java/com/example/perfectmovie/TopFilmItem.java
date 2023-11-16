package com.example.perfectmovie;

import java.util.ArrayList;

public class TopFilmItem {
    private int kinopoiskId;
    private String nameRu;
    private String nameEn;
    private String nameOriginal;
    private ArrayList<Country> countries;
    private ArrayList<Genre> genres;
    private double ratingKinopoisk;
    private double ratingImbd;
    private String year;
    private String type;
    private String posterUrl;
    private String posterUrlPreview;

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public void setRatingKinopoisk(double ratingKinopoisk) {
        this.ratingKinopoisk = ratingKinopoisk;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public void setKinopoiskId(int kinopoiskId) {
        this.kinopoiskId = kinopoiskId;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public void setPosterUrlPreview(String posterUrlPreview) {
        this.posterUrlPreview = posterUrlPreview;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public String getType() {
        return type;
    }

    public double getRatingKinopoisk() {
        return ratingKinopoisk;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public String getNameRu() {
        return nameRu;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public String getNameEn() {
        return nameEn;
    }

    public int getKinopoiskId() {
        return kinopoiskId;
    }

    public String getPosterUrlPreview() {
        return posterUrlPreview;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public double getRatingImbd() {
        return ratingImbd;
    }

    public String getYear() {
        return year;
    }

    public void setRatingImbd(double ratingImbd) {
        this.ratingImbd = ratingImbd;
    }

}
