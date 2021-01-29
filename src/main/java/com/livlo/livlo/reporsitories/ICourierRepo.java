package com.livlo.livlo.reporsitories;

import com.livlo.livlo.entities.Courier;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ICourierRepo extends JpaRepository<Courier,Long> {
    Optional<Courier> findClientByPhone(String phone);
}
