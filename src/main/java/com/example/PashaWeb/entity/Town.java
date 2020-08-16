package com.example.PashaWeb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Document(collection = "towns")
public class Town implements Serializable {
    @Id
    private String id;
    private String name;
    private int distance;
}
