package com.kartikeya.order.service;
import java.util.List;

import com.kartikeya.order.entity.Order;
import com.kartikeya.order.exception.NoProperDataException;
import com.kartikeya.order.exception.OrderNotFoundException;


public interface OrderService {
	public  List<Order> getAllOrders() throws  OrderNotFoundException;
	public Order getOrderById( int id) throws OrderNotFoundException;
	public Order addOrders( Order order)  throws NoProperDataException;
	public String deleteOrder( int id) throws OrderNotFoundException;
}
