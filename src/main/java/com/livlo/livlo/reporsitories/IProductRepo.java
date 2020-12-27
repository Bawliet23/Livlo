package com.livlo.livlo.reporsitories;

import com.livlo.livlo.entities.Product;
import com.livlo.livlo.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepo extends JpaRepository<Product,Long> {

    List<Product> findAllByRestaurant(Restaurant restaurant);
}
