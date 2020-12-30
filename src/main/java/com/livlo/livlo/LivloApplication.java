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
public class LivloApplication{

    public static void main(String[] args) {
        SpringApplication.run(LivloApplication.class, args);
    }

}
