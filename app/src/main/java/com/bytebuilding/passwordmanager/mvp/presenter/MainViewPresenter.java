package com.bytebuilding.passwordmanager.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.bytebuilding.passwordmanager.mvp.model.DataManager;
import com.bytebuilding.passwordmanager.mvp.model.RealmDataManager;
import com.bytebuilding.passwordmanager.mvp.view.MainView;

/**
 * Created by Turkin A. on 21.12.2017.
 */

@InjectViewState
public class MainViewPresenter extends MvpPresenter<MainView> {

    private DataManager mDataManager;

    public MainViewPresenter() {
        this.mDataManager = new RealmDataManager();
    }

    public void showAppropriateFragment() {
        if (mDataManager.getAccounts().size() == 0) {
            getViewState().showEmptyListFragment();
        } else {
            getViewState().showAccountsListFragment();
        }
    }

}
