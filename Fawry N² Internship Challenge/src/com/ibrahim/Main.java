package com.ibrahim;

import java.time.LocalDate;
import java.util.Optional;

import com.ibrahim.cart.CartItem;
import com.ibrahim.cart.ShoppingCart;
import com.ibrahim.exception.CustomerBalanceIsInsufficient;
import com.ibrahim.exception.EmptyCartException;
import com.ibrahim.exception.InsufficientQuantityException;
import com.ibrahim.exception.ProductExpiredException;
import com.ibrahim.model.Customer;
import com.ibrahim.model.Product;
import com.ibrahim.model.enums.WeightType;
import com.ibrahim.service.Checkout;

public class Main {

	public static void main(String[] args) throws InsufficientQuantityException, ProductExpiredException, EmptyCartException, CustomerBalanceIsInsufficient {
		// TODO Auto-generated method stub

		System.out.println("Hello in our E-commerce App!");
		
		
		Product apple = new Product("apple", 2.0 , 20 
				,Optional.of(WeightType.GRAM) , Optional.of(70.0) 
				,LocalDate.of(2025, 4, 15) );
		
		Product egg = new Product("egg", 0.5 , 60 
				,Optional.of(WeightType.GRAM) , Optional.of(15.0) 
				,LocalDate.of(2025, 4, 15) );
		
		Customer customer = new Customer("ibrahim" , 500.0);

		ShoppingCart cart = new ShoppingCart();
		cart.addCartItem(apple, 1);
		
		cart.addCartItem(egg, 5);
		
		
		Checkout checkout = new Checkout(cart, customer);
		
		checkout.checkout(customer, cart);
		
	}

}
