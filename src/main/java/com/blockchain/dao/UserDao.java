package com.blockchain.dao;


import com.blockchain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Victor on 22.12.2018.
 */
public interface UserDao extends JpaRepository<User, Long> {

    User findUserByEmail(String email);
    User findUserByEmailAndPassword(String email, String password);
}
