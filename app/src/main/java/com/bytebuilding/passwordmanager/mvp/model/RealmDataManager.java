package com.bytebuilding.passwordmanager.mvp.model;

import android.util.Log;

import com.bytebuilding.passwordmanager.mvp.model.pojo.Account;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Turkin A. on 21.12.2017.
 */

public class RealmDataManager extends DataManager {

    public static final String TAG = RealmDataManager.class.getSimpleName();

    @Override
    public void saveAccount(final Account account) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.executeTransactionAsync(new Realm.Transaction() {
                                              @Override
                                              public void execute(Realm realm) {
                                                  Account accountRealm = realm.createObject(Account.class);
                                                  accountRealm.setAccountName(account.getAccountName());
                                                  accountRealm.setAccountLogin(account.getAccountLogin());
                                                  accountRealm.setAccountPassword(account.getAccountPassword());
                                                  accountRealm.setShownLoginInList(account.isShownLoginInList());
                                                  accountRealm.setAccountAdditionalInformation(account.getAccountAdditionalInformation());
                                                  accountRealm.setAccountPasswordDifficulty(account.getAccountPasswordDifficulty());
                                              }
                                          }, new Realm.Transaction.OnSuccess() {
                                              @Override
                                              public void onSuccess() {
                                                  Log.d(TAG, "onSuccess: " +
                                                          account.getAccountName() +
                                                          " " +
                                                          account.getAccountPassword());
                                              }
                                          }, new Realm.Transaction.OnError() {
                                              @Override
                                              public void onError(Throwable error) {
                                                  Log.d(TAG, "onError: " +
                                                          account.getAccountName() +
                                                          " " +
                                                          account.getAccountPassword());
                                              }
                                          }
            );
        } finally {
            realm.close();
        }
    }

    @Override
    public void saveAccounts(List<Account> accounts) {

    }

    @Override
    public void saveAccounts(Account... accounts) {

    }

    @Override
    public List<Account> getAccounts() {
        RealmResults<Account> realmResults;
        Realm realm = Realm.getDefaultInstance();
        try {
            realmResults = realm.where(Account.class)
                    .findAll();
            return realm.copyFromRealm(realmResults);
        } finally {
            realm.close();
        }
    }

    @Override
    public Account getAccountByName(String accountName) {
        return null;
    }

    @Override
    public Account getAccountByLogin(String accountLogin) {
        return null;
    }

    public void deleteAllAccounts() {

    }
}
