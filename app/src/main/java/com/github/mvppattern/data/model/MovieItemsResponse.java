package com.github.mvppattern.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 3/19/2019.
 */

public class MovieItemsResponse {
    @SerializedName("results")
    private List<MovieItems> movieItems;

    public List<MovieItems> getMovieItems() {
        return movieItems;
    }

    public void setMovieItems(List<MovieItems> movieItems) {
        this.movieItems = movieItems;
    }

    public interface MovieItemsCallback{
        void onSuccess(MovieItemsResponse movieItems);
        void onError(String message);
    }
}
