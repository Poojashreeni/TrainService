package com.TrainService.TrainService.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
	private String from = "London";
    private String to = "France";
    private double price = 20.0;
    private User user;
    
    public Ticket(User user) {
        this.user = user;
    }

    // Getters
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getPrice() {
        return price;
    }

    public User getUser() {
        return user;
    }
}
