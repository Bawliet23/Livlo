package com.livlo.livlo.controllers;

import com.livlo.livlo.entities.Client;
import com.livlo.livlo.security.models.JwtResponse;
import com.livlo.livlo.security.models.MyClientDetails;
import com.livlo.livlo.security.models.MyCourierDetails;
import com.livlo.livlo.security.models.User;
import com.livlo.livlo.security.tokens.SmsCodeAuthenticationToken;
import com.livlo.livlo.services.IClientService;
import com.livlo.livlo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController{

    @Autowired
    private IClientService clientService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/signUp")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }



    @PostMapping("/signIn")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody User user) throws ClassNotFoundException {

        Authentication authentication = authenticationManager.authenticate(
                new SmsCodeAuthenticationToken(user.getPhone()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        List<String> roles = authentication.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        if (authentication.getPrincipal().getClass().getName().contains("MyClientDetails")){
            MyClientDetails userDetails = (MyClientDetails) authentication.getPrincipal();
            return ResponseEntity.ok(new JwtResponse(jwt,new User(userDetails.getUser().getId(),userDetails.getUser().getName(),userDetails.getUser().getPhone(),userDetails.getUser().getAdress(),userDetails.getUser().getLonguitude(),userDetails.getUser().getLatitude(),userDetails.getUser().getBirthday(),userDetails.getUser().getWarning(),userDetails.getUser().getStatus()),roles));
        }else if (authentication.getPrincipal().getClass().getName().contains("MyCourierDetails")){
            MyCourierDetails userDetails = (MyCourierDetails) authentication.getPrincipal();
            return ResponseEntity.ok(new JwtResponse(jwt,new User(userDetails.getUser().getId(),userDetails.getUser().getName(),userDetails.getUser().getPhone(),userDetails.getUser().getAdress(),userDetails.getUser().getLonguitude(),userDetails.getUser().getLatitude(),userDetails.getUser().getBirthday(),userDetails.getUser().getWarning(),userDetails.getUser().getStatus()),roles));
        }

        return null;
    }
}
