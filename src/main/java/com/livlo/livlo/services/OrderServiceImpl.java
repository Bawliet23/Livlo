package com.livlo.livlo.services;

import com.livlo.livlo.entities.Client;
import com.livlo.livlo.entities.Order;
import com.livlo.livlo.entities.Restaurant;
import com.livlo.livlo.models.dto.OrderDTO;
import com.livlo.livlo.reporsitories.IClientRepo;
import com.livlo.livlo.reporsitories.IOrderRepo;
import com.livlo.livlo.reporsitories.IRestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("OrderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepo orderRepo;
    @Autowired
    private IClientRepo clientRepo;


    @Override
    public void makeOrder(Order order) {
        order.setDelivred(false);
        order.getItems().forEach(item->item.setOrder(order));
        if( order.getDefaulAdress() ==null ||order.getDefaulAdress().isEmpty() ){
            Client client = clientRepo.findClientById(order.getClient().getId());
            order.setDefaulAdress(client.getAdress());
        }
       orderRepo.save(order);
    }

    @Override
    public void confirmOrder(Long id) {
        Order order =orderRepo.getOne(id);
        order.setDelivred(true);
        orderRepo.save(order);
    }


    @Override
    public List<OrderDTO> getOrdersByClient(Long id) {
        Client client = clientRepo.findClientById(id);
        return ((List<Order>)orderRepo.findByClient(client)).stream().map(OrderDTO::new).collect(Collectors.toList());
    }


}
