package com.example.PashaWeb.controller;

import com.example.PashaWeb.entity.Item;
import com.example.PashaWeb.exception.EntityNotFoundException;
import com.example.PashaWeb.service.ItemsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private final ItemsService itemsService;

    ItemController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/items")
    List<Item> all() {
        return itemsService.showItems();
    }

    @PostMapping("/items/{name}/{quantity}")
    Item newItem(@PathVariable String name, @PathVariable String quantity) {
        return itemsService.createItem(name, quantity);
    }

    @GetMapping("/items/{id}")
    Item getItem(@PathVariable String id) {
        return itemsService.findOne(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @DeleteMapping("/items/{id}")
    void deleteItem(@PathVariable String id) {

        itemsService.deleteItem(id);
    }
}
