package com.m0d.pointcutdeclaration;

import com.m0d.pointcutdeclaration.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PointCutDeclarationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PointCutDeclarationApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO){
        return runner -> {
//            accountDAO.setName("Mahmoud");
//            accountDAO.setServiceCode("61961");
//            accountDAO.getName();
//            accountDAO.getServiceCode();
            Account newAccount = new Account("Mahmoud Eltohamy", "992");
            accountDAO.addAccount(newAccount, true);
        };
    }

}
