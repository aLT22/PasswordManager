package com.bytebuilding.passwordmanager.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bytebuilding.passwordmanager.R;

public class AccountsListFragment extends Fragment {

    public static final String TAG = AccountsListFragment.class.getSimpleName();

    public static AccountsListFragment newInstance() {
        AccountsListFragment fragment = new AccountsListFragment();

        return fragment;
    }

    public static AccountsListFragment newInstance(Bundle args) {
        AccountsListFragment fragment = new AccountsListFragment();

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_accounts_list, container, false);
    }

}
