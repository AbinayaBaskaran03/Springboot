package com.drool.entity;

public class Drool {

	private String name;
	private String jobSector;
	private Integer monthlyIncome;
	private String incomeRange;
	private Integer taxAmount;
	private String annualtaxAmount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobSector() {
		return jobSector;
	}
	public void setJobSector(String jobSector) {
		this.jobSector = jobSector;
	}
	public Integer getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(Integer monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public String getIncomeRange() {
		return incomeRange;
	}
	public void setIncomeRange(String incomeRange) {
		this.incomeRange = incomeRange;
	}
	public Integer getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Integer taxAmount) {
		this.taxAmount = taxAmount;
	}
	public String getAnnualtaxAmount() {
		return annualtaxAmount;
	}
	public void setAnnualtaxAmount(String annualtaxAmount) {
		this.annualtaxAmount = annualtaxAmount;
	}
	 // Method to calculate tax amount based on income range
    public void calculateTaxAmount() {
        // Implement tax calculation logic based on income range
        if (incomeRange != null) {
            switch (incomeRange) {
                case "Low":
                    taxAmount = 0;
                    break;
                case "Medium":
                    taxAmount = 100;
                    break;
                case "High":
                    taxAmount = 150;
                    break;
                // Add more cases for other income ranges
                default:
                    taxAmount = 0; // Default to 0 if income range is not specified
                    break;
            }
        } else {
            taxAmount = 0; // Default to 0 if income range is not specified
        }
    }

    // Method to calculate annual tax amount based on monthly income and tax amount
    public void calculateAnnualTaxAmount() {
        if (monthlyIncome != null && taxAmount != null) {
            // Assuming tax amount is monthly, multiply by 12 to get annual tax amount
            double annualTax = taxAmount * 12;
            // Format annual tax amount to string
            annualtaxAmount = String.format("%.2f", annualTax);
        } else {
        	annualtaxAmount = "0.00"; // Default to 0 if monthly income or tax amount is not specified
        }
    }
}
