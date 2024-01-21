package com.casestudy.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.truyum.dao.MenuItemDao;
import com.casestudy.truyum.model.MenuItem;

@Service
public class MenuItemServiceImpl implements MenuItemService {
	
	@Autowired
	MenuItemDao menuDao; 
	
	
	public List<MenuItem> getMenuItemListCustomer() {
		//get List of item
		return menuDao.getMenuItemListCustomer();
	 
	}


	@Override
	public MenuItem getMenuItem(long id) {
		
		return menuDao.getMenuItem(id);
	}


	@Override
	public MenuItem modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		menuDao.modifyMenuItem(menuItem);
		return menuItem;
	}
}
