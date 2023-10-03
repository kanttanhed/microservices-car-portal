package com.github.kanttanhed.store.dto;

public record CarPostRECORD(
    String model,
    String brand,
    Double price,
    String description,
    String engineVersion,
    String city,
    String createdDate,
    Long ownerId,
    String ownerName,
    String ownerType,
    String contact
    ){
}