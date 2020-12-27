package com.livlo.livlo.services;


import com.livlo.livlo.entities.Client;
import com.livlo.livlo.entities.Courier;
import com.livlo.livlo.reporsitories.IClientRepo;
import com.livlo.livlo.reporsitories.ICourierRepo;
import com.livlo.livlo.security.models.MyClientDetails;
import com.livlo.livlo.security.models.MyCourierDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailServise implements UserDetailsService {

    @Autowired
    private IClientRepo clientRepo;
    @Autowired
    private ICourierRepo courierRepo;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Client> user = clientRepo.findClientByPhone(s);
        System.out.println(s);

        if (user.isEmpty()) {
            Optional<Courier> courier = courierRepo.findClientByPhone(s);
            if (courier.isEmpty()) {
                throw new UsernameNotFoundException("Could not find user");
            }
            return new MyCourierDetails(courier.get());
        }

        return new MyClientDetails(user.get());
    }
}
