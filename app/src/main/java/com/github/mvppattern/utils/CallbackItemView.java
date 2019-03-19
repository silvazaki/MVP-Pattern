package com.github.mvppattern.utils;


import android.view.View;


public interface CallbackItemView {
    public interface MovieItemCallback {
        void onItemClick(int position, View view);
    }
}


