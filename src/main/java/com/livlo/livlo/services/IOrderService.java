package com.livlo.livlo.services;

import com.livlo.livlo.entities.Order;

import java.util.List;

public interface IOrderService {
    public void makeOrder(Order order);
    public void confirmOrder(Long id);
    public List<Order> getOrdersByClient(Long id);

}
