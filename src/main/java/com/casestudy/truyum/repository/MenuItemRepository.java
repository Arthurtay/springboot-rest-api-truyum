package com.casestudy.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.truyum.model.Cart;
import com.casestudy.truyum.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long>  {
	
	 // public List<MenuItem> findAll();  
	 
	  public List<MenuItem> findByIdIn(List<Long> itemList);
	  
	  public boolean deleteById(long id);
}	
