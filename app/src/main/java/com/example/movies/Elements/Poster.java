package com.example.movies.Elements;

import com.google.gson.annotations.SerializedName;

public class Poster {
    @Override
    public String toString() {
        return "Poster{" +
                "url='" + url + '\'' +
                '}';
    }

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public Poster(String url) {
        this.url = url;
    }
}
