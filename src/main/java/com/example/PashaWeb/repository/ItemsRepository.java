package com.example.PashaWeb.repository;

import com.example.PashaWeb.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemsRepository extends MongoRepository <Item, String> {

}
