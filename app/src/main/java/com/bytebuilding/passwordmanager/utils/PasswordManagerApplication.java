package com.bytebuilding.passwordmanager.utils;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Turkin A. on 20.12.2017.
 */

public class PasswordManagerApplication extends Application {

    public static final String TAG = PasswordManagerApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        setRealmSettings();
    }

    private void setRealmSettings() {
        Realm.init(this);
        RealmConfiguration accountConfiguration = new RealmConfiguration.Builder()
                .name("passwordmanager.realm")
                .build();
        Realm.setDefaultConfiguration(accountConfiguration);
    }
}
