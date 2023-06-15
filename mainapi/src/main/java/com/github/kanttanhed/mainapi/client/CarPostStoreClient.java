package com.github.kanttanhed.mainapi.client;

import com.github.kanttanhed.mainapi.dto.CarPostRecord;
import com.github.kanttanhed.mainapi.dto.OwnerPostRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClient {

    private final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";
    private final String POST_STORE_SERVICE_URI = "http://localhost:8080/sales";

    @Autowired
    RestTemplate restTemplate;


    public List<CarPostRecord> carForSaleClient(){
        ResponseEntity<CarPostRecord> responseEntity =
                restTemplate.getForEntity(POST_STORE_SERVICE_URI+"/cars", CarPostRecord.class);

        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void ownerPostClient(OwnerPostRecord ownerPostRecord){
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, ownerPostRecord, OwnerPostRecord.class);
    }

    public void changeCarForSalesClient(OwnerPostRecord ownerPostRecord, String id){
        restTemplate.put(POST_STORE_SERVICE_URI+"/user"+id, OwnerPostRecord.class);
    }

    public void deleteCarForSalesClient(String id){
        restTemplate.delete(POST_STORE_SERVICE_URI+"/user"+id);
    }

}
