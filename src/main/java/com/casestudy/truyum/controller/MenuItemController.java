package com.casestudy.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.truyum.model.MenuItem;
import com.casestudy.truyum.service.MenuItemService;
import com.casestudy.truyum.service.MenuItemServiceImpl;



@RequestMapping("/menu-items")
@RestController
public class MenuItemController {

	@Autowired
	MenuItemService menuService;

	/**
	 * Retrieves list of menu items.
	 * @return the ResponseEntity containing the found menu item and a 200 OK response
	 */
	@GetMapping
	public ResponseEntity<List> getMenuItemListCustomer(){
		
		List<MenuItem> menuList = menuService.getMenuItemListCustomer();
		
		return new ResponseEntity<List>(menuList,HttpStatus.OK);
		
	}
	
	/**
	 * Retrieves a menu item.
	 * @param itemId - PK used to retrieve menu item
	 * @return the ResponseEntity containing the found menu item and a 200 OK response
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?>  getMenuItem(@PathVariable("id")  long itemId ) {
		
	     MenuItem item = menuService.getMenuItem(itemId);
		
		return new ResponseEntity<MenuItem>(item,HttpStatus.OK);
	}
	
	
    /**
     * Modifies a menu item.
     * have not tested
     * @param menuItem the menu item to be updated
     * @return the ResponseEntity containing the modified menu item and a 200 OK response
     */
	@PutMapping
	public ResponseEntity<?> modifyMenuIitem(@RequestBody MenuItem menuItem ){
			
		MenuItem item =	menuService.modifyMenuItem(menuItem);
				
		return new ResponseEntity<MenuItem>(item,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
