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
    public Client addLocation(Client client) {
        Client client1 =findUser(client.getId());
        client1.setAdress(client.getAdress());
        client1.setLatitude(client.getLatitude());
        client1.setLonguitude(client.getLonguitude());
       return clientRepo.save(client1);

    }

    @Override
    public Client findUser(Long id) {
        return clientRepo.findClientById(id);
    }
}
