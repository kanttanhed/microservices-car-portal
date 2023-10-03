package com.github.kanttanhed.store.service;

import com.github.kanttanhed.store.dto.OwnerPostRECORD;
import com.github.kanttanhed.store.entity.OwnerPostEntity;
import com.github.kanttanhed.store.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    public void createOwnerPost(OwnerPostRECORD ownerPostRECORD){
        OwnerPostEntity ownerPost = new OwnerPostEntity();
        ownerPost.setName(ownerPost.getName());
        ownerPost.setType(ownerPost.getType());
        ownerPost.setContactNumber(ownerPost.getContactNumber());

        ownerPostRepository.save(ownerPost);
    }
}