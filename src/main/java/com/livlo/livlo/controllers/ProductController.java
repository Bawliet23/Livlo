package com.livlo.livlo.controllers;

import com.livlo.livlo.entities.Product;
import com.livlo.livlo.entities.Restaurant;
import com.livlo.livlo.services.IProductService;
import com.livlo.livlo.utils.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("/products")
@PreAuthorize("hasAnyAuthority('CLIENT','COURIER')")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/all")
    List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    @GetMapping("/allRestaurant")
    List<Restaurant> getAllRestaurant(){
        return productService.getAllRestaurant();
    }
    @GetMapping("/restaurant/{id}")
    List<Product> getAllProductInRestaurant(@PathVariable Long id){
        return productService.getProductByRestaurant(id);
    }
}
