package com.m0d.joinpoint.dao;

import com.m0d.joinpoint.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl  implements  AccountDao{
    @Override
    public void addAccount(Account account) {
        System.out.println("Adding the new account.");
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();

        Account tmp1 = new Account("John", "Silver");
        Account tmp2 = new Account("Mahmoud", "Diamond");
        Account tmp3 = new Account("Luca", "Gold");

        myAccounts.add(tmp1);
        myAccounts.add(tmp2);
        myAccounts.add(tmp3);

        return myAccounts;
    }

    @Override
    public void findAccounts(boolean b) {
        if(b)
            throw new NullPointerException("Please turn off the TripWire");
    }
}
