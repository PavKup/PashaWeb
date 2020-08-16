package com.example.PashaWeb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Document(collection = "shippings")
public class Shipping implements Serializable {
    @Id
    private String id;
    private String items_id;
    private String towns_id;

    private LocalDate start_date;
    private LocalDate end_date;

    public Shipping(String items_id, String towns_id) {
        this.items_id = items_id;
        this.towns_id = towns_id;
    }
}
