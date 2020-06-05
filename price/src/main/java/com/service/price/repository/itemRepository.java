package com.service.price.repository;

import org.springframework.stereotype.Repository;

import com.service.price.models.Item;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface itemRepository extends JpaRepository<Item, Long> {

}