package com.example.PashaWeb.service;


import com.example.PashaWeb.entity.Item;
import com.example.PashaWeb.exception.IllegalInputException;
import com.example.PashaWeb.repository.ItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ItemsService {

    private final ItemsRepository itemsRepository;


    public Item createItem(String name, String quantity) {
        Item item = new Item();
        item.setName(name);
        try {
            int quantityInt = Integer.parseInt(quantity);
            item.setQuantity(quantityInt);
        } catch (NumberFormatException e) {
            throw new IllegalInputException("Не очень правильынй тип данных для квонтити");
        }
        itemsRepository.save(item);
        return item;
    }

    public void deleteItem(String id) {
        itemsRepository.deleteById(id);
    }

    public List<Item> showItems() {
        return itemsRepository.findAll();
    }

    public Optional<Item> findOne(String id) {
        return itemsRepository.findById(id);
    }
}
