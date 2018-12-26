package com.blockchain.controller;

import com.blockchain.blockchain.ParcelService;
import com.blockchain.dao.ParcelDao;
import com.blockchain.dao.UserDao;
import com.blockchain.model.Parcel;
import com.blockchain.model.User;
import com.blockchain.requests.ParcelCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Victor on 22.12.2018.
 */
@RestController
public class ParcelController {


    @Autowired
    private ParcelDao parcelDao;

    @Autowired
    private ParcelService parcelService;

    @Autowired
    private UserDao userDao;



    @PostMapping("/newParcelCreation")
    public ResponseEntity<?> createNewParcel(@RequestBody ParcelCreation creation){

        System.out.println("Creating parcel: "+ creation.toString());
        Parcel parcel = new Parcel();
        parcel.setSenderId(creation.getFromId().toString());
        User user = userDao.findUserByEmail(creation.getEmail());

        parcel.setReceiverId(user.getId().toString());
        parcel.setDescription(creation.getDescription());
        parcel.setAddressFrom(creation.getFrom().toString());
        parcel.setAddressTo(creation.getAddressTo().toString());
        parcel.setPrice((long) (creation.getPrice()));
        parcel.setStatus("Created");
        parcelDao.save(parcel);
        parcelService.createParcel(parcel).sendAsync().thenApply(t->{
            System.out.println(parcel.toString());
            System.out.println("Sended new parcel to chain, hash:"+ t.getBlockHash());
            return t;
        });

        return null;
    }


    @PostMapping("/becomeCourier")
    public ResponseEntity<?> becomeCourier(@RequestParam("parcelId") Long id,@RequestParam("userId") Long userId ){
        System.out.println("Becoming courier for parcel with id "+ id+" user id: "+ userId);
        //TODO update parcel state
        return null;
    }


    @PostMapping("/deliverOrder")
    public ResponseEntity<?> deliverOrder(@RequestParam("parcelId")Long parcelId){

        System.out.println("Delivering parcel: "+ parcelId);
        //TODO update parcel state
        return null;
    }



    @GetMapping("/parcels")
    public ResponseEntity<List<?>> getAllParcels(){
        System.out.println("Getting all parcels");
        return null;
    }

}
