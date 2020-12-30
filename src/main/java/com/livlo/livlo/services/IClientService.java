package com.livlo.livlo.services;

import com.livlo.livlo.entities.Client;
import com.livlo.livlo.entities.Order;

public interface IClientService {
    public Client addClient(Client client);
public Client findUser(Long id);
Client addLocation(Client client);
}
