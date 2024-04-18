package com.drool.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drool.entity.Drool;

@RestController
@RequestMapping("api")
public class DroolController {
	
	@Autowired
	private KieSession session;
	
	@PostMapping("/drool")
	public Drool orderNow(@RequestBody Drool drool) {
	    // Assuming you receive job sector, monthly income, and income range along with other order details
	    String jobSector = drool.getJobSector();
	    Integer monthlyIncome = drool.getMonthlyIncome();
	    String incomeRange = drool.getIncomeRange();

	    // Set the job sector, monthly income, and income range in the order
	    drool.setJobSector(jobSector);
	    drool.setMonthlyIncome(monthlyIncome);
	    drool.setIncomeRange(incomeRange);

	    // Insert the order into the Drools session and fire rules
	    session.insert(drool);
	    session.fireAllRules();

	    // At this point, tax amount and annual tax amount should be calculated and set in the order

	    return drool;
	}

	
	

}
