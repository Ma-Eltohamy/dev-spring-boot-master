package com.m0d.beforeadvice;

import com.m0d.beforeadvice.dao.AccountDAO;
import com.m0d.beforeadvice.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDAO memberShipDAO){
        return runner -> {
            demoTheBeforeAdvice(accountDAO, memberShipDAO);
        };
   }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
        Account account = new Account();
        account.setFullName("Mahmoud Eltohamy");
        account.setLevel("9999");
        accountDAO.addAccount(account);
        memberShipDAO.addAccount();
    }
}