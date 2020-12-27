package com.livlo.livlo.services;

import com.livlo.livlo.entities.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();
    List<Product> getProductByRestaurant(Long id);
}
