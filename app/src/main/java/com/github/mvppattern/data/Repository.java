package com.github.mvppattern.data;


import android.content.Context;

import com.github.mvppattern.data.local.SharedPrefHelper;
import com.github.mvppattern.data.model.MovieItems;
import com.github.mvppattern.data.model.MovieItemsResponse;
import com.github.mvppattern.data.network.APIRequest;

public class Repository {

    private Context mContext;
    private APIRequest apiRequest;
    private SharedPrefHelper prefs;

    public Repository(Context mContext) {
        this.mContext = mContext;
        apiRequest = new APIRequest();
        prefs = new SharedPrefHelper(mContext);

    }

    public void getNowPlaying(MovieItemsResponse.MovieItemsCallback callback) {
        apiRequest.getNowPlaying(callback);
    }

}
