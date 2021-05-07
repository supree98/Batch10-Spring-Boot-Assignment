package com.te.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.bean.AmazonResponse;
import com.te.springboot.bean.Item;
import com.te.springboot.service.AmazonService;

@RestController
public class AmazonRestController {

	@Autowired
	private AmazonService service;
	
	@GetMapping(path = "/getItem/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public AmazonResponse getItem(@PathVariable(name = "id") Integer id) {
		AmazonResponse response = new AmazonResponse();
		Item item = service.searchItem(id);
		if(item != null) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setItem(item);
		} else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}
		return response;
	}
	
	@GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public AmazonResponse getAllItems() {
		AmazonResponse response = new AmazonResponse();
		List<Item> items = service.getAllItems();
		if(items != null) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setItemList(items);
		} else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}
		return response;
	}
	
	@PostMapping(path = "/addItem", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public AmazonResponse addItem(@RequestBody Item item) {
		AmazonResponse response = new AmazonResponse();
		if(service.addItem(item)) {
			response.setStatusCode(200);
			response.setMessage("success");
		} else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}
		return response;
	}
	
	@PutMapping(path = "/updateItem", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public AmazonResponse updateItem(@RequestBody Item item) {
		AmazonResponse response = new AmazonResponse();
		if(service.updateItem(item)) {
			response.setStatusCode(200);
			response.setMessage("failed");
		} else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}
		return response;
	}
	
	@DeleteMapping(path = "/deleteItem/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public AmazonResponse deleteItem(@PathVariable(name ="id") Integer id) {
		AmazonResponse response = new AmazonResponse();
		if(service.removeItem(id)) {
			response.setStatusCode(200);
			response.setMessage("success");
		} else {
			System.out.println("Inside else bock in handler");
		}
		return response;
	}

}
