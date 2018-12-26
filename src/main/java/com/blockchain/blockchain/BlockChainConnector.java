package com.blockchain.blockchain;

import com.blockchain.model.Parcel;
import jdk.nashorn.internal.ir.Block;
import org.hibernate.TransactionException;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Victor on 25.12.2018.
 */
@Service
public class BlockChainConnector  implements ParcelService {


    private ParcelDelivery contract;

    public BlockChainConnector() throws Exception{
        Web3j web3j = Web3j.build(new HttpService("https://rinkeby.infura.io/v3/ab32e714dc9f411193cb73ad829dc79c"));

        Credentials credentials = Credentials.create("b8b4c7fd07951471d9e31b725e67f123f83cdc732835408f8855bde62ba23ad6");
//                WalletUtils.loadCredentials(
//                        "bomberman1390bombom",
//                        "UTC--2018-12-25T21-10-42.681454300Z--1f5f881758fc8d78830ba9cec03775077a7a67b2");
        System.out.println("Credentials loaded");



        // Now lets deploy a smart contract
        System.out.println("Deploying smart contract");
        contract = ParcelDelivery.load("0x108378c69dB7205b1A966b156A540727464602bD", web3j, credentials,
                ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
        String contractAddress = contract.getContractAddress();



            EthGetCode ethGetCode = web3j.ethGetCode("0x108378c69dB7205b1A966b156A540727464602bD", DefaultBlockParameterName.LATEST).send();
            if(ethGetCode.hasError()) {
                System.out.println("eth has Error");
            } else {
                String code = ethGetCode.getCode();
                System.out.println("CODE :"+ code );
            }




        System.out.println("Smart contract deployed to address " + contractAddress);
        System.out.println("isContractValid=" + contract.isValid());

    }

    @Override
    public RemoteCall<TransactionReceipt> createParcel(Parcel parcel) {

        System.out.println(parcel.toString());
        return  contract.createParcel(BigInteger.valueOf(parcel.getId()),
                BigInteger.valueOf(Long.decode(parcel.getSenderId())),
                BigInteger.valueOf(Long.decode(parcel.getReceiverId())),
                parcel.getAddressTo(),
                parcel.getAddressFrom(),
                BigInteger.valueOf((long)parcel.getPrice()), "CREATED", parcel.getDescription()) ;
    }

    @Override
    public List<Parcel> getParcels() {
        return null;
    }

    @Override
    public RemoteCall<TransactionReceipt> editParcel(Parcel parcel) {

        return null;
    }

    @Override
    public BigInteger getNumberOfPercels() throws Exception {
        return contract.getNumOfParcels().send();
    }

    @Override
    public Boolean isValid() throws IOException {
        return contract.isValid();
    }
}
