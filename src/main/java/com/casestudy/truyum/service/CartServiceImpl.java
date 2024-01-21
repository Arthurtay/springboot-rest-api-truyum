package com.casestudy.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.truyum.dao.CartDao;
import com.casestudy.truyum.dao.CartEmptyException;
import com.casestudy.truyum.model.Cart;
import com.casestudy.truyum.model.MenuItem;


@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;
	
	
	@Override
	public void addCartItem(String userName, List<Long> purchasedList) {
		// TODO Auto-generated method stub
		cartDao.addCartItem(userName, purchasedList);
		
	
	}

	@Override
	public List<Cart> getAllCartItems(String userName) {
		// TODO Auto-generated method stub
		try {
			return cartDao.getAllCartItems(userName);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteCart(String userName, int cart) {
		
		
		return cartDao.removeCart(userName, cart);
	}



	
	
}
