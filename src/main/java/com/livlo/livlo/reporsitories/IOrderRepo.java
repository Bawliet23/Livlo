package com.livlo.livlo.reporsitories;

import com.livlo.livlo.entities.Client;
import com.livlo.livlo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepo extends JpaRepository<Order,Long> { @Override
List<Order> findAll();
List<Order> findByClient(Client client);

}
