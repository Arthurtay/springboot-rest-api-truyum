package com.casestudy.truyum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.truyum.dao.MenuItemDao;
import com.casestudy.truyum.model.MenuItem;

@Service
public interface MenuItemService {
	
	public List<MenuItem> getMenuItemListCustomer();
	
	public MenuItem getMenuItem(long id);
	
	public MenuItem modifyMenuItem(MenuItem menuItem);
	
	
}
