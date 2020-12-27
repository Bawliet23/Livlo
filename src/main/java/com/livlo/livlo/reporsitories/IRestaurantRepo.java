package com.livlo.livlo.reporsitories;

import com.livlo.livlo.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepo extends JpaRepository<Restaurant,Long> {
}
