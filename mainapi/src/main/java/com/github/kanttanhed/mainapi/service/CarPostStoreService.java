package com.github.kanttanhed.mainapi.service;

import com.github.kanttanhed.mainapi.client.CarPostStoreClient;
import com.github.kanttanhed.mainapi.dto.CarPostRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    public List<CarPostRecord> getCarForSales(){
        return carPostStoreClient.carForSaleClient();
    }

    public void changeCarForSale(CarPostRecord carPostRecord, String id){
        carPostStoreClient.changeCarForSaleClient(carPostRecord, id);
    }

    public void removeCarForSale(String id){
        carPostStoreClient.deleteCarForSalesClient(id);
    }


}
