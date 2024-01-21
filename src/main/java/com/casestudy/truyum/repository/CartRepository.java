package com.casestudy.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.truyum.model.Cart;
import com.casestudy.truyum.model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
	
	public List<Cart> findByUserUserName(String userName);
	
	public void deleteByCartIdAndUserUserName(int cartId, String userName);
	
}
