package com.ibrahim.service;

import java.util.List;

import com.ibrahim.cart.CartItem;
import com.ibrahim.cart.ShoppingCart;
import com.ibrahim.exception.CustomerBalanceIsInsufficient;
import com.ibrahim.exception.EmptyCartException;
import com.ibrahim.model.Customer;

public class Checkout {
	
	private ShoppingCart shoppingCart;
	private Customer customer;
	

	public Checkout(ShoppingCart shoppingCart,Customer customer) {
		this.customer = customer;
		this.shoppingCart = shoppingCart;
	}
	
	
	public void checkout(Customer customer, ShoppingCart shoppingCart) throws EmptyCartException,CustomerBalanceIsInsufficient {
		int shippingCost = 30;
		double totalPakcageWeight = 0.0;
		if(shoppingCart.calculateOrderTotalWeight() > 0 && shoppingCart.calculateOrderSubtotal() > 0) {
			if(shoppingCart.calculateOrderSubtotal() + shippingCost <= customer.getCurrentBalance()) {
				System.out.println("** Shipment notice **");
				for(CartItem item : shoppingCart.getItems()) {
					double totalItemWeight = (item.getProduct().getWeight().get()) * (item.getQuantity());
					System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "		" + totalItemWeight + item.getProduct().getWeightType().get().toString());
					totalPakcageWeight += totalItemWeight;
				}
				System.out.println("Total package weight " + totalPakcageWeight/1000 + "\n");
				System.out.println("** Checkout receipt **");
				for(CartItem item : shoppingCart.getItems()) {
					double totalItemWeight = (item.getProduct().getWeight().get()) * (item.getQuantity());
					System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "		" + item.getTotalPrice());
					
				}
				double totalAmount = (shoppingCart.calculateOrderSubtotal() + shippingCost);
				System.out.println("----------------------");
				System.out.println("Subtotal		" + shoppingCart.calculateOrderSubtotal());
				System.out.println("Shipping		" + shippingCost);
				System.out.println("Amount		" +totalAmount + "\n");
				System.out.println("customer current balance after payment: " + (customer.getCurrentBalance()- totalAmount));

			}else {
				throw new CustomerBalanceIsInsufficient("Customer's balance is insufficient");

			}
		}
	}
}
