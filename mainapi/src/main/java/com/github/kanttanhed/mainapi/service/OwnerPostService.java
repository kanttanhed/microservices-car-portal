package com.github.kanttanhed.mainapi.service;

import com.github.kanttanhed.mainapi.client.CarPostStoreClient;
import com.github.kanttanhed.mainapi.dto.OwnerPostRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostService {
    @Autowired
    private CarPostStoreClient carPostStoreClient;

    public void createOwnerCar(OwnerPostRecord ownerPostRecord){
        carPostStoreClient.ownerPostClient(ownerPostRecord);
    }
}
