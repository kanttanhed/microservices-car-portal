package com.github.kanttanhed.mainapi.controller;

import com.github.kanttanhed.mainapi.dto.OwnerPostRecord;
import com.github.kanttanhed.mainapi.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity createOwnerCar(@RequestBody OwnerPostRecord ownerPostRecord){
        ownerPostService.createOwnerCar(ownerPostRecord);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
