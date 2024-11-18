package com.m0d.joinpoint;

import com.m0d.joinpoint.dao.AccountDao;
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
    CommandLineRunner commandLineRunner(AccountDao accountDao){
        return runner ->{
            try {
                accountDao.findAccounts(false);
            }
            catch (Exception e){
                System.out.println("Main App: ... caught exception " + e.getMessage());
            }
        };
    }

}
