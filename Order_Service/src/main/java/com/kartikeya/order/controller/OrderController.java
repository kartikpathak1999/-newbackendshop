package com.kartikeya.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartikeya.order.entity.Order;
import com.kartikeya.order.exception.NoProperDataException;
import com.kartikeya.order.exception.OrderNotFoundException;
import com.kartikeya.order.service.OrderServiceImpl;
import com.kartikeya.order.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v2")
public class OrderController {
	@Autowired
	private OrderServiceImpl orderServiceimpl;

	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/allOrders")
	public ResponseEntity<List<Order>> getAllProduct() throws OrderNotFoundException
	{
		
		List<Order> customers=orderServiceimpl.getAllOrders();  
		log.info("starting  of get mapping");
	
		if(customers.size()>0) {
			log.debug("customers are {}"
					+ customers);
		 return new  ResponseEntity<>(customers,HttpStatus.OK); 
		}
		else {
			log.debug(" no customers found ");
			 return new  ResponseEntity<>(customers,HttpStatus.NO_CONTENT); 
		}
	}
	
	
	
@GetMapping("orders/{id}")
public ResponseEntity<Order> getOrderById(@PathVariable  int id) throws OrderNotFoundException {
	Order orders= orderServiceimpl.getOrderById(id);
	if(orders!=null){
	  return ResponseEntity.ok().body(orders);
	}
	  else {
		return new  ResponseEntity(orders,HttpStatus.NOT_FOUND);
	  }

}

	
	@PostMapping("/addOrders") 
	public ResponseEntity<Order> addOrders(@RequestBody Order odto) throws NoProperDataException {

		if(odto!=null) 
		{
			
			odto.setBookingOrderId(service.getSequenceNumberForOrders(Order.SEQUENCE_NAME));
			orderServiceimpl.addOrders(odto);
			log.error("added oders");
			return new ResponseEntity<>(odto,HttpStatus.CREATED);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
			
		}
		
	}
		

	

	@DeleteMapping(path="/orders/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable int id) throws OrderNotFoundException {
		int count=1;
		for(int i=1;i>=count;count++)
		{
			if(count==1)
			{
			try {
				orderServiceimpl.deleteOrder(id);
			} catch (OrderNotFoundException e) {
				log.error(e.getMessage());
			}
			}
			else
			{
				log.info("id not found");
			}
		}
			return ResponseEntity.ok(" deleted operation done ");
	
	}

}

