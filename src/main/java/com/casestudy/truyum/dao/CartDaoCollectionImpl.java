package com.casestudy.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.casestudy.truyum.model.Cart;
import com.casestudy.truyum.model.MenuItem;
import com.casestudy.truyum.model.User;
import com.casestudy.truyum.repository.CartRepository;
import com.casestudy.truyum.repository.MenuItemRepository;
import com.casestudy.truyum.repository.UserRepository;

import jakarta.transaction.Transactional;

@Repository
public class CartDaoCollectionImpl implements CartDao {

	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MenuItemRepository itemRepo;

	private static HashMap<String, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<String, Cart>();
		}
	}

	@Override
	public void addCartItem(String userName, List<Long> purchasedList) {

		Cart cart = new Cart();
		User user = userRepo.findByUserName(userName);

		// Retrieve item prices and information.
		List<MenuItem> itemList = itemRepo.findByIdIn(purchasedList);
		double total = itemList.stream().mapToDouble(MenuItem::getPrice).sum();

		cart.setMenuItemList(itemList);
		cart.setTotal(total);
		cart.setUser(user);
		cartRepo.save(cart);

	}

	@Override
	public List<Cart> getAllCartItems(String userName) throws CartEmptyException {

		return cartRepo.findByUserUserName(userName);

	}

	@Override
	public void removeCartItem(String userId, long menuItemId) {
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();

	}

	@Override
	@Transactional
	public boolean removeCart(String userName, int cartId) {
		// TODO Auto-generated method stub
		cartRepo.delete(null);

		Optional<Cart> cart = cartRepo.findById(cartId);
		if (cart.isPresent()) {
			cartRepo.deleteByCartIdAndUserUserName(cartId, userName);
			return true;
		} else {
			return false;
		}

	}

}
