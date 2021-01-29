package com.livlo.livlo.services;

import com.livlo.livlo.entities.Order;
import com.livlo.livlo.entities.Restaurant;
import com.livlo.livlo.models.dto.OrderDTO;

import java.util.List;

public interface IOrderService {
    public void makeOrder(Order order);
    public void confirmOrder(Long id);
    public List<OrderDTO> getOrdersByClient(Long id);


}
