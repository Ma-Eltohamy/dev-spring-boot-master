package com.m0d.beforeadvice.dao;

import com.m0d.beforeadvice.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + ": DOING MY DB WORK: adding an account");
    }
}
