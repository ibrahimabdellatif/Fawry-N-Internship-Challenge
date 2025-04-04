package com.ibrahim.cart;

import java.util.ArrayList;
import java.util.List;

import com.ibrahim.exception.EmptyCartException;
import com.ibrahim.exception.InsufficientQuantityException;
import com.ibrahim.exception.ProductExpiredException;
import com.ibrahim.model.Customer;
import com.ibrahim.model.Product;

public class ShoppingCart {
	
	private List<CartItem> cartItems;
	
	public ShoppingCart() {
		this.cartItems = new ArrayList<CartItem>();
	}
	
	
	public void addCartItem(Product product, int quantity) throws InsufficientQuantityException, ProductExpiredException{
		
		if(product.getQuantity() < quantity) {
			throw new InsufficientQuantityException("Insufficient Quantity For: " + product.getName() + " Product!");
		}
		
		if(product.isExpire()) {
			throw new ProductExpiredException("The " + product.getName() + " product is expire");
		}
		
		CartItem item = new CartItem(product , quantity);
		cartItems.add(item);
		product.setQuantity(product.getQuantity() - quantity);
		
	}
	

	public List<CartItem> getItems(){
		return cartItems;
	}
	
//	sum of all items’ prices
	public double calculateOrderSubtotal() throws EmptyCartException{
		
		if(cartItems.isEmpty()) {
			throw new EmptyCartException("Cannot calculate the order subtotal for empty cart!");
		}
		
		double subtotal = 0.0;
		
		for(CartItem item : cartItems) {
			subtotal += item.getTotalPrice();
		}
		
		return subtotal;
	}
	
	public double calculateOrderTotalWeight() throws EmptyCartException{
		if(cartItems.isEmpty()) {
			throw new EmptyCartException("Cannot calculate the order total weight for empty cart!");
		}
		double orderTotalWeight = 0.0;
		for(CartItem item: cartItems) {
		orderTotalWeight +=	(item.getProduct().getWeight().get()) * (item.getQuantity());
		}
		return orderTotalWeight;
	}
	
	
	
	
}
