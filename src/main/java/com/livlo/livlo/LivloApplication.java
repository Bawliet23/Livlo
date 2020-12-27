package com.livlo.livlo;

import com.livlo.livlo.entities.*;
import com.livlo.livlo.reporsitories.IClientRepo;
import com.livlo.livlo.reporsitories.ICourierRepo;
import com.livlo.livlo.reporsitories.IProductRepo;
import com.livlo.livlo.reporsitories.IRestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LivloApplication implements CommandLineRunner {
//    @Autowired
//    private ICourierRepo repo;
//    @Autowired
//    private IRestaurantRepo restaurantRepo;
//    @Autowired
//    private IProductRepo productRepo;
    public static void main(String[] args) {
        SpringApplication.run(LivloApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        repo.save(new Courier("mohamed","0644970548"));
//       Product p =new Product(null,"tacos","wfwff",15.2d,"ftftf4fdf",null,null);
//        List list =new ArrayList<Product>();
//
//       Restaurant r =new Restaurant(1L,"MC","yyggy",null);
//        p.setRestaurant(r);
//        productRepo.save(p);
//        list.add(p);
//        r.setProducts(list);
//        restaurantRepo.save(r);
    }


}
