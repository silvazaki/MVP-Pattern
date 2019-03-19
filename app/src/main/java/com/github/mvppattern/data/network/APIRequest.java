package com.github.mvppattern.data.network;

import android.util.Log;

import com.github.mvppattern.data.model.MovieItemsResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by User on 11/26/2018.
 */

public class APIRequest {

    private final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    private String TAG = "hasil";
    private AsyncHttpClient client;
    private Gson gson;

    public APIRequest() {
        gson = new GsonBuilder().create();
        client = new AsyncHttpClient();
//        client.addHeader("api_key","3dce2cc3191c483d42c878e6409fd560");
    }

    public void getNowPlaying(final MovieItemsResponse.MovieItemsCallback callback) {
        String requestUrl = BASE_URL + "now_playing?api_key=3dce2cc3191c483d42c878e6409fd560";
        client.get(requestUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String result = null;
                JSONObject response;
                try {
                    response = new JSONObject(new String(responseBody));
                    result = response.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e(TAG, "onSuccess: " + e.getMessage());
                }
                Log.e(TAG, "onSuccess: " + result);

                MovieItemsResponse productResponse = gson.fromJson(result, MovieItemsResponse.class);

                if (productResponse != null) {
                    callback.onSuccess(productResponse);
                } else {
                    callback.onError("Cannot get Object"+ErrorCode.NOT_FOUND);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                callback.onError("Koneksi gagal"+ErrorCode.NO_INTERNET);
            }
        });

    }

    public void cancelAllReq() {
        client.cancelAllRequests(true);
    }

    public enum ErrorCode {
        NOT_FOUND,
        NO_INTERNET,
        SERVER_ERROR
    }


}

