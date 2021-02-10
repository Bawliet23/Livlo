package com.livlo.livlo.controllers;

import com.livlo.livlo.entities.Client;
import com.livlo.livlo.entities.Order;
import com.livlo.livlo.models.dto.OrderDTO;
import com.livlo.livlo.reporsitories.IClientRepo;
import com.livlo.livlo.security.models.JwtResponse;
import com.livlo.livlo.security.models.MyClientDetails;
import com.livlo.livlo.security.models.MyCourierDetails;
import com.livlo.livlo.security.models.User;
import com.livlo.livlo.security.tokens.SmsCodeAuthenticationToken;
import com.livlo.livlo.services.IClientService;
import com.livlo.livlo.services.IOrderService;
import com.livlo.livlo.services.OrderServiceImpl;
import com.livlo.livlo.utils.JwtUtils;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
@PreAuthorize("hasAuthority('CLIENT')")
public class ClientController {
    @Autowired
    private IClientService clientService;
    @Autowired
    private IOrderService orderService;


    @PostMapping(path = "/makeOrder",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void makeOrder(@RequestBody Order order){
        orderService.makeOrder(order);
    }

    @PutMapping("/confirmOrder/{id}")
    public void confirmOrder(@PathVariable("id") Long id){
        orderService.confirmOrder(id);
    }
    @GetMapping("/{id}/orders")
    public List<OrderDTO> getMyOrders(@PathVariable("id") Long id){
        return orderService.getOrdersByClient(id);
    }
     @GetMapping("/{id}")
    public Client getUser(@PathVariable("id") Long id){
        return clientService.findUser(id);
    }


    @PutMapping("/addLocation/{id}")
    public Client addLocation(@RequestBody Client client,@PathVariable("id") Long id){
        client.setId(id);
        return clientService.addLocation(client);
    }


}
