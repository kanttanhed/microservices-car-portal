package com.github.kanttanhed.mainapi.controller;

import com.github.kanttanhed.mainapi.dto.CarPostRecord;
import com.github.kanttanhed.mainapi.message.KakfaProduceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    @Autowired
    private KakfaProduceMessage kakfaProduceMessage;

    @PostMapping
    public ResponseEntity postCarSale(@RequestBody CarPostRecord carPostRecord){
        kakfaProduceMessage.sendMessage(carPostRecord);

        return new ResponseEntity(HttpStatus.OK);
    }
}