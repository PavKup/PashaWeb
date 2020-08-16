package com.example.PashaWeb.service;


import com.example.PashaWeb.entity.Shipping;
import com.example.PashaWeb.exception.EntityNotFoundException;
import com.example.PashaWeb.exception.IllegalInputException;
import com.example.PashaWeb.repository.ShippingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor

public class ShippingsService {

   private final ItemsService itemsService;
   private final TownsService townsService;
   private final ShippingsRepository shippingsRepository;


    public Shipping createShipping(String town_id, String item_id, String strat_date, String end_date) {

        if (itemsService.findOne(item_id) == null) {
            throw new EntityNotFoundException(item_id);
        }

        if (townsService.findOne(town_id) == null) {
            throw new EntityNotFoundException(town_id);
        }

        if (strat_date == null || strat_date.isEmpty()) {
            throw new IllegalInputException("СТАРТ ДАТЕ РОВНА 0 КАК ТАК КАК ТАК...");
        }
        LocalDate start_date;
        try {
            start_date = LocalDate.parse(strat_date);
            //2007-12-03
        } catch (DateTimeParseException e) {
            throw new IllegalInputException("Не очень ПОЛУЧИЛ СТАРТ ДАТЕ");
        }
        LocalDate endDate = null;
        if (end_date != null || !end_date.isEmpty()) {
            try {
                endDate = LocalDate.parse(strat_date);
            } catch (DateTimeParseException e) {
                throw new IllegalInputException("Не верный формат даты");
            }
            if (start_date.isAfter(endDate)) {
                throw new IllegalInputException("Дата начала не должна быть...(ДОГАДАЙСЯ БЛЯТЬ ДАЛЬШЕ САМ КАКОЕ ЕБУЧИЕ ТХЗ)");
            }

        }

        Shipping shipping = new Shipping(item_id, town_id);
        shipping.setStart_date(start_date);
        shipping.setEnd_date(endDate);
        shippingsRepository.save(shipping);
        return shipping;
    }

    public void deleteShipping(String id) {
        shippingsRepository.deleteById(id);
    }

    public List<Shipping> showShippings() {
        return shippingsRepository.findAll();
    }


    public Optional<Shipping> findOne(String id) {
        return shippingsRepository.findById(id);
    }

}
