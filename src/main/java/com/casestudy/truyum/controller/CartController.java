package com.casestudy.truyum.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.truyum.model.Cart;
import com.casestudy.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	// CartService
	@Autowired
	CartService cartService;

	@PostMapping
	public ResponseEntity<?> addCartItem(@RequestBody Map<String, Object> requestBody) {

		String userName = (String) requestBody.get("userName");
		List<Integer> purchaseItem = (List<Integer>) requestBody.get("purchaseItem");

		List<Long> purchaseItemList = purchaseItem.stream().map(Long::valueOf).collect(Collectors.toList());

		cartService.addCartItem(userName, purchaseItemList);

		return new ResponseEntity<String>("Working fine", HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getAllCartItems(@PathVariable("userId") String userName) {
		List<Cart> userCart = cartService.getAllCartItems(userName);
		return new ResponseEntity<List<Cart>>(userCart, HttpStatus.OK);
	}

	

	@DeleteMapping("/{userName}/{cartId}")
	public ResponseEntity<?> deleteCartItem(@PathVariable("userName") String userName,
			@PathVariable("cartId") int cartId) {
		boolean status = cartService.deleteCart(userName, cartId);
		if (status) {
			return new ResponseEntity<String>("Cart has been deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Cart does not exist", HttpStatus.NOT_FOUND);

	}

}
