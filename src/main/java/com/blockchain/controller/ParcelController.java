package com.blockchain.controller;

import com.blockchain.requests.ParcelCreation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Victor on 22.12.2018.
 */
@RestController
public class ParcelController {





    @PostMapping("/newParcelCreation")
    public ResponseEntity<?> createNewParcel(@RequestBody ParcelCreation creation){

        System.out.println("Creating parcel: "+ creation.toString());

        //TODO write this to  blockchain
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



    @PostMapping("/")
    public ResponseEntity<List<?>> getAllParcels(){
        System.out.println("Getting all parcels");
        return null;
    }

}
