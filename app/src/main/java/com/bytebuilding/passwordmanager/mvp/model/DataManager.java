package com.bytebuilding.passwordmanager.mvp.model;

import com.bytebuilding.passwordmanager.mvp.model.pojo.Account;

import java.util.List;

/**
 * Created by Turkin A. on 21.12.2017.
 */

public abstract class DataManager {

    public static final String TAG = DataManager.class.getSimpleName();

    public abstract void saveAccount(Account account);

    public abstract void saveAccounts(List<Account> accounts);

    public abstract void saveAccounts(Account...accounts);

    public abstract List<Account> getAccounts();

    public abstract Account getAccountByName(String accountName);

    public abstract Account getAccountByLogin(String accountLogin);

}
