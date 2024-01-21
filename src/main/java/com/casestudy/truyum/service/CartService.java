package com.casestudy.truyum.service;

import java.util.List;

import com.casestudy.truyum.model.Cart;
import com.casestudy.truyum.model.MenuItem;

public interface CartService {
	 
	public List<Cart> getAllCartItems(String userName);
	public boolean deleteCart(String userName, int cart);
	public void addCartItem(String userId, List<Long> purchaseList);
	
}
