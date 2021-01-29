package com.livlo.livlo.reporsitories;

import com.livlo.livlo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
public interface IClientRepo extends JpaRepository<Client,Long> {
    Optional<Client> findClientByPhone(String phone);
    boolean existsClientByPhone(String phone);
    Client findClientById(Long id);
    
}
