package com.bytebuilding.passwordmanager.mvp.model.pojo;

import io.realm.RealmObject;

/**
 * Created by Turkin A. on 21.12.2017.
 */

public class Account extends RealmObject {

    private String accountName;
    private String accountLogin;
    private boolean isShownLoginInList;
    private String accountPassword;
    private String accountPasswordDifficulty;
    private String accountAdditionalInformation;

    public Account() {
        this.accountName = "";
        this.accountLogin = "";
        this.isShownLoginInList = false;
        this.accountPassword = "";
        this.accountPasswordDifficulty = "";
        this.accountAdditionalInformation = "";
    }

    public Account(String accountName,
                   String accountLogin,
                   boolean isShownLoginInList,
                   String accountPassword,
                   String accountPasswordDifficulty,
                   String accountAdditionalInformation) {
        this.accountName = accountName;
        this.accountLogin = accountLogin;
        this.isShownLoginInList = isShownLoginInList;
        this.accountPassword = accountPassword;
        this.accountPasswordDifficulty = accountPasswordDifficulty;
        this.accountAdditionalInformation = accountAdditionalInformation;
    }

    public void savePasswordDifficulty(PasswordDifficulty passwordDifficulty) {
        this.accountPasswordDifficulty = passwordDifficulty.toString();
    }

    public PasswordDifficulty getPasswordDifficulty() {
        return (this.accountPasswordDifficulty != null) ? PasswordDifficulty.valueOf(this.accountPasswordDifficulty) : null;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountLogin() {
        return accountLogin;
    }

    public void setAccountLogin(String accountLogin) {
        this.accountLogin = accountLogin;
    }

    public boolean isShownLoginInList() {
        return isShownLoginInList;
    }

    public void setShownLoginInList(boolean shownLoginInList) {
        isShownLoginInList = shownLoginInList;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountPasswordDifficulty() {
        return accountPasswordDifficulty;
    }

    public void setAccountPasswordDifficulty(String accountPasswordDifficulty) {
        this.accountPasswordDifficulty = accountPasswordDifficulty;
    }

    public String getAccountAdditionalInformation() {
        return accountAdditionalInformation;
    }

    public void setAccountAdditionalInformation(String accountAdditionalInformation) {
        this.accountAdditionalInformation = accountAdditionalInformation;
    }
}
