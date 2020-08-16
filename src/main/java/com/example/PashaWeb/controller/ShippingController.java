package com.example.PashaWeb.controller;


import com.example.PashaWeb.entity.Shipping;
import com.example.PashaWeb.exception.EntityNotFoundException;
import com.example.PashaWeb.service.ShippingsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShippingController {
    private final ShippingsService shippingService;

    ShippingController(ShippingsService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("/shippings")
    List<Shipping> all() {
        return shippingService.showShippings();
    }

    @PostMapping("/shippings/{town_id}/{item_id}/{strat_date}/{end_date}")
    Shipping newShipping(@PathVariable String town_id, @PathVariable String item_id, @PathVariable String strat_date, @PathVariable  String end_date) {
        return shippingService.createShipping(town_id, item_id, strat_date, end_date);
    }

    @GetMapping("/shippings/{id}")
    Shipping getShipping(@PathVariable String id) {
        return shippingService.findOne(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @DeleteMapping("/shippings/{id}")
    void deleteShipping(@PathVariable String id) {

        shippingService.deleteShipping(id);
    }
}