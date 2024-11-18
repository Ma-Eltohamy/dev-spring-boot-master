package com.m0d.beforeadvice.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOImpl implements MemberShipDAO{
    @Override
    public void addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: adding a silly memberShip account");
    }

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: adding a memberShip account");
    }

}
