package com.example.PashaWeb.repository;

import com.example.PashaWeb.entity.Town;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TownsRepository extends MongoRepository <Town, String> {

}


