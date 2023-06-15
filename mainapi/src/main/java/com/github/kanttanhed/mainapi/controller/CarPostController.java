package com.github.kanttanhed.mainapi.controller;

import com.github.kanttanhed.mainapi.dto.CarPostRecord;
import com.github.kanttanhed.mainapi.message.KakfaProduceMessage;
import com.github.kanttanhed.mainapi.service.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    @Autowired
    private KakfaProduceMessage kakfaProduceMessage;

    @Autowired
    private CarPostStoreService carPostStoreService;

    @GetMapping
    public ResponseEntity<List<CarPostRecord>> getCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales());
    }

    @PostMapping("/post")
    public ResponseEntity postCarSale(@RequestBody CarPostRecord carPostRecord){
        kakfaProduceMessage.sendMessage(carPostRecord);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostRecord carPostRecord, @PathVariable String id){
        carPostStoreService.changeCarForSale(carPostRecord, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarForSales(@PathVariable String id){
        carPostStoreService.removeCarForSale(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}