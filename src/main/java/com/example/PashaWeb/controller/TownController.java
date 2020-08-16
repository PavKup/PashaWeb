package com.example.PashaWeb.controller;

import com.example.PashaWeb.entity.Town;
import com.example.PashaWeb.exception.EntityNotFoundException;
import com.example.PashaWeb.service.TownsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TownController {
    private final TownsService townsService;

    TownController(TownsService townsService) {
        this.townsService = townsService;
    }

    @GetMapping("/towns")
    List<Town> all() {
        return townsService.showTown();
    }

    @PostMapping("/towns/{name}/{distance}")
    Town newTown(@PathVariable String name, @PathVariable String distance) {
        return townsService.createTown(name, distance);
    }

    @GetMapping("/towns/{id}")
    Town getTown(@PathVariable String id) {
        return townsService.findOne(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @DeleteMapping("/towns/{id}")
    void deleteTown(@PathVariable String id) {
        townsService.deleteTown(id);
    }
}

