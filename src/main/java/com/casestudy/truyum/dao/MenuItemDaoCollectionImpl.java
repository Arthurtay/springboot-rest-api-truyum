package com.casestudy.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.casestudy.truyum.model.MenuItem;
import com.casestudy.truyum.repository.MenuItemRepository;
import com.casestudy.truyum.util.DateUtil;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList;

	@Autowired
	MenuItemRepository itemRepo;

	public MenuItemDaoCollectionImpl() {
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		
		return menuItemList;
		
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {

		return itemRepo.findAll();

	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		itemRepo.save(menuItem);

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {

		Optional<MenuItem> item = itemRepo.findById(menuItemId);
		if (item.isPresent()) {
			MenuItem menuItem = item.get();
			return menuItem;
		}

		return null;

	}

}
