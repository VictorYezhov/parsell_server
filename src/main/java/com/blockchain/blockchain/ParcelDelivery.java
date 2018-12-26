package com.blockchain.blockchain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class ParcelDelivery extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a03191633179055610f8f806100326000396000f3fe608060405234801561001057600080fd5b506004361061007e577c010000000000000000000000000000000000000000000000000000000060003504631b58b30781146100835780633211131c146102dc578063428c2c9d1461038957806348f6808b146103a35780634d0434f2146103d457806357c2ae6d146105b7575b600080fd5b6102da600480360361010081101561009a57600080fd5b813591602081013591604082013591908101906080810160608201356401000000008111156100c857600080fd5b8201836020820111156100da57600080fd5b803590602001918460018302840111640100000000831117156100fc57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929594936020810193503591505064010000000081111561014f57600080fd5b82018360208201111561016157600080fd5b8035906020019184600183028401116401000000008311171561018357600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929584359590949093506040810192506020013590506401000000008111156101de57600080fd5b8201836020820111156101f057600080fd5b8035906020019184600183028401116401000000008311171561021257600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929594936020810193503591505064010000000081111561026557600080fd5b82018360208201111561027757600080fd5b8035906020019184600183028401116401000000008311171561029957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610801945050505050565b005b6102da600480360360408110156102f257600080fd5b8135919081019060408101602082013564010000000081111561031457600080fd5b82018360208201111561032657600080fd5b8035906020019184600183028401116401000000008311171561034857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610933945050505050565b6103916109d3565b60408051918252519081900360200190f35b6103c0600480360360208110156103b957600080fd5b50356109da565b604080519115158252519081900360200190f35b6103f1600480360360208110156103ea57600080fd5b50356109f2565b604051808981526020018881526020018781526020018060200180602001868152602001806020018060200185810385528a818151815260200191508051906020019080838360005b8381101561045257818101518382015260200161043a565b50505050905090810190601f16801561047f5780820380516001836020036101000a031916815260200191505b5085810384528951815289516020918201918b019080838360005b838110156104b257818101518382015260200161049a565b50505050905090810190601f1680156104df5780820380516001836020036101000a031916815260200191505b50858103835287518152875160209182019189019080838360005b838110156105125781810151838201526020016104fa565b50505050905090810190601f16801561053f5780820380516001836020036101000a031916815260200191505b50858103825286518152865160209182019188019080838360005b8381101561057257818101518382015260200161055a565b50505050905090810190601f16801561059f5780820380516001836020036101000a031916815260200191505b509c5050505050505050505050505060405180910390f35b6102da600480360360c08110156105cd57600080fd5b813591908101906040810160208201356401000000008111156105ef57600080fd5b82018360208201111561060157600080fd5b8035906020019184600183028401116401000000008311171561062357600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929594936020810193503591505064010000000081111561067657600080fd5b82018360208201111561068857600080fd5b803590602001918460018302840111640100000000831117156106aa57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295843595909490935060408101925060200135905064010000000081111561070557600080fd5b82018360208201111561071757600080fd5b8035906020019184600183028401116401000000008311171561073957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929594936020810193503591505064010000000081111561078c57600080fd5b82018360208201111561079e57600080fd5b803590602001918460018302840111640100000000831117156107c057600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610d66945050505050565b6001805481018155604080516101008101825289815260208082018a81528284018a8152606084018a90526080840189905260a0840188905260c0840187905260e0840186905260008e81526002808552959020845181559151958201959095559351805192949361087b93908501929190910190610e83565b5060608201518051610897916003840191602090910190610e83565b506080820151600482015560a082015180516108bd916005840191602090910190610e83565b5060c082015180516108d9916006840191602090910190610e83565b5060e091909101516007909101805460ff19169115159190911790556040805189815290517fdcb62f3769c6478a9f14aaa3c1a7ca74a20f61cc3bce4a8971f2693a72bd69ef916020908290030190a15050505050505050565b61093c826109da565b15156109a957604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601160248201527f50617263656c206d757374206578697374000000000000000000000000000000604482015290519081900360640190fd5b600082815260026020908152604090912082516109ce92600590920191840190610e83565b505050565b6001545b90565b60009081526002602052604090206007015460ff1690565b60008060006060806000606080610a08896109da565b1515610a7557604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601160248201527f50617263656c206d757374206578697374000000000000000000000000000000604482015290519081900360640190fd5b610a7d610f01565b60008a81526002602081815260409283902083516101008082018652825482526001808401548386015283860180548851928116159093026000190190921695909504601f810185900485028601850187528086529195929492860193909190830182828015610b2e5780601f10610b0357610100808354040283529160200191610b2e565b820191906000526020600020905b815481529060010190602001808311610b1157829003601f168201915b505050918352505060038201805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152938201939291830182828015610bc25780601f10610b9757610100808354040283529160200191610bc2565b820191906000526020600020905b815481529060010190602001808311610ba557829003601f168201915b5050509183525050600482015460208083019190915260058301805460408051601f60026000196101006001871615020190941693909304928301859004850281018501825282815294019392830182828015610c605780601f10610c3557610100808354040283529160200191610c60565b820191906000526020600020905b815481529060010190602001808311610c4357829003601f168201915b505050918352505060068201805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152938201939291830182828015610cf45780601f10610cc957610100808354040283529160200191610cf4565b820191906000526020600020905b815481529060010190602001808311610cd757829003601f168201915b505050505081526020016007820160009054906101000a900460ff161515151581525050905089816000015182602001518360400151846060015185608001518660a001518760c001518494508393508191508090509850985098509850985098509850985050919395975091939597565b610d6f866109da565b1515610ddc57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601160248201527f50617263656c206d757374206578697374000000000000000000000000000000604482015290519081900360640190fd5b60008681526002602090815260409091208351610e0192600590920191850190610e83565b5060008681526002602081815260409092208751610e2793919092019190880190610e83565b5060008681526002602090815260409091208551610e4d92600390920191870190610e83565b506000868152600260209081526040909120600481018590558251610e7a92600690920191840190610e83565b50505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610ec457805160ff1916838001178555610ef1565b82800160010185558215610ef1579182015b82811115610ef1578251825591602001919060010190610ed6565b50610efd929150610f49565b5090565b61010060405190810160405280600081526020016000815260200160608152602001606081526020016000815260200160608152602001606081526020016000151581525090565b6109d791905b80821115610efd5760008155600101610f4f56fea165627a7a72305820bbdf99b8388448d589337438839763ac1e4c48759eefce9fa148f17cd8cccbfa0029";

    public static final String FUNC_CREATEPARCEL = "createParcel";

    public static final String FUNC_CHANGEPARCELSTATE = "changeParcelState";

    public static final String FUNC_GETNUMOFPARCELS = "getNumOfParcels";

    public static final String FUNC_ISPARCEL = "isParcel";

    public static final String FUNC_GETPARCEL = "getParcel";

    public static final String FUNC_EDITPARCEL = "editParcel";

    public static final Event PARCELCREATED_EVENT = new Event("ParcelCreated", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    protected ParcelDelivery(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ParcelDelivery(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> createParcel(BigInteger id_, BigInteger user_id_, BigInteger reciver_user_id_, String to_, String from_, BigInteger price_, String status_, String description_) {
        final Function function = new Function(
                FUNC_CREATEPARCEL, 
                Arrays.<Type>asList(new Uint256(id_),
                new Uint256(user_id_),
                new Uint256(reciver_user_id_),
                new Utf8String(to_),
                new Utf8String(from_),
                new Uint256(price_),
                new Utf8String(status_),
                new Utf8String(description_)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> changeParcelState(BigInteger parcel_id, String status_) {
        final Function function = new Function(
                FUNC_CHANGEPARCELSTATE, 
                Arrays.<Type>asList(new Uint256(parcel_id),
                new Utf8String(status_)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getNumOfParcels() {
        final Function function = new Function(FUNC_GETNUMOFPARCELS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> isParcel(BigInteger parcel_id) {
        final Function function = new Function(FUNC_ISPARCEL, 
                Arrays.<Type>asList(new Uint256(parcel_id)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Tuple8<BigInteger, BigInteger, BigInteger, String, String, BigInteger, String, String>> getParcel(BigInteger parcel_id) {
        final Function function = new Function(FUNC_GETPARCEL, 
                Arrays.<Type>asList(new Uint256(parcel_id)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple8<BigInteger, BigInteger, BigInteger, String, String, BigInteger, String, String>>(
                new Callable<Tuple8<BigInteger, BigInteger, BigInteger, String, String, BigInteger, String, String>>() {
                    @Override
                    public Tuple8<BigInteger, BigInteger, BigInteger, String, String, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, BigInteger, BigInteger, String, String, BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (String) results.get(7).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> editParcel(BigInteger parcel_id, String to_, String from_, BigInteger price_, String status_, String description_) {
        final Function function = new Function(
                FUNC_EDITPARCEL, 
                Arrays.<Type>asList(new Uint256(parcel_id),
                new Utf8String(to_),
                new Utf8String(from_),
                new Uint256(price_),
                new Utf8String(status_),
                new Utf8String(description_)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<ParcelDelivery> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ParcelDelivery.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ParcelDelivery> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ParcelDelivery.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public List<ParcelCreatedEventResponse> getParcelCreatedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(PARCELCREATED_EVENT, transactionReceipt);
        ArrayList<ParcelCreatedEventResponse> responses = new ArrayList<ParcelCreatedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ParcelCreatedEventResponse typedResponse = new ParcelCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.parcel_id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ParcelCreatedEventResponse> parcelCreatedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ParcelCreatedEventResponse>() {
            @Override
            public ParcelCreatedEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(PARCELCREATED_EVENT, log);
                ParcelCreatedEventResponse typedResponse = new ParcelCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.parcel_id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ParcelCreatedEventResponse> parcelCreatedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PARCELCREATED_EVENT));
        return parcelCreatedEventObservable(filter);
    }

    public static ParcelDelivery load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ParcelDelivery(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ParcelDelivery load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ParcelDelivery(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class ParcelCreatedEventResponse {
        public Log log;

        public BigInteger parcel_id;
    }
}
