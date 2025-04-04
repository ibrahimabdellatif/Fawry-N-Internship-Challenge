package com.ibrahim.model;

public class Customer {
	
	private String name;
	private double currentBalance;
	
	public Customer(String name , double currentBalance) {
		this.name = name;
		this.currentBalance = currentBalance;
	}
	
	public String getName() {
		return name;
	}
	
	public double getCurrentBalance() {
		return currentBalance;
	}

}
