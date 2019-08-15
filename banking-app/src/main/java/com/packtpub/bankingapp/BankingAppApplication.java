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
    
//    @Bean
//    public CommandLineRunner loadData(CustomerRepository custRepo, BalanceRepository balRepo) {
//        return (args) -> {
//        	NotificationChannel emailChannel = new EmailNotificationChannel();
//        	NotificationChannel faxChannel = new FaxNotificationChannel();
//        	NotificationChannelFactory notificationChannelsFactory = buildNotificationChannelFactory(emailChannel, faxChannel);
//        	
//        	Customer rene = new Customer("rene", "rene", NotificationType.EMAIL, NotificationType.FAX);
//        	Customer matt = new Customer("matt", "matt", NotificationType.FAX);
//        	custRepo.save(rene);
//        	custRepo.save(matt);
//        	
//        	System.out.println(rene.getIdCustomer() + ", "+ rene.getUsername() + ", "+ rene.getPassword());
//        	System.out.println(matt.getIdCustomer() + ", "+ matt.getUsername() + ", "+ matt.getPassword());
//        	
//        	List<NotificationType> notifications = rene.getPreferredNotificationChannels();
//        	if (notifications != null) {
//        		System.out.println("notification size = "+ notifications.size());
//        	}
//            Balance reneBalance = balRepo.findByCustomer(rene);
//            if (reneBalance != null) {
//            	System.out.println("rene's balance = "+ reneBalance.getIdBalance());
//            }
//            Balance mattBalance = balRepo.findByCustomer(matt);
//            if (mattBalance != null) {
//            	System.out.println("matt's balance = "+ mattBalance.getIdBalance());
//            }
//            
//            //BalanceService balanceService = new BalanceService(notificationChannelsFactory, balRepo);
//        	
//        	//balRepo.save(new Balance());
////            balanceService.sendBalance(rene);
////            balanceService.sendBalance(matt);
//        };
//    }
//    
//    private NotificationChannelFactory buildNotificationChannelFactory(NotificationChannel emailChannel, NotificationChannel faxChannel) {
//    	EmailNotificationChannel e = new EmailNotificationChannel();
//    	FaxNotificationChannel f = new FaxNotificationChannel();
//        NotificationChannelFactory notificationChannelsFactory = new NotificationChannelFactory(e, f);
////        if (notificationChannelsFactory.getNotificationChannel(NotificationType.EMAIL))
////        	notificationChannelsFactory.
////        when(notificationChannelsFactory.getNotificationChannel(NotificationType.FAX)).thenReturn(faxChannel);
//        return notificationChannelsFactory;
//    }
//
//    private List<NotificationType> getListOfNotificationTypes() {
//        List<NotificationType> preferredNotificationChannels = new ArrayList<>();
//        preferredNotificationChannels.add(NotificationType.EMAIL);
//        preferredNotificationChannels.add(NotificationType.FAX);
//        return preferredNotificationChannels;
//    }
}
