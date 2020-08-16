package com.example.PashaWeb.repository;

import com.example.PashaWeb.entity.Shipping;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ShippingsRepository extends MongoRepository<Shipping, String> {

}
