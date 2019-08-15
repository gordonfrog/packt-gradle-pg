package com.packtpub.bankingapp.notifications.channels;

import com.packtpub.bankingapp.balance.dao.BalanceRepository;
import com.packtpub.bankingapp.balance.domain.Balance;

public interface NotificationChannel {

    default void send(Balance balance, BalanceRepository repo) {
    	if (repo != null) {
    		if (balance != null) {
    			System.out.println("sending balance...");
    			repo.save(balance);
    		}
    		else {
    			System.out.println("System Err: balance is null.");
    		}
    	}
        System.out.println("System Err: balance repo is null.");
        
    }
}
