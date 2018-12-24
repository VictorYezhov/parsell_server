package com.blockchain.controller;

import com.blockchain.dao.UserDao;
import com.blockchain.model.User;
import com.blockchain.requests.LoginRequest;
import com.blockchain.requests.RegistrationRequest;
import com.blockchain.responses.RegistrationResponse;
import com.blockchain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Victor on 22.12.2018.
 */
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;



    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest request){
        return new ResponseEntity<>(userService.register(request), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        User user = userDao.findUserByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (user == null) {
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("{ \"id\":" + "\"" + user.getId() + "\"}", HttpStatus.OK);
        }
    }



}
