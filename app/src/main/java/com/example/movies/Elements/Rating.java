package com.example.movies.Elements;

import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("kp")

    private String kinopoisk;

    public String getKinopoisk() {
        return kinopoisk;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "kinopoisk='" + kinopoisk + '\'' +
                '}';
    }

    public Rating(String kinopoisk) {
        this.kinopoisk = kinopoisk;
    }
}
