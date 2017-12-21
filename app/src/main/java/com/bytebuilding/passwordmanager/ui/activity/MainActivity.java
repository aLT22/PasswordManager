package com.bytebuilding.passwordmanager.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bytebuilding.passwordmanager.R;
import com.bytebuilding.passwordmanager.mvp.presenter.MainViewPresenter;
import com.bytebuilding.passwordmanager.mvp.view.MainView;
import com.bytebuilding.passwordmanager.ui.fragment.AccountsListFragment;
import com.bytebuilding.passwordmanager.ui.fragment.EmptyListFragment;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    public static final String TAG = MainActivity.class.getSimpleName();

    @InjectPresenter
    MainViewPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter.showAppropriateFragment();
    }

    @Override
    public void showEmptyListFragment() {
        showAppropriateFragment(EmptyListFragment.newInstance(), EmptyListFragment.TAG);
    }

    @Override
    public void showAccountsListFragment() {
        showAppropriateFragment(AccountsListFragment.newInstance(), AccountsListFragment.TAG);
    }

    private void showAppropriateFragment(Fragment instance, String tag) {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, instance, tag)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, instance, tag)
                    .commit();
        }
    }
}
