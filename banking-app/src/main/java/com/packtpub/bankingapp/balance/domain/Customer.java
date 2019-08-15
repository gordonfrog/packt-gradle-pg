package com.packtpub.bankingapp.balance.domain;

import com.packtpub.bankingapp.notifications.domain.NotificationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@ToString
//@Data
//@NoArgsConstructor
@Entity
public class Customer {

    public Long getIdCustomer() {
		return idCustomer;
	}


	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<NotificationType> getPreferredNotificationChannels() {
		return preferredNotificationChannels;
	}


	public void setPreferredNotificationChannels(List<NotificationType> preferredNotificationChannels) {
		this.preferredNotificationChannels = preferredNotificationChannels;
	}


	@Id
    @GeneratedValue
    @Column(name = "id_customer")
    private Long idCustomer;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = NotificationType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "preferred_notification_channels")
    private List<NotificationType> preferredNotificationChannels;

    

    public Customer(String username, String password, NotificationType... preferredNotificationChannels) {
        this.username = username;
        this.password = password;
        this.preferredNotificationChannels = Arrays.asList(preferredNotificationChannels);
    }


	public Customer() {
		super();
	}
    
    
}
