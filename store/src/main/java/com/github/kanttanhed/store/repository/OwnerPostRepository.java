package com.github.kanttanhed.store.repository;

import com.github.kanttanhed.store.entity.OwnerPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPostEntity, Long> {
}