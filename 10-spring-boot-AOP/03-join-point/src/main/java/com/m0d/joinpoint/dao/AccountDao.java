package com.m0d.joinpoint.dao;

import com.m0d.joinpoint.Account;

import java.util.List;

public interface AccountDao {
    void addAccount(Account account);
    List<Account> findAccounts();

    void findAccounts(boolean b);
}
