package com.TrainService.TrainService.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.TrainService.TrainService.Model.Ticket;
import com.TrainService.TrainService.Model.User;


@Service
public class TrainService {
	 private List<User> users = new ArrayList<>();
	    private final int maxSectionA = 50;
	    private final int maxSectionB = 50;

	    // Method to purchase ticket (add user)
	    public String purchaseTicket(User user) {
	        if (users.size() >= maxSectionA + maxSectionB) {
	            return "Train is full!";
	        }
	        user.setSeat(allocateSeat(user.getSection()));
	        users.add(user);
	        return "Ticket purchased successfully!";
	    }
	    
	    private String allocateSeat(String section) {
	        int seatNumber = (int) (Math.random() * 50) + 1;
	        return section + "-" + seatNumber;
	    }
	    
	    // Method to view receipt (get ticket details)
	    public Ticket getReceipt(String email) {
	        Optional<User> user = users.stream()
	                .filter(u -> u.getEmail().equals(email))
	                .findFirst();
	        return user.map(Ticket::new).orElse(null);
	    }
	    
	    public List<User> viewSeatsBySection(String section) {
	        return users.stream()
	                .filter(u -> u.getSection().equalsIgnoreCase(section))
	                .toList();
	    }

	    // Method to remove user
	    public String removeUser(String email) {
	        boolean removed = users.removeIf(u -> u.getEmail().equals(email));
	        return removed ? "User removed successfully!" : "User not found!";
	    }

	    // Method to modify seat
	    public String modifySeat(User modifiedUser) {
	        for (User user : users) {
	            if (user.getEmail().equals(modifiedUser.getEmail())) {
	                user.setSeat(allocateSeat(modifiedUser.getSection()));
	                return "Seat updated successfully!";
	            }
	        }
	        return "User not found!";
	    }
}
