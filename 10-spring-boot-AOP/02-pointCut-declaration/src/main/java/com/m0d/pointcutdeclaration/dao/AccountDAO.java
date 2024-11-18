package com.m0d.pointcutdeclaration.dao;

import com.m0d.pointcutdeclaration.Account;

public interface AccountDAO {

    void addAccount(Account account, Boolean isVIP);

    String getName();
    void setName(String name);

    String getServiceCode();
    void setServiceCode(String serviceCode);


}
