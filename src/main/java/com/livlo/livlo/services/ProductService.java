package com.livlo.livlo.services;

import com.livlo.livlo.entities.Product;
import com.livlo.livlo.entities.Restaurant;
import com.livlo.livlo.reporsitories.IProductRepo;
import com.livlo.livlo.reporsitories.IRestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements  IProductService {
    @Autowired
    private IProductRepo productRepo;
    @Autowired
    private IRestaurantRepo restaurantRepo;
    @Override
    public List<Product> getAllProduct() {

        return productRepo.findAll();
    }
    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepo.findAll();
    }
    @Override
    public List<Product> getProductByRestaurant(Long id){
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if (restaurant.isEmpty()){
            return null;
        }
        return productRepo.findAllByRestaurant(restaurant.get());
    }
}
