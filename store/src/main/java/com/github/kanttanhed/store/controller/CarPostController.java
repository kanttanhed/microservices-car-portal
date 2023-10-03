package com.github.kanttanhed.store.controller;

import com.github.kanttanhed.store.dto.CarPostRECORD;
import com.github.kanttanhed.store.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostRECORD>>getCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.getCarSales());
    }

    @PutMapping("/cars/{id}")
    public  ResponseEntity changeCarSale(CarPostRECORD carPostRECORD, @PathVariable String id){
        carPostService.changeCarSales(carPostRECORD, Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity changeCarSales(@PathVariable String id){
        carPostService.removeCarSale(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}