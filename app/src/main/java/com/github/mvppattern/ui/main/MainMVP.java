package com.github.mvppattern.ui.main;

import com.github.mvppattern.data.model.MovieItems;

import java.util.List;

/**
 * Created by User on 3/19/2019.
 */

public class MainMVP {
    public interface View {
        void showLoading(boolean isLoading);

        void showError(String message);

        void upDateList(List<MovieItems> movieItems);

    }


    public interface Presenter {
        void loadData();

        void onDestroy();
    }
}
