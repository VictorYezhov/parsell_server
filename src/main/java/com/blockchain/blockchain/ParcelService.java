package com.blockchain.blockchain;

import com.blockchain.model.Parcel;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Victor on 25.12.2018.
 */
public interface ParcelService {
    RemoteCall<TransactionReceipt> createParcel(Parcel parcel);
    List<Parcel> getParcels();
    RemoteCall<TransactionReceipt> editParcel(Parcel parcel);
    BigInteger getNumberOfPercels() throws Exception;

    Boolean isValid() throws IOException;


}
