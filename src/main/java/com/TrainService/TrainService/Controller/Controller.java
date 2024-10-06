package com.TrainService.TrainService.Controller;

import java.util.List;

import javax.management.relation.RelationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TrainService.TrainService.TrainServiceApplication;
import com.TrainService.TrainService.Model.Ticket;
import com.TrainService.TrainService.Model.User;
import com.TrainService.TrainService.Service.TrainService;

@RestController
@RequestMapping("/train")
public class Controller {

	  private final TrainService trainService;

	    @Autowired
	    public Controller(TrainService trainService) {
	        this.trainService = trainService;
	    }
	    @PostMapping("/purchase")
	    public String purchaseTicket(@RequestBody User user) {
	        return trainService.purchaseTicket(user);
	    }   
	  

	    @GetMapping("/receipt/{email}")
	    public Ticket getReceipt(@PathVariable String email) {
	        return trainService.getReceipt(email);
	    }
	    
	    @GetMapping("/seats/{section}")
	    public List<User> viewSeatsBySection(@PathVariable String section) {
	        return trainService.viewSeatsBySection(section);
	    }

	    @DeleteMapping("/remove/{email}")
	    public String removeUser(@PathVariable String email) {
	        return trainService.removeUser(email);
	    }

	    @PutMapping("/modify-seat")
	    public String modifySeat(@RequestBody User user) {
	        return trainService.modifySeat(user);
	    }

	}


