package com.github.mvppattern.base;

import android.support.v4.app.Fragment;
import android.util.Log;


import com.github.mvppattern.App;
import com.github.mvppattern.data.Repository;

import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private static String TAG = "basefraggmen";
    protected Unbinder unbinder;

    protected void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView: ");
        if (unbinder != null) unbinder.unbind();
        super.onDestroyView();

    }

    protected Repository getRepository() {
        return ((App) getActivity().getApplication()).getRepository();
    }
}
