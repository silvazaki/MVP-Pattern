package com.github.mvppattern.ui.main;

import com.github.mvppattern.data.Repository;
import com.github.mvppattern.data.model.MovieItemsResponse;

/**
 * Created by User on 3/19/2019.
 */

public class MainPresenter implements MainMVP.Presenter {

    private Repository repository;
    private MainMVP.View view;

    public MainPresenter(Repository repository, MainMVP.View view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void loadData() {

        repository.getNowPlaying(new MovieItemsResponse.MovieItemsCallback() {
            @Override
            public void onSuccess(MovieItemsResponse movieItems) {

                if (view != null) {
                    view.showLoading(false);
                    view.upDateList(movieItems.getMovieItems());
                }
            }

            @Override
            public void onError(String message) {
                if (view != null) {
                    view.showLoading(false);
                    view.showError("Gagal memuat");
                }

            }

        });
    }

    @Override
    public void onDestroy() {

    }
}
