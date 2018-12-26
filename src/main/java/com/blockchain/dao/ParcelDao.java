package com.blockchain.dao;

import com.blockchain.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Victor on 26.12.2018.
 */
public interface ParcelDao extends JpaRepository<Parcel, Long> {

}
