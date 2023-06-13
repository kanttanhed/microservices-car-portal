package com.github.kanttanhed.mainapi.dto;

public record CarPostRecord(
        String model,
        String brand ,
        String price ,
        String description,
        String engineVersion,
        String city,
        String createdDate,
        Long ownerId,
        String ownerName,
        String ownerType,
        String contact
        ) {
}
