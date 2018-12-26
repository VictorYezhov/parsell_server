package com.blockchain.controller;

import com.blockchain.dao.ParcelDao;
import com.blockchain.dao.UserDao;
import com.blockchain.model.Parcel;
import com.blockchain.model.ParcelStates;
import com.blockchain.model.User;
import com.blockchain.requests.LoginRequest;
import com.blockchain.requests.RegistrationRequest;
import com.blockchain.responses.RegistrationResponse;
import com.blockchain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;

/**
 * Created by Victor on 22.12.2018.
 */
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private ParcelDao  parcelDao;

    @Autowired
    private UserDao userDao;



    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest request){
        return new ResponseEntity<>(userService.register(request), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Long> login(@RequestBody LoginRequest loginRequest) {
        User user = userDao.findUserByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(user.getId(), HttpStatus.OK);
        }
    }

    @GetMapping("/getMyParcels")
    public ResponseEntity<List<Parcel>>  getAllMyParcels(@RequestParam("id") String id){


        return new ResponseEntity<>(parcelDao.findAllBySenderId(id).stream().filter(p->p.getStatus().equals(ParcelStates.CREATED.getName())).collect(Collectors.toList()), HttpStatus.OK);

    }

    @GetMapping("/getParcelsForMe")
    public ResponseEntity<List<Parcel>> getParcelsForMe(@RequestParam("id") String id){
        return new ResponseEntity<>(parcelDao.findAllByReceiverId(id), HttpStatus.OK);
    }

    @GetMapping("/getParcelsToDeliver")
    public ResponseEntity<List<Parcel>> getParcelsToDeliver(@RequestParam("id") String id){

        return new ResponseEntity<>(parcelDao.findAllByCourierId(id).stream().filter(p->p.getStatus().equals(ParcelStates.DELIVERED.getName())).collect(Collectors.toList()), HttpStatus.OK);

    }



}
