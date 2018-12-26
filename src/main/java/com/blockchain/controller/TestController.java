package com.blockchain.controller;

import com.blockchain.blockchain.BlockChainConnector;
import com.blockchain.model.Parcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Victor on 25.12.2018.
 */
@RestController
public class TestController {

    @Autowired
    private BlockChainConnector blockChainConnector;


    @GetMapping("/test")
    public ResponseEntity<?> test() throws Exception {

        Parcel parcel = new Parcel();
        parcel.setId(1L);
        parcel.setDescription("Fist test Parcel");
        parcel.setStatus("OK");
        System.out.println(blockChainConnector.getNumberOfPercels());
        System.out.println(blockChainConnector.createParcel(parcel).sendAsync().thenApply(t->{
            System.out.println(t.getBlockHash());
            return t;
        }));

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/isValid")
    public Boolean isValid() throws IOException {
        return blockChainConnector.isValid();
    }

}
