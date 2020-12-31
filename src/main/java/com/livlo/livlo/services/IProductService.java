package com.livlo.livlo.services;

import com.livlo.livlo.entities.Product;
import com.livlo.livlo.entities.Restaurant;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();
    List<Product> getProductByRestaurant(Long id);
    List<Restaurant> getAllRestaurant();
}
