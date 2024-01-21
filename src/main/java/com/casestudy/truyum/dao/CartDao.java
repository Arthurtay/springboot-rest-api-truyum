package com.casestudy.truyum.dao;

import java.util.List;

import com.casestudy.truyum.model.Cart;
import com.casestudy.truyum.model.MenuItem;

public interface CartDao {
	public void addCartItem(String userId, List<Long> purchasedList);

	public List<Cart> getAllCartItems(String userId) throws CartEmptyException;

	public void removeCartItem(String userId, long menuItemId);
	
	public boolean removeCart(String userName, int cartId);
	
}
