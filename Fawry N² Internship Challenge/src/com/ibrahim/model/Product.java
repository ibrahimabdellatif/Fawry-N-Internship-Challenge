package com.ibrahim.model;

import java.time.LocalDate;
import java.util.Optional;

import com.ibrahim.model.enums.WeightType;

public class Product {

	private String name;
	private double price;
	private int quantity;
	private LocalDate expirationDate;
	
	private Optional<Double> weight;
	private Optional<WeightType> weightUnit;
	
	
	public Product(String name, double price, int quantity 
			, Optional<WeightType> weightUnit , Optional<Double> weight) {
		this.name = name;
		this.price  = price;
		this.quantity = quantity;
		this.weightUnit = weightUnit;
		this.weight = weight;
	}
	
	public Product(String name, double price
			,int quantity,  Optional<WeightType> weightUnit 
			, Optional<Double> weight, LocalDate expirationDate) {
		this.name = name;
		this.price  = price;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
		this.weightUnit = weightUnit;
		this.weight = weight;
	}
	
	
	public boolean isExpire() {
		if(expirationDate == null) {
			return false;
		}
		return LocalDate.now().isAfter(expirationDate);
	}
	
	
	public boolean isShippable() {
		
//		If we put our optional with empty
		if(weight.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
	public Optional<Double> getWeight(){
		return weight;
	}
	
	public Optional<WeightType> getWeightType(){
		return weightUnit;
	}
	
	
}
