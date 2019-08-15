package com.packtpub.bankingapp;

import com.packtpub.bankingapp.balance.dao.BalanceRepository;
import com.packtpub.bankingapp.balance.dao.CustomerRepository;
import com.packtpub.bankingapp.balance.domain.Balance;
import com.packtpub.bankingapp.balance.domain.Customer;
//import com.packtpub.bankingapp.balance.services.BalanceService;
import com.packtpub.bankingapp.notifications.channels.NotificationChannel;
import com.packtpub.bankingapp.notifications.channels.impl.EmailNotificationChannel;
import com.packtpub.bankingapp.notifications.channels.impl.FaxNotificationChannel;
import com.packtpub.bankingapp.notifications.domain.NotificationType;
import com.packtpub.bankingapp.notifications.factory.NotificationChannelFactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CustomerRepository repository) {
        return (args) -> {
            repository.save(new Customer("rene", "rene", NotificationType.EMAIL, NotificationType.FAX));
            repository.save(new Customer("matt", "matt", NotificationType.FAX));
        };
    }
}