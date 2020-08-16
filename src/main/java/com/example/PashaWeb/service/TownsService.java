package com.example.PashaWeb.service;


import com.example.PashaWeb.entity.Town;
import com.example.PashaWeb.exception.IllegalInputException;
import com.example.PashaWeb.repository.TownsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TownsService {


   private final  TownsRepository townsRepository;


    public Town createTown(String name, String distance) {
        Town town = new Town();
        town.setName(name);
        try {
            int distanceInt = Integer.parseInt(distance);
            town.setDistance(distanceInt);
        } catch(NumberFormatException e) {
            throw new IllegalInputException("Не очень правильынй тип данных для NE KVONTITI A DYSTANCE");
        }
        townsRepository.save(town);
        return town;
    }

    public void deleteTown(String id) {
        townsRepository.deleteById(id);
    }

    public List<Town> showTown() {
        return townsRepository.findAll();
    }

    public Optional<Town> findOne(String id) {
        return townsRepository.findById(id);
    }
}
