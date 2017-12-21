package com.bytebuilding.passwordmanager.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bytebuilding.passwordmanager.R;

public class EmptyListFragment extends Fragment {

    public static final String TAG = EmptyListFragment.class.getSimpleName();

    public static EmptyListFragment newInstance() {
        EmptyListFragment fragment = new EmptyListFragment();

        return fragment;
    }

    public static EmptyListFragment newInstance(Bundle args) {
        EmptyListFragment fragment = new EmptyListFragment();

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_empty_list, container, false);
    }

}
