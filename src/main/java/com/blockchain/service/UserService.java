package com.blockchain.service;

import com.blockchain.dao.UserDao;
import com.blockchain.model.User;
import com.blockchain.requests.RegistrationRequest;
import com.blockchain.responses.ErrorCodes;
import com.blockchain.responses.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

/**
 * Created by Victor on 22.12.2018.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;




    public RegistrationResponse register(RegistrationRequest registrationRequest){

        RegistrationResponse response;

        if(registrationRequest.getEmail()==null
                || registrationRequest.getPassword() == null
                || registrationRequest.getPassword().isEmpty()
                || registrationRequest.getName() == null){
            response = new RegistrationResponse();
            response.setSuccess(false);
            response.setMessage("All field`s of form  must be set");
            response.setCode(ErrorCodes.NOT_FULL_FORM.getCode());
            return response;
        }


        if(userDao.findUserByEmail(registrationRequest.getEmail()) != null) {
            response = new RegistrationResponse();
            response.setCode(ErrorCodes.EMAIL_PRESENT.getCode());
            response.setSuccess(false);
            response.setMessage("User with such email already present in system");
            return  response;
        }

        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setName(registrationRequest.getName());
        userDao.save(user);
        response = new RegistrationResponse();
        response.setId(user.getId());
        response.setSuccess(true);
        response.setCode(200);
        response.setMessage("Successful registration ");

        return response;
    }



}
