package com.github.kanttanhed.store.service;

import com.github.kanttanhed.store.dto.CarPostRECORD;
import com.github.kanttanhed.store.entity.CarPostEntity;
import com.github.kanttanhed.store.repository.CarPostRepository;
import com.github.kanttanhed.store.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    public void newPostDetails(CarPostRECORD carPostRECORD) {
        CarPostEntity carPostEntity = mapCarRecordToEntity(carPostRECORD);
        carPostRepository.save(carPostEntity);
    }

    public List<CarPostRECORD> getCarSales() {
        List<CarPostRECORD> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item -> {
            listCarsSales.add(mapCarEntityToDTO(item));
        });
        return listCarsSales;
    }

    public void changeCarSales(CarPostRECORD carPostRECORD, Long postId) {
        carPostRepository.findById(postId).ifPresentOrElse(item -> {
            item.setDescription(carPostRECORD.description());
            item.setContact(carPostRECORD.contact());
            item.setPrice(carPostRECORD.price());
            item.setBrand(carPostRECORD.brand());
            item.setEngineVersion(carPostRECORD.engineVersion());
            item.setModel(carPostRECORD.model());

            carPostRepository.save(item);

        }, () -> {
            throw new NoSuchElementException("Car post with ID " + postId + " not found");
        });
    }

    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }

    private CarPostEntity mapCarRecordToEntity(CarPostRECORD carPostRECORD) {
        CarPostEntity carPostEntity = new CarPostEntity();

        ownerPostRepository.findById(carPostRECORD.ownerId()).ifPresentOrElse(item -> {
            carPostEntity.setOwnerPost(item);
            carPostEntity.setContact(item.getContactNumber());
        }, () -> {
            throw new RuntimeException("Owner not found");
        });

        return carPostEntity;
    }

    private CarPostRECORD mapCarEntityToDTO(CarPostEntity carPostEntity) {
        return new CarPostRECORD(
                carPostEntity.getModel(),
                carPostEntity.getBrand(),
                carPostEntity.getPrice(),
                carPostEntity.getDescription(),
                carPostEntity.getEngineVersion(),
                carPostEntity.getCity(),
                carPostEntity.getCreatedDate(),
                carPostEntity.getOwnerPost().getId(), // Adicione o ID do proprietário aqui
                carPostEntity.getOwnerPost().getName(),
                carPostEntity.getOwnerPost().getContactNumber(),
                carPostEntity.getContact()
        );
    }
}