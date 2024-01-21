package com.casestudy.truyum.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.casestudy.truyum.model.MenuItem;

@Repository
public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin();

	public List<MenuItem> getMenuItemListCustomer();

	public void modifyMenuItem(MenuItem menuItem);

	public MenuItem getMenuItem(long menuItemId);
	

	
}
