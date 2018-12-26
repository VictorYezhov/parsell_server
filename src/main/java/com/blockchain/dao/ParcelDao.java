package com.blockchain.dao;

import com.blockchain.model.Parcel;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Victor on 26.12.2018.
 */
public interface ParcelDao extends JpaRepository<Parcel, Long> {

    List<Parcel> findAllBySenderId(String senderId);
    List<Parcel> findAllByReceiverId(String receiverId);
    List<Parcel> findAllByCourierId(String courierId);
}
