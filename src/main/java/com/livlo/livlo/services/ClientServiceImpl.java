package com.livlo.livlo.services;

import com.livlo.livlo.entities.Client;
import com.livlo.livlo.entities.Order;
import com.livlo.livlo.reporsitories.IClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ClientService")
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepo clientRepo;
    @Override
    public Client addClient(Client client) {
        boolean userExist = clientRepo.existsClientByPhone(client.getPhone());
        if (!userExist){
          return clientRepo.save(client);
        }
        return null;
    }


    @Override
    public Client findUser(Long id) {
        return clientRepo.findClientById(id);
    }
}
